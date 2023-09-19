package domain;

public class Operation {
    private int id;
    private double num1;
    private double num2;
    private double result;
    private String type;

    public Operation(double num1, double num2, double result, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.type = type;
    }

    public Operation(int id, double num1, double num2, String type) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public Operation(int id, double num1, double num2, double result, String type) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", result=" + result +
                ", type='" + type + '\'' +
                '}';
    }
}
