package carTrip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    private static final String DEFAULT_MODEL = "BMW";
    private static final double DEFAULT_CAPACITY = 60;
    private Car car;
    private static final double DEFAULT_FUEL_AMOUNT = 10;
    private static final double DEFAULT_CONSUMPTION = 9;

    @Before
    public void before() {
        this.car = new Car(DEFAULT_MODEL,
                DEFAULT_CAPACITY, DEFAULT_FUEL_AMOUNT, DEFAULT_CONSUMPTION);
    }

    @Test
    public void getModelShouldWorkCorrectly() {
        Assert.assertEquals(DEFAULT_MODEL, this.car.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setModelShouldThrowIfModelIsNull() {
        this.car.setModel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setModelShouldThrowIfModelIsEmptyString() {
        this.car.setModel("");
    }

    @Test
    public void setModelShouldSetCorrectly() {
        this.car.setModel("Mercedes");
        Assert.assertEquals("Mercedes", this.car.getModel());
    }

    @Test
    public void getTankCapacityShouldWorkCorrectly() {
        Assert.assertEquals(DEFAULT_CAPACITY, this.car.getTankCapacity(), 0.0);
    }

    @Test
    public void setTankCapacityShouldWorkCorrectly() {
        double newCapacity = 50;
        this.car.setTankCapacity(newCapacity);
        Assert.assertEquals(newCapacity, this.car.getTankCapacity(), 0.0);
    }

    @Test
    public void getFuelAmountShouldWorkCorrectly() {
        Assert.assertEquals(DEFAULT_FUEL_AMOUNT, this.car.getFuelAmount(), 0.0);
    }

    @Test
    public void setFuelAmountShouldWorkCorrectly() {
        double newFuelAmount = 50;
        this.car.setFuelAmount(newFuelAmount);
        Assert.assertEquals(newFuelAmount, this.car.getFuelAmount(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelAmountShouldThrowIfAmountIsGreaterThanCapacity() {
        this.car.setFuelAmount(DEFAULT_CAPACITY + 1);
    }

    @Test
    public void getFuelConsumptionShouldWorkCorrectly() {
        Assert.assertEquals(DEFAULT_CONSUMPTION, this.car.getFuelConsumptionPerKm(), 0.0);
    }

    @Test
    public void setFuelConsumptionShouldWorkCorrectly() {
        double newFuel = 50;
        this.car.setFuelConsumptionPerKm(newFuel);
        Assert.assertEquals(newFuel, this.car.getFuelConsumptionPerKm(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionShouldThrowWithNegativeConsumption() {
        this.car.setFuelConsumptionPerKm(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIfModelIsEmpty() {
        new Car("", 1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIfModelIsNull() {
        new Car(null, 1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIfFuelAmountGreaterThanCapaciyt() {
        new Car("valid", 1, 2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIfFuelConsumptionIsNegative() {
        new Car("valid", 1, 1, -1);
    }

    @Test(expected = IllegalStateException.class)
    public void driveShouldThrowIfNotEnoughFuel() {
        this.car.drive(2);
    }

    @Test
    public void driveShouldUseFuel() {
        this.car.drive(1);
        Assert.assertEquals(DEFAULT_FUEL_AMOUNT - DEFAULT_CONSUMPTION, this.car.getFuelAmount(), 0.0);
    }

    @Test
    public void driveShouldReturnCorrectResult() {
        String result = this.car.drive(1);
        Assert.assertEquals("Have a nice trip", result);
    }

    @Test(expected = IllegalStateException.class)
    public void refuelShouldThrowIfFuelIsMoreThanEnough() {
        this.car.refuel(DEFAULT_CAPACITY + 1);
    }

    @Test
    public void refuelShouldWorkCorrectly() {
        double amount = 10;
        this.car.refuel(amount);
        Assert.assertEquals(amount + DEFAULT_FUEL_AMOUNT, this.car.getFuelAmount(), 0.0);
    }
}