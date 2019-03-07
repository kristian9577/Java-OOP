package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return this.money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        if (this.money - product.getCost() < 0) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }
        this.products.add(product);
        this.setMoney(this.money - product.getCost());
        System.out.println(String.format("%s bought %s", this.name, product.getName()));

    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return this.name + " - Nothing bought";
        }
        return this.name +
                " - " +
                this.products
                        .stream()
                        .map(Product::toString)
                        .collect(Collectors.joining(", "));
    }
}