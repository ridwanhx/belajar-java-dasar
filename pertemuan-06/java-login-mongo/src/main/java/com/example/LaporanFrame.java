package com.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import org.bson.types.ObjectId;

public class LaporanFrame extends JFrame {
    private LaporanService laporanService = new LaporanService();
    private JTable laporanTable;
    private DefaultTableModel tableModel;

    // Komponen Form
    private JTextField txtNamaPelapor, txtLokasi, txtKeterangan;
    private JComboBox<String> cmbJenisSampah, cmbStatus;
    private JButton btnAdd, btnUpdate, btnDelete, btnClear;
    private ObjectId selectedLaporanId = null;
    
    // Tombol Logout
    private JButton btnLogout;

    public LaporanFrame(String loggedInUser) {
        setTitle("Aplikasi Data Laporan Sampah - Pengguna: " + loggedInUser);
        setSize(950, 600); // Ukuran lebih besar agar layout Kiri-Kanan terlihat baik
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Gunakan DISPOSE_ON_CLOSE agar tidak menutup seluruh aplikasi saat Logout
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); 

        // --- Model Tabel ---
        String[] columnNames = {"ID Laporan", "Nama Pelapor", "Lokasi", "Jenis Sampah", "Keterangan", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        laporanTable = new JTable(tableModel);
        laporanTable.removeColumn(laporanTable.getColumnModel().getColumn(0)); // Sembunyikan ID
        JScrollPane scrollPane = new JScrollPane(laporanTable);
        // --- END Model Tabel ---

        // --- Panel Kiri: Form & Tombol Kontrol (Sesuai Wireframe) ---
        JPanel leftPanel = createLeftPanel(); 
        
        // --- JSplitPane: Membagi Tampilan Kiri (Form) dan Kanan (Tabel) ---
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, scrollPane);
        splitPane.setDividerLocation(350); 
        splitPane.setResizeWeight(0.0); 
        
        add(splitPane, BorderLayout.CENTER);

        // --- Panel Footer Bawah Kanan (Untuk Logout) ---
        JPanel southPanel = new JPanel(new BorderLayout());
        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
        
        btnLogout = new JButton("Logout");
        btnLogout.setBackground(new Color(231, 76, 60)); 
        btnLogout.setForeground(Color.WHITE);
        
        logoutPanel.add(btnLogout);
        southPanel.add(logoutPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);

