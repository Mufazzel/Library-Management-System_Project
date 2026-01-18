package ui;

import javax.swing.*;

public class Dashboard extends JFrame {

    JPanel menuPanel;
    JPanel contentPanel;

    public Dashboard() {
        setTitle("Library");
        setSize(1000, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // LEFT MENU
        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(0, 0, 200, 600);
        add(menuPanel);
        
         JLabel label = new JLabel("Welcome to Library Management System");
        label.setBounds(300, 250, 400, 30);
        add(label);

        // RIGHT CONTENT
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBounds(200, 0, 800, 600);
        add(contentPanel);

        createMenu();

        setVisible(true);
    }

    private void createMenu() {

        JButton addBook = new JButton("Add Book");
        JButton searchBook = new JButton("Search Book");
        JButton listBooks = new JButton("List all Books");
        JButton issueBook = new JButton("Issue Book");
        JButton issuedBooks = new JButton("List Issued Books");
        JButton returnToday = new JButton("Book to be returned Today");

        JButton[] buttons = {
            addBook, searchBook, listBooks,
            issueBook, issuedBooks, returnToday
        };

        int y = 40;
        for (JButton b : buttons) {
            b.setBounds(20, y, 160, 35);
            menuPanel.add(b);
            y += 50;
        }

        addBook.addActionListener(e -> showPanel(new AddBookPanel()));
        searchBook.addActionListener(e -> showPanel(new SearchBookPanel()));
        listBooks.addActionListener(e -> showPanel(new ListBooksPanel()));
        issueBook.addActionListener(e -> showPanel(new IssueBookPanel()));
        issuedBooks.addActionListener(e -> showPanel(new IssuedBooksPanel()));
        returnToday.addActionListener(e -> showPanel(new ReturnTodayPanel()));
    }

    private void showPanel(JPanel panel) {
        contentPanel.removeAll();
        panel.setBounds(0, 0, 800, 600);
        contentPanel.add(panel);
        contentPanel.repaint();
        contentPanel.revalidate();
    }
}