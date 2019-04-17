package hell;

import hell.entities.ManagerImpl;
import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.interfaces.Hero;
import hell.interfaces.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Manager manager = new ManagerImpl();

        String commandLine = reader.readLine();

        while (!commandLine.equals("Quit")) {
            String[] tokens = commandLine.split("\\s+");
            String commandName = tokens[0];
            String result = "";

            switch (commandName) {
                case "Hero":
                    result = manager.addHero(Arrays.asList(tokens[1], tokens[2]));
                    break;
                case "Item":
                    result = manager.addItem(Arrays.asList(tokens));
                    break;
                case "Recipe":
                    result = manager.addRecipe(Arrays.asList(tokens));
                    break;
                case "Inspect":
                    result = manager.inspect(Arrays.asList(tokens));
                    break;
            }

            System.out.println(result);
            commandLine = reader.readLine();
        }
        System.out.println(manager.quit());
    }

}