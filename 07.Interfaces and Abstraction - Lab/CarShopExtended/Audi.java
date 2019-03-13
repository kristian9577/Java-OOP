package CarShopExtended;

public class Audi extends BaseCar implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower,
                String countryProduces, Integer minRentDay, Double pricePerDay) {

        super(model, color, horsePower, countryProduces);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nMinimum rental period of %d days. Price per day %f",
                getMinRentDay(), getPricePerDay());
    }
}
