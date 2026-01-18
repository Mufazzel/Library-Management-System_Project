package ui;

import javax.swing.*;

public class AddBookPanel extends JPanel {

    public AddBookPanel() {
        setLayout(null);

        // Labels
        JLabel isbnLabel = new JLabel("Book ISBN");
        isbnLabel.setBounds(300, 80, 120, 25);
        add(isbnLabel);

        JLabel titleLabel = new JLabel("Book Title");
        titleLabel.setBounds(300, 120, 120, 25);
        add(titleLabel);

        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setBounds(300, 160, 120, 25);
        add(categoryLabel);

        JLabel authorNameLabel = new JLabel("Author Name");
        authorNameLabel.setBounds(300, 200, 120, 25);
        add(authorNameLabel);

        JLabel authorEmailLabel = new JLabel("Author Email");
        authorEmailLabel.setBounds(300, 240, 120, 25);
        add(authorEmailLabel);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(300, 280, 120, 25);
        add(quantityLabel);

        // Text Fields
        JTextField isbnField = new JTextField();
        isbnField.setBounds(430, 80, 220, 25);
        add(isbnField);

        JTextField titleField = new JTextField();
        titleField.setBounds(430, 120, 220, 25);
        add(titleField);

        JComboBox<String> categoryBox = new JComboBox<>(
                new String[]{"Programming", "Language", "Science", "Other"}
        );
        categoryBox.setBounds(430, 160, 220, 25);
        add(categoryBox);

        JTextField authorNameField = new JTextField();
        authorNameField.setBounds(430, 200, 220, 25);
        add(authorNameField);

        JTextField authorEmailField = new JTextField();
        authorEmailField.setBounds(430, 240, 220, 25);
        add(authorEmailField);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(430, 280, 220, 25);
        add(quantityField);

        // Add Button
        JButton addButton = new JButton("Add");
        addButton.setBounds(470, 330, 100, 30);
        add(addButton);

        // Temporary action (we will connect DB later)
        addButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Book Added (UI only for now)",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        });
    }
}