package DependencyInversion;

public class OperationFactory {
    public Operation produce(String operator) {

        Operation operation = null;


        if (operator.equalsIgnoreCase("+")) {
            operation = new Addition();
        } else if (operator.equalsIgnoreCase("-")) {
            operation = new Substraction();
        } else if (operator.equalsIgnoreCase("*")) {
            operation = new Multiplication();
        } else if (operator.equalsIgnoreCase("/")) {
            operation = new Division();
        }

        return operation;
    }
}
