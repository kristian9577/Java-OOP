package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Vehicles car = createVehicle(reader);
        Vehicles truck = createVehicle(reader);

        int n =Integer.parseInt(reader.readLine());

        for (int i = 0; i <n ; i++) {
            String[] lines=reader.readLine().split("\\s+");
            String command=lines[0];
            String vehiclesType=lines[1];
            double value=Double.parseDouble(lines[2]);

            if (command.equals("Drive")) {
                if (vehiclesType.equals("Car")) {
                    System.out.println(car.drive(value));
                } else if (vehiclesType.equals("Truck")) {
                    System.out.println(truck.drive(value));
                }
            } else if (command.equals("Refuel")) {
                if (vehiclesType.equals("Car")) {
                    car.refuel(value);
                } else if (vehiclesType.equals("Truck")) {
                    truck.refuel(value);
                }
            } else {
                break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        }
    private static Vehicles createVehicle(BufferedReader bufferedReader) throws IOException {
        String[] lines = bufferedReader.readLine().split("\\s+");

        String vehicleType = lines[0];
        double fuelQuantity = Double.parseDouble(lines[1]);
        double fuelConsumption = Double.parseDouble(lines[2]);

        if ("Car".equals(vehicleType)) {
            return new Car(fuelQuantity, fuelConsumption);
        } else if ("Truck".equals(vehicleType)) {
            return new Truck(fuelQuantity, fuelConsumption);
        }
        return null;
    }
    }

