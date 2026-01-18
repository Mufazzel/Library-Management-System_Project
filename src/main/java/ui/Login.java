package ui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    JTextField userField;
    JPasswordField passField;

    public Login() {

        setTitle("Welcome to AU Library");
        setSize(500, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* =========================
           Title
        ========================= */
        JLabel title = new JLabel("Welcome to AU Library");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(153, 0, 153));
        title.setBounds(120, 40, 300, 30);
        add(title);

        /* =========================
           Admin ID
        ========================= */
        JLabel userLabel = new JLabel("Admin ID:");
        userLabel.setBounds(100, 120, 100, 25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(200, 120, 150, 25);
        add(userField);

        /* =========================
           Password
        ========================= */
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(100, 160, 100, 25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(200, 160, 150, 25);
        add(passField);

        /* =========================
           Login Button
        ========================= */
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(200, 210, 80, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> login());
    }

    /* =========================
       LOGIN CHECK (NO DB)
    ========================= */
    private void login() {

        String username = userField.getText();
        String password = new String(passField.getPassword());

        if (username.equals("admin") && password.equals("admin123")) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            dispose();
            new Dashboard().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Admin ID or Password");
        }
    }

    /* =========================
       MAIN METHOD
    ========================= */
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}