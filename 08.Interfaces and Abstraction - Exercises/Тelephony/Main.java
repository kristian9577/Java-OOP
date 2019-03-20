package Тelephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> phoneNumbers = Arrays.stream(bufferedReader.readLine()
                .split("\\s+"))
                .collect(Collectors.toList());
        List<String> urls = Arrays.stream(bufferedReader.readLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(phoneNumbers, urls);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}
