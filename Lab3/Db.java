import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Проверка — существует ли пользователь в БД
    public boolean isUserExists(String username, String password) {
    String sql = "SELECT COUNT(*) FROM mygame.users WHERE username = ? AND password = ?";
    try (Connection con = connect();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    }
    catch (Exception e) {
        System.out.println("Database error: " + e.getMessage());
    }
    return false;
    }
}
