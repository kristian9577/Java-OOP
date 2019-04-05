package models.boat;

import models.engine.Engine;

public class PowerBoat extends MotorBoats {

    private Engine secondEngine;

    public PowerBoat(String model, double weight, Engine engine, Engine secondEngine) {
        super(model, weight,engine);
        this.secondEngine = secondEngine;
    }

    public Engine getSecondEngine() {
        return secondEngine;
    }

    public void setSecondEngine(Engine secondEngine) {
        this.secondEngine = secondEngine;
    }
}
