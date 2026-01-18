import java.sql.*;

public class ClientDAO {

    public int addClient(Client client) throws Exception {
        String sql = "INSERT INTO clients(name) VALUES (?) RETURNING id";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, client.getName());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }
}
