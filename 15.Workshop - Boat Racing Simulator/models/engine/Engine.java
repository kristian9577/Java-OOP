package models.engine;

public abstract class Engine {
    private String model;
    private double output;
    private int horsepower;
    private int displacement;

    public Engine(String model, int horsepower, int displacement) {
        this.model = model;
        this.horsepower = horsepower;
        this.displacement = displacement;
        this.output = this.calculateOutput();
    }

    abstract double calculateOutput();

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getOutput() {
        return output;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }
}
