package MordorCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] foods=reader.readLine().split("\\s+");

        Gandalf gandalf=new Gandalf();

        for (String food : foods) {
            gandalf.eatFood(food);
        }
        System.out.println(gandalf.getFoodPoints());
        System.out.println(gandalf.getMood());
    }
}
