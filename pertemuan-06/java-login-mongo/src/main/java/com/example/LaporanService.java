package com.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class LaporanService {
    private static final String LAPORAN_COLLECTION = "laporanSampah";
    private MongoCollection<Document> collection;

    public LaporanService() {
        // Mengambil collection "laporanSampah" dari koneksi yang sudah ada
        // Catatan: Anda perlu menambahkan method getLaporanCollection() di MongoDBConnection
        collection = MongoDBConnection.getDatabase().getCollection(LAPORAN_COLLECTION);
    }

    /**
     * CREATE: Menambah laporan baru ke MongoDB.
     */
    public void createLaporan(LaporanSampah laporan) {
        Document doc = new Document("namaPelapor", laporan.getNamaPelapor())
                .append("lokasi", laporan.getLokasi())
                .append("jenisSampah", laporan.getJenisSampah())
                .append("keterangan", laporan.getKeterangan())
                .append("status", laporan.getStatus()); // Status awal biasanya "baru"

        collection.insertOne(doc);
    }

    /**
     * READ: Mengambil semua laporan dari MongoDB.
     */
    public List<LaporanSampah> getAllLaporan() {
        List<LaporanSampah> laporanList = new ArrayList<>();
        for (Document doc : collection.find()) {
            ObjectId id = doc.getObjectId("_id");
            String namaPelapor = doc.getString("namaPelapor");
            String lokasi = doc.getString("lokasi");
            String jenisSampah = doc.getString("jenisSampah");
            String keterangan = doc.getString("keterangan");
            String status = doc.getString("status");

            LaporanSampah laporan = new LaporanSampah(id, namaPelapor, lokasi, jenisSampah, keterangan, status);
            laporanList.add(laporan);
        }
        return laporanList;
    }

    /**
     * UPDATE: Mengubah status laporan berdasarkan ID.
     */
    public void updateLaporanStatus(ObjectId id, String newStatus) {
        collection.updateOne(
                Filters.eq("_id", id),
                Updates.set("status", newStatus)
        );
    }

    /**
     * DELETE: Menghapus laporan berdasarkan ID.
     */
    public void deleteLaporan(ObjectId id) {
        collection.deleteOne(Filters.eq("_id", id));
    }
}