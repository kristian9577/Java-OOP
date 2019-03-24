package Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicles {

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public String drive(double distance) {
        double totalConsumption = this.getLitersPerKm() + 0.9;
        if (totalConsumption * distance > this.getFuelQuantity()) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.setFuelQuantity(this.getFuelQuantity() - totalConsumption * distance);
        DecimalFormat df=new DecimalFormat("#.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
    }

    @Override
    public void refuel(double litres) {
        this.setFuelQuantity(this.getFuelQuantity() + litres);
    }
}
