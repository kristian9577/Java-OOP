package AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        try {
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken.toString());
        } catch (InvalidParameterException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
