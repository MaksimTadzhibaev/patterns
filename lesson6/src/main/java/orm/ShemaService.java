package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ShemaService {
    static Statement statement;
    static Connection connection;

    public static void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "182824");
            statement = connection.createStatement();
            System.out.println("Connect");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            statement.close();
            System.out.println("Disconnect");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}