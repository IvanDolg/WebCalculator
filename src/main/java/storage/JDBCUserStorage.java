package storage;

import domain.User;

import java.sql.*;
import java.util.Optional;

public class JDBCUserStorage {
    private final String url = "jdbc:postgresql://localhost:5432/calculator";
    private final String userName = "postgres";
    private final String password = "root";
    public void save(User user){
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO greeting VALUES (DEFAULT, ?, ?, ?, ?);")){

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> getByUsername(String username){
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement("select * from greeting where userName = ?")){

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String username2 = resultSet.getString(3);
                String password = resultSet.getString(4);
                String role = resultSet.getString(5);

                return Optional.of(new User(id, name, username2, password, role));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
