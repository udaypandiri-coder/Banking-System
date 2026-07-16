
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static Connection con;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankdb",
                    "root",
                    "Uday@4383"
            );

        } catch(Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}