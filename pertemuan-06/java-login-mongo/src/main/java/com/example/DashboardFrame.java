package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frame setelah login berhasil
class DashboardFrame extends JFrame {
    
    public DashboardFrame(String fullName) {
        // --- Konfigurasi Dasar Frame ---
        setTitle("🏠 Dashboard Aplikasi Laporan Sampah");
        setSize(500, 300); // Ukuran lebih besar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Menggunakan BorderLayout sebagai layout utama
        setLayout(new BorderLayout(10, 10)); // Jarak 10px antar komponen
        
        // --- 1. Panel Header (North) ---
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(39, 174, 96)); // Warna hijau lembut
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Padding
        
        JLabel welcomeLabel = new JLabel("Selamat datang, " + fullName + " !");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        headerPanel.add(welcomeLabel);
        
        add(headerPanel, BorderLayout.NORTH);

        // --- 2. Panel Konten (Center) ---
        JPanel contentPanel = new JPanel();
        // Menggunakan GridBagLayout untuk menempatkan tombol secara rapi di tengah
        contentPanel.setLayout(new GridBagLayout()); 
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Tombol CRUD Laporan Sampah ---
        JButton laporanButton = new JButton("Kelola Laporan Sampah (CRUD) 🗑️");
        laporanButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        laporanButton.setBackground(new Color(52, 152, 219)); // Warna biru
        laporanButton.setForeground(Color.WHITE);
        laporanButton.setFocusPainted(false);
        laporanButton.setPreferredSize(new Dimension(300, 50)); // Ukuran tombol tetap
        
        // Listener Tombol
        laporanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Buka LaporanFrame dan kirimkan nama user yang login
                new LaporanFrame(fullName);
            }
        });
        
        // Tambahkan tombol ke panel konten
        contentPanel.add(laporanButton);
        add(contentPanel, BorderLayout.CENTER);

        // --- 3. Panel Footer (South) ---
        JPanel footerPanel = new JPanel();
        JLabel footerLabel = new JLabel("Sistem Informasi Pelaporan Sampah Kelurahan");
        footerLabel.setFont(new Font("SansSerif", Font.ITALIC, 10));
        footerPanel.add(footerLabel);
        
        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    // Catatan: Pastikan LaporanFrame sudah tersedia di proyek Anda
}