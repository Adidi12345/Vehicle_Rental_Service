import java.sql.*;

public class VehicleDAO {

    public int addVehicle(Vehicle vehicle) throws Exception {
        String sql =
                "INSERT INTO vehicles(brand, price_per_day) VALUES (?, ?) RETURNING id";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, vehicle.getBrand());
            ps.setDouble(2, vehicle.getPricePerDay());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }
}
