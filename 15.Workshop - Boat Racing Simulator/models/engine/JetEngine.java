package models.engine;

public class JetEngine extends Engine {
    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    double calculateOutput() {
        return this.getHorsepower() * 5 + this.getDisplacement();
    }
}
