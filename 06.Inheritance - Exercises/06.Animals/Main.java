package Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String infoForAnimalType = reader.readLine();
            if("Beast!".equals(infoForAnimalType))
                break;

            makeAnimals(reader, infoForAnimalType);

        }


    }

    private static void makeAnimals(BufferedReader reader, String infoForAnimalType) throws IOException {
        String[] animalInfo = reader.readLine().split(" ");

        switch (infoForAnimalType){
            case "Animal" :
                try{
                    Animal animal = new Animal(animalInfo[0],Integer.parseInt(animalInfo[1]),animalInfo[2]);
                    System.out.println(infoForAnimalType);
                    System.out.printf("%s %s %s\n",animalInfo[0],animalInfo[1],animalInfo[2]);
                    System.out.println(animal.produceSound());
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            case "Dog":
                try{
                    Dog dog = new Dog(animalInfo[0],Integer.parseInt(animalInfo[1]),animalInfo[2]);
                    System.out.println(infoForAnimalType);
                    System.out.printf("%s %s %s\n",animalInfo[0],animalInfo[1],animalInfo[2]);
                    System.out.println(dog.produceSound());
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            case "Cat":
                try{
                    Cat cat = new Cat(animalInfo[0],Integer.parseInt(animalInfo[1]),animalInfo[2]);
                    System.out.println(infoForAnimalType);
                    System.out.printf("%s %s %s\n",animalInfo[0],animalInfo[1],animalInfo[2]);
                    System.out.println(cat.produceSound());
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            case "Frog":
                try{
                    Frog frog = new Frog(animalInfo[0],Integer.parseInt(animalInfo[1]),animalInfo[2]);
                    System.out.println(infoForAnimalType);
                    System.out.printf("%s %s %s\n",animalInfo[0],animalInfo[1],animalInfo[2]);
                    System.out.println(frog.produceSound());
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            case "Kitten":
                try{
                    Kitten kitten = new Kitten(animalInfo[0],Integer.parseInt(animalInfo[1]),animalInfo[2]);
                    System.out.println(infoForAnimalType);
                    System.out.printf("%s %s Female\n",animalInfo[0],animalInfo[1]);
                    System.out.println(kitten.produceSound());
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            case "Tomcat":
                try{
                    Tomcat tomcat = new Tomcat(animalInfo[0],Integer.parseInt(animalInfo[1]),animalInfo[2]);
                    System.out.println(infoForAnimalType);
                    System.out.printf("%s %s Male\n",animalInfo[0],animalInfo[1]);
                    System.out.println(tomcat.produceSound());
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
                break;
        }
    }

}
