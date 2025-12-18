public class Main {

    public static void main(String[] args) {

        Vehicle car1 = new Vehicle("Toyota", 50);
        Vehicle car2 = new Vehicle("BMW", 80);

        Client client1 = new Client("Alex");
        Client client2 = new Client("John");

        RentalService rent1 = new RentalService(car1, client1, 3);
        RentalService rent2 = new RentalService(car2, client2, 3);

        rent1.printInfo();
        System.out.println();
        rent2.printInfo();

        if (rent1.getTotalPrice() > rent2.getTotalPrice()) {
            System.out.println("First rental is more expensive");
        } else {
            System.out.println("Second rental is more expensive");
        }
    }
}
