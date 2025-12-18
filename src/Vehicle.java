public class Vehicle {

    private String brand;
    private double pricePerDay;

    public Vehicle(String brand, double pricePerDay) {
        this.brand = brand;
        this.pricePerDay = pricePerDay;
    }

    public String getBrand() {
        return brand;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
}
