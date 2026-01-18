package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Window;
import java.time.LocalDate;

public class ReturnTodayPanel extends JPanel {

    JTable table;
    DefaultTableModel model;

    public ReturnTodayPanel() {
        setLayout(null);

        /* =======================
           Logout Button
        ======================= */
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(700, 20, 80, 25);
        add(logoutBtn);

        logoutBtn.addActionListener(e -> logout());

        /* =======================
           Issued Today Table
        ======================= */
        String[] columns = {
                "ID", "USN", "Student Name",
                "Issue Date", "Return Date", "ISBN"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(250, 80, 520, 300);
        add(scrollPane);

        loadTodayReturns();
    }

    private void loadTodayReturns() {
        model.setRowCount(0);

        LocalDate today = LocalDate.now();

        // Demo data (optional)
        /*
        model.addRow(new Object[]{
                "12", "1si16cs010", "Akshat",
                "2019-07-25", today.toString(), "555"
        });
        */

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "No book to return Today",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to logout?",
                "Logout",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Window window = SwingUtilities.getWindowAncestor(this);
            window.dispose(); // close dashboard

            new Login().setVisible(true); // open login
        }
    }
}