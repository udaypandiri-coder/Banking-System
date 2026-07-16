
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class TransactionPage {

    JFrame frame;
    JTable table;

    public TransactionPage(String username) {

        frame = new JFrame("Transactions");

        String[] columns =
                {"ID", "Type", "Amount", "Date"};

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane pane =
                new JScrollPane(table);

        pane.setBounds(20, 20, 450, 300);

        frame.add(pane);

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        try {

            Connection con =
                    DatabaseConnection.getConnection();

            String query =
                    "SELECT * FROM transactions WHERE username=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Object[] row = {

                        rs.getInt("transaction_id"),
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("transaction_date")
                };

                model.addRow(row);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
