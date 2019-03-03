package HotelReservation;

public class PriceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discount = discount;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double calculatePrice(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        int multiplier = season.getValue();
        double discountMultiplier = discount.getValue() / 100.0;

        double priceBeforeDiscount = numberOfDays * pricePerDay * multiplier;
        double discountedAmount = priceBeforeDiscount * discountMultiplier;

        return priceBeforeDiscount - discountedAmount;
    }
}
