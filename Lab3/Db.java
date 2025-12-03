import java.sql.*;

public class Db {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/myGame?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "xxx";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Проверка — существует ли пользователь в БД
    public boolean isUserExists(String username) {

        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";

        try (Connection con = connect();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        catch (Exception e) {
            System.out.println("DB error: " + e.getMessage());
        }

        return false;
    }
}
