public class RentalService {

    private Vehicle vehicle;
    private Client client;
    private int days;

    public RentalService(Vehicle vehicle, Client client, int days) {
        this.vehicle = vehicle;
        this.client = client;
        this.days = days;
    }

    public double getTotalPrice() {
        return days * vehicle.getPricePerDay();
    }

    public void printInfo() {
        System.out.println("Client: " + client.getName());
        System.out.println("Vehicle: " + vehicle.getBrand());
        System.out.println("Days: " + days);
        System.out.println("Total price: " + getTotalPrice());
    }
}
