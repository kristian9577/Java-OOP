package FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();

        String input = reader.readLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String teamName = tokens[1];

            try {
                if (command.equals("Team")) {
                    teams.putIfAbsent(teamName, new Team(teamName));
                } else if (command.equals("Add")) {
                    if (!teams.containsKey(teamName)) {
                        throw new IllegalArgumentException("Team " + teamName + " does not exist.");
                    }
                    teams.get(teamName).addPlayer(new Player(tokens[2],
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6]),
                            Integer.parseInt(tokens[7])));
                } else if (command.equals("Remove")) {
                    teams.get(teamName).removePlayer(tokens[2]);
                } else {
                    if (!teams.containsKey(teamName)) {
                        throw new IllegalArgumentException("Team " + teamName + " does not exist.");
                    }
                    System.out.println(teamName + " - " + (int)teams.get(teamName).getRatting());
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            input = reader.readLine();
        }
    }
}
