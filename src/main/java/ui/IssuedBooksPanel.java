package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IssuedBooksPanel extends JPanel {

    JTextField usnField;
    JTable table;
    DefaultTableModel model;

    public IssuedBooksPanel() {
        setLayout(null);

        /* =====================
           Search by USN
        ===================== */
        JLabel usnLabel = new JLabel("USN");
        usnLabel.setBounds(260, 30, 40, 25);
        add(usnLabel);

        usnField = new JTextField();
        usnField.setBounds(300, 30, 140, 25);
        add(usnField);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(450, 30, 80, 25);
        add(searchBtn);

        searchBtn.addActionListener(e -> searchIssuedBooks());

        /* =====================
           Issued Books Table
        ===================== */
        String[] columns = {
                "ID", "USN", "Student Name",
                "Issue Date", "Return Date", "ISBN"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(250, 70, 520, 280);
        add(scrollPane);

        /* =====================
           Return Button
        ===================== */
        JButton returnBtn = new JButton("Return");
        returnBtn.setBounds(470, 370, 80, 30);
        add(returnBtn);

        returnBtn.addActionListener(e -> returnBook());

        // Load all issued books initially
        loadIssuedBooks();
    }

    /* =====================
       Load Issued Books
    ===================== */
    private void loadIssuedBooks() {
        model.setRowCount(0);

        // Demo data (same as your screenshot)
        model.addRow(new Object[]{"7", "1si16cs007", "Akash", "2019-07-25", "2019-08-01", "333"});
        model.addRow(new Object[]{"9", "1si16cs009", "akash", "2019-07-25", "2019-08-01", "111"});
        model.addRow(new Object[]{"4", "1si16cs010", "Akshat", "2019-07-25", "2019-08-01", "111"});
        model.addRow(new Object[]{"5", "1si16cs010", "Akshat", "2019-07-25", "2019-08-01", "111"});
        model.addRow(new Object[]{"6", "1si16cs010", "Akshat", "2019-07-25", "2019-08-01", "444"});
        model.addRow(new Object[]{"12", "1si16cs019", "Srijan", "2019-07-25", "2019-08-01", "555"});
        model.addRow(new Object[]{"8", "1si16cs131", "ayush", "2019-07-25", "2019-07-26", "222"});
        model.addRow(new Object[]{"10", "1si16cs131", "ayush", "2019-07-25", "2019-08-01", "222"});
        model.addRow(new Object[]{"11", "1si16cs007", "akshay", "2019-07-25", "2019-08-01", "444"});
    }

    /* =====================
       Search Issued Books
    ===================== */
    private void searchIssuedBooks() {
        String usn = usnField.getText().trim();

        if (usn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter USN to search");
            return;
        }

        model.setRowCount(0);

        // Demo filtered data
        if (usn.equals("1si16cs010")) {
            model.addRow(new Object[]{"4", usn, "Akshat", "2019-07-25", "2019-08-01", "111"});
            model.addRow(new Object[]{"5", usn, "Akshat", "2019-07-25", "2019-08-01", "111"});
        } else {
            JOptionPane.showMessageDialog(this, "No records found");
        }
    }

    /* =====================
       Return Book
    ===================== */
    private void returnBook() {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a book to return");
            return;
        }

        model.removeRow(row);
        JOptionPane.showMessageDialog(this, "Book Returned Successfully");
    }
}