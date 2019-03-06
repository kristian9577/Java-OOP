package Cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CardSuits[] cards =CardSuits.values();

        System.out.println(reader.readLine()+":");

        for (CardSuits card : cards) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    card.ordinal(),card.name()));
        }
    }
}
