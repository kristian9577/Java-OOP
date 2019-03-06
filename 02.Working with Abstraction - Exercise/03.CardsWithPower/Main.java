package CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank = reader.readLine();
        String suit = reader.readLine();

        System.out.println(String.format("Card name: %s of %s; Card power: %d",
                RankPowers.valueOf(rank), SuitPowers.valueOf(suit),
                RankPowers.valueOf(rank).getValue() + SuitPowers.valueOf(suit).getValue()
        ));
    }
}
