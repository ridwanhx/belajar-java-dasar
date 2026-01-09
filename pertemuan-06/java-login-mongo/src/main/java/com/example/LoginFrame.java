package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    // Ganti tipe data field dengan tipe kustom
    private RoundedTextField usernameField;
    private RoundedPasswordField passwordField;
    private RoundedButton loginButton;
    private RoundedButton clearButton;
    
    // Define Colors
    private static final Color PRIMARY_COLOR = new Color(255, 189, 102); // Kuning/Oranye Akses
    private static final Color HOVER_PRIMARY_COLOR = new Color(255, 210, 150); // Warna lebih terang saat hover
    private static final Color BG_COLOR = new Color(245, 245, 235); 
    private static final Color CLEAR_COLOR = Color.LIGHT_GRAY;

    public LoginFrame() {
        // --- 1. Konfigurasi Dasar Frame ---
        setTitle("Agent Login - Aplikasi Sampah");
        setSize(450, 400); 
        setLayout(new BorderLayout()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        getContentPane().setBackground(BG_COLOR);

        // --- 2. Panel Login Utama (Tengah) ---
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout()); 
        loginPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); 
        loginPanel.setBackground(BG_COLOR); // Pastikan panel login juga menggunakan warna latar belakang

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 

        // Judul & Deskripsi + Logo (Menggunakan emoji sebagai pengganti SVG)
        JLabel titleLabel = new JLabel("🗑️ Agent Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        loginPanel.add(titleLabel, gbc);

        JLabel descLabel = new JLabel("Hey, Enter your details to get sign in to your account", SwingConstants.CENTER);
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        gbc.gridy = 1; gbc.insets = new Insets(0, 5, 20, 5);
        loginPanel.add(descLabel, gbc);
        
        // Reset gridwidth dan insets
        gbc.gridwidth = 1;
        gbc.insets = new Insets(15, 5, 5, 5); // Jarak lebih besar di atas input

        // --- Input Fields (Menggunakan Rounded Components) ---
        
        // Username
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.WEST; gbc.weightx = 0;
        loginPanel.add(usernameLabel, gbc);
        
        usernameField = new RoundedTextField(20); // Gunakan RoundedTextField
        usernameField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding teks internal
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 1.0;
        loginPanel.add(usernameField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        loginPanel.add(passwordLabel, gbc);

        passwordField = new RoundedPasswordField(20); // Gunakan RoundedPasswordField
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 1.0;
        loginPanel.add(passwordField, gbc);

        // --- Tombol (Menggunakan RoundedButton dengan Hover Effect) ---
        
        // Login Button
        loginButton = new RoundedButton("Sign in", PRIMARY_COLOR, HOVER_PRIMARY_COLOR);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        loginButton.setForeground(Color.BLACK);
        loginButton.setPreferredSize(new Dimension(150, 40));
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.insets = new Insets(25, 5, 5, 5);
        loginPanel.add(loginButton, gbc);

        // Clear Button
        clearButton = new RoundedButton("Clear", CLEAR_COLOR, Color.LIGHT_GRAY.brighter());
        clearButton.setForeground(Color.BLACK);
        clearButton.setPreferredSize(new Dimension(150, 40));
        
        gbc.gridy = 5; gbc.insets = new Insets(5, 5, 20, 5);
        loginPanel.add(clearButton, gbc);

        // Tambahkan Panel ke Frame
        add(loginPanel, BorderLayout.CENTER);
        
        // --- 3. Event Listeners ---

        loginButton.addActionListener(e -> handleLogin());
        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        setVisible(true);
    }
    
    // --- Method handleLogin (tetap sama) ---
    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan password wajib diisi");
            return;
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

// Masukkan ini di file LoginFrame.java, di luar public class LoginFrame

class RoundedTextField extends JTextField {
    private Shape shape;
    private static final int ARC_SIZE = 15; // Radius lengkungan

    public RoundedTextField(int size) {
        super(size);
        setOpaque(false); // Penting: Agar background transparan
    }
    
    // Override metode untuk menggambar border melengkung
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, ARC_SIZE, ARC_SIZE);
        super.paintComponent(g);
    }
    
    // Override metode untuk menggambar border melengkung
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        // Hanya menggambar border jika field aktif/terfokus
        if(isFocusOwner()) {
             g.setColor(new Color(255, 189, 102)); // Warna border saat aktif
        } else {
             g.setColor(Color.LIGHT_GRAY);
        }
        
        // Gambar border melengkung
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, ARC_SIZE, ARC_SIZE);
    }
    
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, ARC_SIZE, ARC_SIZE);
        }
        return shape.contains(x, y);
    }
}

class RoundedPasswordField extends JPasswordField {
    private Shape shape;
    private static final int ARC_SIZE = 15;

    public RoundedPasswordField(int size) {
        super(size);
        setOpaque(false);
    }

    // Metode paintComponent dan paintBorder sama seperti RoundedTextField
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ARC_SIZE, ARC_SIZE);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        if (isFocusOwner()) {
            g.setColor(new Color(255, 189, 102)); // Warna border saat aktif
        } else {
            g.setColor(Color.LIGHT_GRAY);
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ARC_SIZE, ARC_SIZE);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, ARC_SIZE, ARC_SIZE);
        }
        return shape.contains(x, y);
    }
}

// Masukkan ini di file LoginFrame.java, di luar public class LoginFrame

class RoundedButton extends JButton {
    private static final int ARC_SIZE = 15;
    private Color originalBg;
    private Color hoverBg;
    
    public RoundedButton(String label, Color originalBg, Color hoverBg) {
        super(label);
        this.originalBg = originalBg;
        this.hoverBg = hoverBg;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setBackground(originalBg);
        
        // Tambahkan Hover Effect
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(hoverBg);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(originalBg);
            }
        });
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ARC_SIZE, ARC_SIZE);
        super.paintComponent(g2);
        g2.dispose();
    }

    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground()); // Warna border saat tidak di-hover
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ARC_SIZE, ARC_SIZE);
        g2.dispose();
    }
}
