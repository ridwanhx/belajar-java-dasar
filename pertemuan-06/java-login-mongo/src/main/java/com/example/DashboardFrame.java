package com.example;
import javax.swing.*;

// Frame setelah login berhasil
class DashboardFrame extends JFrame {
    public DashboardFrame(String fullName) {
        setTitle("Dashboard");
        setSize(400, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Selamat datang, " + fullName + " !");
        welcomeLabel.setBounds(50, 50, 300, 30);
        add(welcomeLabel);

        setVisible(true);
    }
}
