package CarShopExtended;

public class Seat extends BaseCar implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower,
                String countryProduces, Double price) {

        super(model, color, horsePower, countryProduces);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "\nLeon sells for %f", getPrice());
    }
}
