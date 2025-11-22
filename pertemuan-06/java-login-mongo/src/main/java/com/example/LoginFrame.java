package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton clearButton;

    public LoginFrame() {
        setTitle("Login Form - MongoDB");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 40, 100, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 40, 180, 30);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 80, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 80, 180, 30);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 130, 80, 30);
        add(loginButton);
        
        clearButton = new JButton("Clear");
        clearButton.setBounds(250, 130, 80, 30);
        add(clearButton);

        // Event Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
            }
        });
        setVisible(true);
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan password wajib diisi");
        }

        boolean valid = AuthService.authenticate(username, password);

        if (valid) {
            String fullName = AuthService.getFullName(username);
            JOptionPane.showMessageDialog(this, "Login berhasil.\nSelamat Datang, " + fullName + " !");
            new DashboardFrame(fullName);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username atau password salah!", "Login Gagal",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
