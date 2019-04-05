package models.boat;

import models.engine.Engine;

public class Yacht extends MotorBoats {

    private double cargo;

    public Yacht(String model, double weight, Engine engine, double cargo) {
        super(model, weight,engine);
        this.cargo = cargo;
    }



    public double getCargo() {
        return cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }
}
