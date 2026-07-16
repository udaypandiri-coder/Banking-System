import javax.swing.*;
import java.sql.*;

public class BalancePage {

    JFrame frame;

    public BalancePage(String username) {

        frame = new JFrame("Balance");

        JLabel title =
                new JLabel("CURRENT BALANCE");

        title.setBounds(120, 30, 200, 30);

        JLabel balanceLabel =
                new JLabel();

        balanceLabel.setBounds(120, 100, 200, 40);

        frame.add(title);
        frame.add(balanceLabel);

        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        try {

            Connection con =
                    DatabaseConnection.getConnection();

            String query =
                    "SELECT balance FROM users WHERE username=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                double balance =
                        rs.getDouble("balance");

                balanceLabel.setText(
                        "Balance: ₹" + balance
                );
            }

        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}