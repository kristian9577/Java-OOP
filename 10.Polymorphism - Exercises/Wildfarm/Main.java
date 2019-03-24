package Wildfarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int counter = 0;
        Animal animal = null;
        List<Animal> animals = new ArrayList<>();

        while (!input.equals("End")) {
            String[] lines = input.split("\\s+");

            if (counter % 2 == 0) {
                String animalType = lines[0];
                String animalName = lines[1];
                double animalWeight = Double.parseDouble(lines[2]);
                String animalLivingRegion = lines[3];

                switch (animalType) {
                    case "Cat":
                        String breed = lines[4];
                        animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
                        break;
                    case "Tiger":
                        animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                    case "Zebra":
                        animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                    case "Mouse":
                        animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                }
                animals.add(animal);
            } else {
                String foodType = lines[0];
                int foodQuantity = Integer.parseInt(lines[1]);
                Food food = null;
                if (foodType.equals("Meat")) {
                    food = new Meat(foodQuantity);
                } else if (foodType.equals("Vegetable")) {
                    food = new Vegetable(foodQuantity);
                }

                animals.get(animals.size() - 1).makeSound();
                animal.eat(food);
            }


            input = reader.readLine();
            counter++;
        }
        animals.forEach(System.out::println);
    }
}