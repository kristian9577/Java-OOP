package AnimalFarm;

import java.security.InvalidParameterException;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new InvalidParameterException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 1 || age > 15) {
            throw new InvalidParameterException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.age <= 5) {
            return 2;
        } else if (this.age <= 11) {
            return 1;
        } else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.0f eggs per day.",
                this.name, this.age, this.productPerDay());
    }
}
