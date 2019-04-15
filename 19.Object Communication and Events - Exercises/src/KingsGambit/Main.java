package KingsGambit;

import KingsGambit.interfaces.Defender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String kingName = reader.readLine();
        Map<String, Defender> army = new LinkedHashMap<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .forEach(name -> army.put(name, new RoyalGuard(name)));
        Arrays.stream(reader.readLine().split("\\s+"))
                .forEach(name -> army.put(name, new Footmen(name)));
        King king = new King(kingName, army);
        String command = reader.readLine();

        while (!command.equalsIgnoreCase("End")) {
            String[] tokens = command.split("\\s+");

            if (tokens[0].equalsIgnoreCase("kill")) {
                army.remove(tokens[1]);
            } else {
                king.onAttacked();
            }

            command = reader.readLine();
        }
    }
}
