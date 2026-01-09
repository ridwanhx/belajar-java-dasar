package com.example;

import org.bson.types.ObjectId;

public class LaporanSampah {
    private ObjectId id; 
    private String namaPelapor;
    private String lokasi;
    private String jenisSampah; 
    private String keterangan;
    private String status;

    // Constructor
    public LaporanSampah(String namaPelapor, String lokasi, String jenisSampah, String keterangan, String status) {
        this.namaPelapor = namaPelapor;
        this.lokasi = lokasi;
        this.jenisSampah = jenisSampah;
        this.keterangan = keterangan;
        this.status = status;
    }

    // Constructor untuk Read/Update/Delete (dengan ID)
    public LaporanSampah(ObjectId id, String namaPelapor, String lokasi, String jenisSampah, String keterangan, String status) {
        this.id = id;
        this.namaPelapor = namaPelapor;
        this.lokasi = lokasi;
        this.jenisSampah = jenisSampah;
        this.keterangan = keterangan;
        this.status = status;
    }

    // Getters and Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNamaPelapor() {
        return namaPelapor;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getJenisSampah() {
        return jenisSampah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LaporanSampah{" +
                "id=" + id +
                ", namaPelapor='" + namaPelapor + '\'' +
                ", lokasi='" + lokasi + '\'' +
                '}';
    }
}