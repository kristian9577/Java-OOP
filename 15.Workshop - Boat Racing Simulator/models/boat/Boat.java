package models.boat;

import java.util.Objects;

public class Boat {
    private String model;
    private double weight;

    public Boat(String model, double weight) {
        this.model = model;
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boat)) return false;
        Boat boat = (Boat) o;
        return Objects.equals(model, boat.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }
}
