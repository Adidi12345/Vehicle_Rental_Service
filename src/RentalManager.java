import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RentalManager {

    private List<RentalService> rentals = new ArrayList<>();

    // Data pool
    public void addRental(RentalService rental) {
        rentals.add(rental);
    }

    // Searching
    public List<RentalService> searchByClientName(String name) {
        List<RentalService> result = new ArrayList<>();
        for (RentalService r : rentals) {
            if (r.getClient().getName().equalsIgnoreCase(name)) {
                result.add(r);
            }
        }
        return result;
    }

    // Filtering
    public List<RentalService> filterByMinPrice(double minPrice) {
        List<RentalService> result = new ArrayList<>();
        for (RentalService r : rentals) {
            if (r.getTotalPrice() >= minPrice) {
                result.add(r);
            }
        }
        return result;
    }

    // Sorting
    public List<RentalService> sortByTotalPrice() {
        rentals.sort(Comparator.comparingDouble(RentalService::getTotalPrice));
        return rentals;
    }
}
