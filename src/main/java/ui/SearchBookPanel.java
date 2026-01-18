package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchBookPanel extends JPanel {

    JTable table;
    DefaultTableModel model;

    public SearchBookPanel() {
        setLayout(null);

        // Search By ComboBox
        JComboBox<String> searchBy = new JComboBox<>(
                new String[]{"Title", "ISBN"}
        );
        searchBy.setBounds(260, 40, 100, 25);
        add(searchBy);

        // Search TextField
        JTextField searchField = new JTextField();
        searchField.setBounds(370, 40, 200, 25);
        add(searchField);

        // Search Button
        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(580, 40, 80, 25);
        add(searchBtn);

        // Table Columns
        String[] columns = {
                "Book ISBN", "Book Title", "Category", "Quantity", "Author"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(260, 90, 480, 350);
        add(scrollPane);

        // Temporary demo action (DB later)
        searchBtn.addActionListener(e -> {
            model.setRowCount(0); // clear table

            // Dummy data (for UI testing)
            model.addRow(new Object[]{
                    "111", "Java", "Programming", "10", "Balagurusamy"
            });
            model.addRow(new Object[]{
                    "222", "BJava", "Temp", "11", "Navathe"
            });
        });
    }
}