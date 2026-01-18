public class Main {

    public static void main(String[] args) throws Exception {

        Client client = new Client("Alex");
        Vehicle car = new Vehicle("Toyota", 50);

        ClientDAO clientDAO = new ClientDAO();
        VehicleDAO vehicleDAO = new VehicleDAO();
        RentalDAO rentalDAO = new RentalDAO();

        int clientId = clientDAO.addClient(client);
        int vehicleId = vehicleDAO.addVehicle(car);

        rentalDAO.addRental(clientId, vehicleId, 3);

        System.out.println("После вставки:");
        rentalDAO.readRentals();

        rentalDAO.updateDays(1, 5); // обновили days на 5

        System.out.println("После обновления:");
        rentalDAO.readRentals();

        rentalDAO.deleteRental(1); // удалили запись

        System.out.println("После удаления:");
        rentalDAO.readRentals();
    }
}
