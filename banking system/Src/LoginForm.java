
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm {

    JFrame frame;

    JTextField userField;
    JPasswordField passField;

    JButton loginBtn;
    JButton registerBtn;

    public LoginForm() {

        frame = new JFrame("Bank Login");

        JLabel title = new JLabel("BANK LOGIN");
        title.setBounds(140, 20, 200, 30);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 100, 30);

        userField = new JTextField();
        userField.setBounds(160, 80, 150, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 130, 100, 30);

        passField = new JPasswordField();
        passField.setBounds(160, 130, 150, 30);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(70, 220, 100, 40);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(200, 220, 100, 40);

        frame.add(title);
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginBtn);
        frame.add(registerBtn);

        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String username = userField.getText();
                String password = String.valueOf(passField.getPassword());

                try {

                    Connection con =
                            DatabaseConnection.getConnection();

                    String query =
                            "SELECT * FROM users WHERE username=? AND password=?";

                    PreparedStatement ps =
                            con.prepareStatement(query);

                    ps.setString(1, username);
                    ps.setString(2, password);

                    ResultSet rs = ps.executeQuery();

                    if(rs.next()) {

                        JOptionPane.showMessageDialog(
                                frame,
                                "Login Successful"
                        );

                        new Dashboard(username);

                        frame.dispose();

                    } else {

                        JOptionPane.showMessageDialog(
                                frame,
                                "Invalid Credentials"
                        );
                    }

                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        registerBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                new RegisterForm();

                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {

        new LoginForm();
    }
}