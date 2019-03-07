package ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static Map<String, Person> people = new LinkedHashMap<>();
    private static Map<String, Product> products = new LinkedHashMap<>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            getPeople();
            getProducts();

            String input;
            while (!"end".equalsIgnoreCase(input = reader.readLine())) {
                String[] tokens = input.split("\\s+");
                String name = tokens[0];
                String productName = tokens[1];
                if (people.containsKey(name) && products.containsKey(productName)) {
                    Person person = people.get(name);
                    Product product = products.get(productName);

                    person.buyProduct(product);
                }
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        people.values()
                .forEach(System.out::println);
    }

    private static void getProducts() throws IOException {
        String[] tokens = getArray();
        for (int i = 0; i < tokens.length; i += 2) {
            String name = tokens[i];
            double price = Double.parseDouble(tokens[i + 1]);
            products.putIfAbsent(name, new Product(name, price));
        }
    }

    private static void getPeople() throws IOException {
        String[] tokens = getArray();
        for (int i = 0; i < tokens.length; i += 2) {
            String name = tokens[i];
            double money = Double.parseDouble(tokens[i + 1]);
            people.putIfAbsent(name, new Person(name, money));
        }
    }

    private static String[] getArray() throws IOException {
        return reader.readLine().split("[=;]");
    }

}
