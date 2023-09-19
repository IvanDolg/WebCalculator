package services;

import domain.Operation;
import domain.User;
import storage.JdbcOperationStorage;

import java.util.ArrayList;
import java.util.List;

public class OperationService {
    private final JdbcOperationStorage operationStorage = new JdbcOperationStorage();

    public OperationService() {
    }

    public Operation calculate (Operation operation, User user){
        switch (operation.getType()){
            case "sum":
                operation.setResult(operation.getNum1() + operation.getNum2());
                operationStorage.save(operation, user);
                return operation;
            case "sub":
                operation.setResult(operation.getNum1() - operation.getNum2());
                operationStorage.save(operation, user);
                return operation;
            case "mul":
                operation.setResult(operation.getNum1() * operation.getNum2());
                operationStorage.save(operation, user);
                return operation;
            case "div":
                operation.setResult(operation.getNum1() / operation.getNum2());
                operationStorage.save(operation, user);
                return operation;
        }
        return operation;
    }
    public List<String> getHistoryByUser(User user) {

        List<Operation> allData = operationStorage.findByUser(user);
        List<String> result = new ArrayList<>();

        for (Operation operation : allData) {
            result.add(operation.toString());
        }

        return result;
    }

}
