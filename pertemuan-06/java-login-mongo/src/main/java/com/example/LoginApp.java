package com.example;

import javax.swing.SwingUtilities;

public class LoginApp {
    public static void main(String[] args) {
        // Best practice untuk Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame(); // Tetap jalankan LoginFrame
            }
        });
        
        // Pastikan koneksi ditutup saat aplikasi berakhir
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            MongoDBConnection.close();
            System.out.println("Koneksi MongoDB ditutup.");
        }));
    }
}