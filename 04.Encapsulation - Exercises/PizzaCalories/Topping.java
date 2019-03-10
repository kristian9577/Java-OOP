package PizzaCalories;


public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        try {
            ToppingType.valueOf(toppingType);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = 2 * this.weight;
        if (this.toppingType.equals(ToppingType.Meat.toString())) {
            calories *= 1.2;
        } else if (this.toppingType.equals(ToppingType.Veggies.toString())) {
            calories *= 0.8;
        } else if (this.toppingType.equals(ToppingType.Cheese.toString())) {
            calories *= 1.1;
        } else if (this.toppingType.equals(ToppingType.Sauce.toString())) {
            calories *= 0.9;
        }
        return calories;
    }
}
