package greedyTimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long capacity = Long.parseLong(reader.readLine());

        Bag bag = new Bag(capacity);

        String[] input = reader.readLine().split("\\s+");

        for (int i = 0; i < input.length; i += 2) {
            String item = input[i];
            long weight = Long.parseLong(input[i + 1]);

            if (item.length() == 3) {
                bag.addCash(item, weight);
            } else if (item.toLowerCase().endsWith("gem") && item.length() > 3) {
                bag.addGems(item,weight);
            }else if(item.equalsIgnoreCase("gold")){
                bag.addGold(weight);
            }
        }

        System.out.println(bag.toString());
    }
}