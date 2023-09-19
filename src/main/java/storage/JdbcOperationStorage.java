package storage;

import domain.Operation;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOperationStorage {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String userName = "postgres";
    private final String password = "root";

    public void save (Operation operation, User user){
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO opData VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setDouble(2, operation.getNum1());
            preparedStatement.setDouble(3, operation.getNum2());
            preparedStatement.setDouble(4, operation.getResult());
            preparedStatement.setString(5, operation.getType());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Operation> findByUser(User user){
        List<Operation> list = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  opData WHERE AUTHOR_ID = ?")){

            preparedStatement.setInt(1, user.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                double resNum1 = resultSet.getDouble("num1");
                double resNum2 = resultSet.getDouble("num2");
                double resResult = resultSet.getDouble("result");
                String resType = resultSet.getString("type");

                Operation operation = new Operation(resNum1, resNum2, resResult, resType);
                list.add(operation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}