package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mps?useSSL=false", "root", "jesus123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}