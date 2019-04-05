package models.boat;

import models.engine.Engine;

public abstract class MotorBoats extends Boat {
    private Engine engine;

    public MotorBoats(String model, double weight, Engine engine) {
        super(model, weight);
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
