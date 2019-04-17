package carTrip;

public class Car {
    private String model;
    private double tankCapacity;
    private double fuelAmount;
    private double fuelConsumptionPerKm;

    public Car(String model, double tankCapacity, double fuelAmount, double fuelConsumptionPerKm) {
        this.setModel(model);
        this.setTankCapacity(tankCapacity);
        this.setFuelAmount(fuelAmount);
        this.setFuelConsumptionPerKm(fuelConsumptionPerKm);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model is required");
        }


        this.model = model;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {


        if (fuelAmount > this.getTankCapacity()) {
            throw new IllegalArgumentException("Fuel Amount cannot be more than tank capacity");
        }

        this.fuelAmount = fuelAmount;

    }

    public double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }

    public void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        if (fuelConsumptionPerKm <= 0) {
            throw new IllegalArgumentException("Invalid Fuel Consumption Per Km");
        }

        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public String drive(double distance) {
        double tripConsumotion = distance * this.getFuelConsumptionPerKm();

        if (this.getFuelAmount() < tripConsumotion) {
            throw new IllegalStateException("Cannot travel this distance");
        }

        this.setFuelAmount(this.getFuelAmount() - tripConsumotion);
        return "Have a nice trip";
    }

    public void refuel(double fuelAmount) {
        double totalFuelAmount = this.getFuelAmount() + fuelAmount;

        if (totalFuelAmount > this.getTankCapacity()) {
            throw new IllegalStateException(String.format("Cannot fill %.2f in the tank", this.fuelAmount));
        }

        this.setFuelAmount(totalFuelAmount);
    }
}
