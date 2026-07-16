
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DepositForm {

    JFrame frame;

    public DepositForm(String username) {

        frame = new JFrame("Deposit");

        JLabel amountLabel =
                new JLabel("Enter Amount:");

        amountLabel.setBounds(50, 60, 120, 30);

        JTextField amountField =
                new JTextField();

        amountField.setBounds(170, 60, 140, 30);

        JButton depositBtn =
                new JButton("Deposit");

        depositBtn.setBounds(120, 140, 120, 40);

        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(depositBtn);

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        depositBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                double amount =
                        Double.parseDouble(amountField.getText());

                try {

                    Connection con =
                            DatabaseConnection.getConnection();

                    String query =
                            "UPDATE users SET balance=balance+? WHERE username=?";

                    PreparedStatement ps =
                            con.prepareStatement(query);

                    ps.setDouble(1, amount);
                    ps.setString(2, username);

                    ps.executeUpdate();

                    String tQuery =
                            "INSERT INTO transactions(username,type,amount) VALUES(?,?,?)";

                    PreparedStatement ts =
                            con.prepareStatement(tQuery);

                    ts.setString(1, username);
                    ts.setString(2, "Deposit");
                    ts.setDouble(3, amount);

                    ts.executeUpdate();

                    JOptionPane.showMessageDialog(
                            frame,
                            "Money Deposited Successfully"
                    );

                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}