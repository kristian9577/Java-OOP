package ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        Box box = new Box(length, width, height);
        double surfaceArea = box.calculateSurfaceArea();
        double lateralArea = box.calculateLateralSurfaceArea();
        double volume = box.calculateVolume();


         System.out.printf("Surface Area - %.2f\n", surfaceArea);
         System.out.printf("Lateral Area - %.2f\n", lateralArea);
         System.out.printf("Volume - %.2f", volume);
    }
}
