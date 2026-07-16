

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterForm {

    JFrame frame;

    JTextField userField;
    JPasswordField passField;
    JTextField balanceField;

    JButton registerBtn;
    JButton loginBtn;

    public RegisterForm() {

        frame = new JFrame("Register");

        JLabel title = new JLabel("USER REGISTRATION");
        title.setBounds(120, 20, 200, 30);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 100, 30);

        userField = new JTextField();
        userField.setBounds(160, 80, 150, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 130, 100, 30);

        passField = new JPasswordField();
        passField.setBounds(160, 130, 150, 30);

        JLabel balanceLabel = new JLabel("Initial Balance:");
        balanceLabel.setBounds(50, 180, 100, 30);

        balanceField = new JTextField();
        balanceField.setBounds(160, 180, 150, 30);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(70, 260, 100, 40);

        loginBtn = new JButton("Back");
        loginBtn.setBounds(200, 260, 100, 40);

        frame.add(title);
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(balanceLabel);
        frame.add(balanceField);
        frame.add(registerBtn);
        frame.add(loginBtn);

        frame.setSize(400, 380);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registerBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String username = userField.getText();
                String password = String.valueOf(passField.getPassword());

                double balance =
                        Double.parseDouble(balanceField.getText());

                try {

                    Connection con =
                            DatabaseConnection.getConnection();

                    String checkQuery =
                            "SELECT * FROM users WHERE username=?";

                    PreparedStatement checkPs =
                            con.prepareStatement(checkQuery);

                    checkPs.setString(1, username);

                    ResultSet rs = checkPs.executeQuery();

                    if(rs.next()) {

                        JOptionPane.showMessageDialog(
                                frame,
                                "Username Already Exists"
                        );

                    } else {

                        String query =
                                "INSERT INTO users(username,password,balance) VALUES(?,?,?)";

                        PreparedStatement ps =
                                con.prepareStatement(query);

                        ps.setString(1, username);
                        ps.setString(2, password);
                        ps.setDouble(3, balance);

                        ps.executeUpdate();

                        JOptionPane.showMessageDialog(
                                frame,
                                "Registration Successful"
                        );

                        new LoginForm();

                        frame.dispose();
                    }

                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        loginBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                new LoginForm();

                frame.dispose();
            }
        });
    }
}
