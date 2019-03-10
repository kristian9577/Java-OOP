package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        try {
            FlourType.valueOf(flourType);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
            BakingTechnique.valueOf(bakingTechnique);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = 2 * this.weight;
        if (this.flourType.equals(FlourType.White.toString())) {
            calories *= 1.5;
        }
        if (this.bakingTechnique.equals(BakingTechnique.Crispy.toString())) {
            calories *= 0.9;
        } else if (this.bakingTechnique.equals(BakingTechnique.Chewy.toString())) {
            calories *= 1.1;
        }
        return calories;
    }
}
