package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListBooksPanel extends JPanel {

    JTable table;
    DefaultTableModel model;

    public ListBooksPanel() {
        setLayout(null);

        // Table columns
        String[] columns = {
                "Book ISBN", "Book Title", "Category", "Quantity", "Author"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(250, 40, 520, 420);
        add(scrollPane);

        // Sample data (same as screenshot)
        model.addRow(new Object[]{"111", "java", "programming", "10", "balagurusamy"});
        model.addRow(new Object[]{"222", "Bjava", "temp", "11", "navathe"});
        model.addRow(new Object[]{"333", "algorithms", "programming", "13", "Levitin"});
        model.addRow(new Object[]{"444", "The Design and analysis...", "Programming", "5", "Anany Levitin"});
        model.addRow(new Object[]{"555", "Hindi", "Language", "2", "Anil Gaur"});
    }
}