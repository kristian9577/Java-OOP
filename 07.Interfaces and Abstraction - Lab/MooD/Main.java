package MooD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] character = reader.readLine().split(" \\| ");

        Character unit;
        String username = character[0];
        String characterType = character[1];
        switch (characterType) {
            case "Demon":
                unit = new Demon(username, Integer.parseInt(character[3]), Double.parseDouble(character[2]));
                System.out.println(unit.toString());
                break;
            case "Archangel":
                unit = new Archangel(username, Integer.parseInt(character[3]), Integer.parseInt(character[2]));
                System.out.println(unit.toString());
                break;
            default:
                break;
        }
    }
}