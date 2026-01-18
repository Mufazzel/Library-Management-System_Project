package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IssueBookPanel extends JPanel {

    JTable bookTable, studentTable;
    DefaultTableModel bookModel, studentModel;

    public IssueBookPanel() {
        setLayout(null);

        /* =======================
           Search Book Section
        ======================= */

        JLabel searchBookLabel = new JLabel("Search Book");
        searchBookLabel.setBounds(250, 30, 100, 25);
        add(searchBookLabel);

        JTextField bookSearchField = new JTextField();
        bookSearchField.setBounds(330, 30, 160, 25);
        add(bookSearchField);

        JComboBox<String> searchBy = new JComboBox<>(new String[]{"Title", "ISBN"});
        searchBy.setBounds(500, 30, 80, 25);
        add(searchBy);

        JButton searchBookBtn = new JButton("Search");
        searchBookBtn.setBounds(590, 30, 80, 25);
        add(searchBookBtn);

        // Book Table
        String[] bookCols = {
                "Book ISBN", "Book Title", "Category", "Quantity", "Author"
        };
        bookModel = new DefaultTableModel(bookCols, 0);
        bookTable = new JTable(bookModel);

        JScrollPane bookScroll = new JScrollPane(bookTable);
        bookScroll.setBounds(250, 70, 520, 160);
        add(bookScroll);

        /* =======================
           Search Student Section
        ======================= */

        JLabel searchStudentLabel = new JLabel("Search Student :");
        searchStudentLabel.setBounds(250, 250, 120, 25);
        add(searchStudentLabel);

        JLabel usnLabel = new JLabel("USN");
        usnLabel.setBounds(380, 250, 40, 25);
        add(usnLabel);

        JTextField usnField = new JTextField();
        usnField.setBounds(420, 250, 120, 25);
        add(usnField);

        JButton searchStudentBtn = new JButton("Search");
        searchStudentBtn.setBounds(550, 250, 80, 25);
        add(searchStudentBtn);

        // Student Table
        String[] studentCols = {"USN", "Name"};
        studentModel = new DefaultTableModel(studentCols, 0);
        studentTable = new JTable(studentModel);

        JScrollPane studentScroll = new JScrollPane(studentTable);
        studentScroll.setBounds(250, 290, 320, 100);
        add(studentScroll);

        JButton addStudentBtn = new JButton("Add Student");
        addStudentBtn.setBounds(600, 320, 120, 30);
        add(addStudentBtn);

        /* =======================
           Issue Button
        ======================= */

        JButton issueBtn = new JButton("Issue");
        issueBtn.setBounds(430, 420, 120, 30);
        add(issueBtn);

        /* =======================
           TEMP DEMO DATA
        ======================= */

        searchBookBtn.addActionListener(e -> {
            bookModel.setRowCount(0);
            bookModel.addRow(new Object[]{"111", "java", "programming", "10", "balagurusamy"});
            bookModel.addRow(new Object[]{"222", "Bjava", "temp", "11", "navathe"});
        });

        searchStudentBtn.addActionListener(e -> {
            studentModel.setRowCount(0);
            studentModel.addRow(new Object[]{"1si16cs010", "Akshat"});
        });

        issueBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Book Issued (UI only for now)",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        });
    }
}