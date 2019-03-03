package PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rectangleCoords = getCoords(reader);

        Point topLeft = new Point(rectangleCoords[0], rectangleCoords[1]);
        Point bottomRight = new Point(rectangleCoords[2], rectangleCoords[3]);

        Rectangle rectangle = new Rectangle(topLeft, bottomRight);

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            int[] pointCoords = getCoords(reader);

            Point point = new Point(pointCoords[0], pointCoords[1]);

            System.out.println(rectangle.contains(point));
        }
    }

    private static int[] getCoords(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
