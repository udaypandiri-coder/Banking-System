
import javax.swing.*;
import java.awt.event.*;

public class Dashboard {

    JFrame frame;

    public Dashboard(String username) {

        frame = new JFrame("Dashboard");

        JLabel welcome =
                new JLabel("Welcome " + username);

        welcome.setBounds(120, 30, 200, 30);

        JButton depositBtn =
                new JButton("Deposit");

        depositBtn.setBounds(100, 90, 180, 40);

        JButton withdrawBtn =
                new JButton("Withdraw");

        withdrawBtn.setBounds(100, 150, 180, 40);
        
        JButton balanceBtn =
                new JButton("Check Balance");

        balanceBtn.setBounds(100, 210, 180, 40);
        
        JButton transactionBtn =
                new JButton("Transactions");

        transactionBtn.setBounds(100, 270, 180, 40);

        JButton logoutBtn =
                new JButton("Logout");

        logoutBtn.setBounds(100, 330, 180, 40);

        frame.add(welcome);
        frame.add(depositBtn);
        frame.add(withdrawBtn);
        frame.add(balanceBtn);
        frame.add(transactionBtn);
        frame.add(logoutBtn);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        depositBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                new DepositForm(username);
            }
        });

        withdrawBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                new WithdrawForm(username);
            }
        });

        balanceBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                new BalancePage(username);
            }
        });

        transactionBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                new TransactionPage(username);
            }
        });

        logoutBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                new LoginForm();

                frame.dispose();
            }
        });
    }
}

