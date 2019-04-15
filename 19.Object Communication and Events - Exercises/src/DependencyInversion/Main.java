package DependencyInversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Calculator calculator = new Calculator();
        OperationFactory operationFactory = new OperationFactory();

        String input = reader.readLine();

        while (!input.equalsIgnoreCase("end")) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equalsIgnoreCase("mode")) {
                calculator.setOperation(operationFactory.produce(tokens[1]));
            } else {
                System.out.println(calculator.calculate(Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1])));
            }

            input = reader.readLine();
        }
    }
}
