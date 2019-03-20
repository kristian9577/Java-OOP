package BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        List<Birthable> allWithBirthDate = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            if (tokens[0].equals("Citizen")) {
                Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                allWithBirthDate.add(citizen);
            } else if (tokens[0].equals("Pet")) {
                Pet pet=new Pet(tokens[1],tokens[2]);
                allWithBirthDate.add(pet);
            }else if(tokens[0].equals("Robot")){
                Robot robot=new Robot(tokens[1],tokens[2]);
            }
            input = reader.readLine();
        }
        String year=reader.readLine();

        for (Birthable birthable : allWithBirthDate) {
          if(birthable.getBirthDate().endsWith(year)){
              System.out.println(birthable.getBirthDate());
          }
        }
    }

}
