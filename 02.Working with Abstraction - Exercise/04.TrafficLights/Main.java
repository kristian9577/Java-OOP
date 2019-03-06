package TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Light[] lights = Arrays.stream(reader.readLine()
                .split(" "))
                .map(signal -> new Light(Signal.valueOf(signal)))
                .toArray(Light[]::new);

        int numberOfLightChanges = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfLightChanges; i++) {
            for (Light light : lights) {
                light.changeSignal();
                System.out.print(light + " ");
            }
            System.out.println();
        }
    }
}
