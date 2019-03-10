package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Pizza pizza;
    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            getPizzaData();
            getDoughData();
            addToppings();

            System.out.println(pizza.getOverallCalories());

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void addToppings() throws IOException {
        for (int i = 0; i < pizza.getToppingsCount(); i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String type = tokens[1];
            double weight = Double.parseDouble(tokens[2]);
            Topping topping = new Topping(type, weight);
            pizza.addTopping(topping);
        }
    }

    private static void getDoughData() throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        String flourType = tokens[1];
        String bakingTechnique = tokens[2];
        double weight = Double.parseDouble(tokens[3]);
        Dough dough = new Dough(flourType, bakingTechnique, weight);
        pizza.setDough(dough);
    }

    private static void getPizzaData() throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        String pizzaName = tokens[1];
        int numberOfToppings = Integer.parseInt(tokens[2]);
        pizza = new Pizza(pizzaName, numberOfToppings);
    }
}