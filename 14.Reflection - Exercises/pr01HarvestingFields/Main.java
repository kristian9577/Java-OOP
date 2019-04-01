package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Field[] fields = RichSoilLand.class.getDeclaredFields();

        Consumer<Field> printer = f -> System.out.println(String.format("%s %s %s",
                Modifier.toString(f.getModifiers()),
                f.getType().getSimpleName(),
                f.getName()));

        while (!input.equalsIgnoreCase("harvest")) {

            String finalInput = input;
            Field[] requestedFields = Arrays.stream(fields)
                    .filter(f -> Modifier.toString(f.getModifiers())
                            .equalsIgnoreCase(finalInput)
                    ).toArray(Field[]::new);

            if (requestedFields.length != 0) {
                Arrays.stream(requestedFields).forEach(printer);
            }else{
                Arrays.stream(fields).forEach(printer);
            }

            input = reader.readLine();
        }
    }
}