        // --- Event Listeners ---
        laporanTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = laporanTable.getSelectedRow();
                if (selectedRow >= 0) {
                    selectedLaporanId = (ObjectId) tableModel.getValueAt(selectedRow, 0);

                    // Isi data ke form
                    txtNamaPelapor.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    txtLokasi.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    cmbJenisSampah.setSelectedItem(tableModel.getValueAt(selectedRow, 3).toString());
                    txtKeterangan.setText(tableModel.getValueAt(selectedRow, 4).toString());
                    cmbStatus.setSelectedItem(tableModel.getValueAt(selectedRow, 5).toString());
                    
                    // Aktifkan tombol Update/Delete
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    btnAdd.setEnabled(false);
                }
            }
        });

        btnLogout.addActionListener(e -> handleLogout());
        
        // --- Load data saat aplikasi dimulai (READ) ---
        loadLaporanData();

        setVisible(true);
    }
    
    private JPanel createLeftPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); 
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- 1. Panel Form Input ---
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Form Laporan Sampah"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Inisialisasi komponen form
        txtNamaPelapor = new JTextField(20);
        txtLokasi = new JTextField(20);
        txtKeterangan = new JTextField(20);
        cmbJenisSampah = new JComboBox<>(new String[]{"organik", "anorganik", "campuran"});
        cmbStatus = new JComboBox<>(new String[]{"baru", "diproses", "selesai"});

        // Layouting Form
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(new JLabel("Nama Pelapor:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0;
        formPanel.add(txtNamaPelapor, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        formPanel.add(new JLabel("Lokasi/Alamat:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1.0;
        formPanel.add(txtLokasi, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        formPanel.add(new JLabel("Jenis Sampah:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 1.0;
        formPanel.add(cmbJenisSampah, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        formPanel.add(new JLabel("Keterangan:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 1.0;
        formPanel.add(txtKeterangan, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0;
        formPanel.add(new JLabel("Status Laporan:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4; gbc.weightx = 1.0;
        formPanel.add(cmbStatus, gbc);
        
        // --- 2. Panel Tombol Kontrol ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); 
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); 

        btnAdd = new JButton("Tambah (Save)");
        btnUpdate = new JButton("Ubah Status (Update)"); 
        btnDelete = new JButton("Hapus (Delete)"); 
        btnClear = new JButton("Clear Form");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);
        
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        // --- Event Listeners Tombol ---
        btnAdd.addActionListener(e -> handleCreate());
        btnUpdate.addActionListener(e -> handleUpdate());
        btnDelete.addActionListener(e -> handleDelete());
        btnClear.addActionListener(e -> clearForm());

        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);
        
        return mainPanel;
    }

    private void loadLaporanData() {
        tableModel.setRowCount(0);
        List<LaporanSampah> laporanList = laporanService.getAllLaporan();

        for (LaporanSampah laporan : laporanList) {
            tableModel.addRow(new Object[]{
                laporan.getId(), 
                laporan.getNamaPelapor(),
                laporan.getLokasi(),
                laporan.getJenisSampah(),
                laporan.getKeterangan(),
                laporan.getStatus()
            });
        }
    }

    private void handleCreate() {
        String nama = txtNamaPelapor.getText();
        String lokasi = txtLokasi.getText();
        String jenis = (String) cmbJenisSampah.getSelectedItem();
        String keterangan = txtKeterangan.getText();
        String status = (String) cmbStatus.getSelectedItem();

        if (nama.isEmpty() || lokasi.isEmpty() || keterangan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LaporanSampah newLaporan = new LaporanSampah(nama, lokasi, jenis, keterangan, status);
        laporanService.createLaporan(newLaporan);
        
        JOptionPane.showMessageDialog(this, "Laporan berhasil ditambahkan!");
        loadLaporanData();
        clearForm();
    }
    
    private void handleUpdate() {
        if (selectedLaporanId == null) {
            JOptionPane.showMessageDialog(this, "Pilih baris laporan yang ingin diubah!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String newStatus = (String) cmbStatus.getSelectedItem();
        
        laporanService.updateLaporanStatus(selectedLaporanId, newStatus);
        
        JOptionPane.showMessageDialog(this, "Status laporan berhasil diubah menjadi: " + newStatus);
        loadLaporanData();
        clearForm();
    }

    /**
     * DELETE: Menangani penghapusan laporan yang dianggap tidak valid oleh operator.
     */
    private void handleDelete() {
        if (selectedLaporanId == null) {
            JOptionPane.showMessageDialog(this, "Pilih baris laporan yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
                "Yakin ingin menghapus laporan ini?\n(Aksi ini digunakan untuk menghapus laporan yang dianggap TIDAK VALID)", "Konfirmasi Hapus", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Melakukan penghapusan di MongoDB
            laporanService.deleteLaporan(selectedLaporanId);
            JOptionPane.showMessageDialog(this, "Laporan berhasil dihapus.");
            loadLaporanData();
            clearForm();
        }
    }
    
    private void clearForm() {
        txtNamaPelapor.setText("");
        txtLokasi.setText("");
        txtKeterangan.setText("");
        cmbJenisSampah.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);
        selectedLaporanId = null;
        
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);
        laporanTable.clearSelection();
    }

    private void handleLogout() {
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Yakin ingin keluar dan kembali ke halaman Login?", "Konfirmasi Logout", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose(); 
            new LoginFrame(); 
        }
    }
}