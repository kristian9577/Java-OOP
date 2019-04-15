package DependencyInversion;

public class Calculator {

    private Operation operation;

    public Calculator() {
        this.operation = new Addition();
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int calculate(int first, int second) {
        return this.operation.execute(first, second);
    }
}
