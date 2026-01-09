package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDBConnection {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DB_NAME = "testdb";
    private static final String USER_COLLECTION = "users";
    private static final String LAPORAN_COLLECTION = "laporanSampah"; // BARU

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> userCollection;
    // Tambahkan collection laporan
    private static MongoCollection<Document> laporanCollection; // BARU

    static {
        // inisiasi koneksi (sekali saja)
        mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DB_NAME);
        userCollection = database.getCollection(USER_COLLECTION);
        // Inisialisasi collection laporan
        laporanCollection = database.getCollection(LAPORAN_COLLECTION); // BARU
    }

    public static MongoCollection<Document> getUserCollection() {
        return userCollection;
    }

    // Tambahkan method untuk mendapatkan database (dipakai LaporanService)
    public static MongoDatabase getDatabase() {
        return database;
    }

    // Tambahkan method untuk mendapatkan collection Laporan (Opsional, tapi konsisten)
    public static MongoCollection<Document> getLaporanCollection() {
        return laporanCollection;
    }

    // Opsional: dipakai jika mau menutup koneksi saat aplikasi ditutup
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}