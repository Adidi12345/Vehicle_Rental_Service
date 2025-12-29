public class Car extends Vehicle {

    public Car(String brand, double pricePerDay) {
        super(brand, pricePerDay);
    }

    @Override
    public String getType() {
        return "Car";
    }
}
