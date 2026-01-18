import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RentalDAO {


    public void addRental(int clientId, int vehicleId, int days) throws Exception {
        String sql = "INSERT INTO rentals(client_id, vehicle_id, days) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, clientId);
            ps.setInt(2, vehicleId);
            ps.setInt(3, days);
            ps.executeUpdate();
        }
    }

    public void readRentals() throws Exception {
        String sql = "SELECT r.id, c.name, v.brand, r.days " +
                "FROM rentals r " +
                "JOIN clients c ON r.client_id = c.id " +
                "JOIN vehicles v ON r.vehicle_id = v.id";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("brand") + " | " +
                                rs.getInt("days")
                );
            }
        }
    }



    public void updateDays(int rentalId, int newDays) throws Exception {
        String sql = "UPDATE rentals SET days = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newDays);
            ps.setInt(2, rentalId);
            ps.executeUpdate();
        }
    }


    public void deleteRental(int rentalId) throws Exception {
        String sql = "DELETE FROM rentals WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, rentalId);
            ps.executeUpdate();
        }
    }
}
