package jediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimension = Arrays.stream(reader.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Galaxy galaxy = new Galaxy(dimension[0], dimension[1]);
        StarsManipulator starsManipulator = new StarsManipulator(galaxy);

        String input = reader.readLine();
        long sum = 0;

        while (!input.equals("Let the Force be with you")) {
            int[] playerPositions = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] enemyPositions = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            starsManipulator.destroyStars(enemyPositions);
            sum += starsManipulator.sumOfStars(playerPositions);

            input = reader.readLine();
        }
        System.out.println(sum);
    }
}
