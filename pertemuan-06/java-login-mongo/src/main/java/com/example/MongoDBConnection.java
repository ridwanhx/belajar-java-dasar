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

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> userCollection;

    static {
        // inisiasi koneksi (sekali saja)
        mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DB_NAME);
        userCollection = database.getCollection(USER_COLLECTION);
    }

    public static MongoCollection<Document> getUserCollection() {
        return userCollection;
    }

    // Opsional: dipakai jika mau menutup koneksi saat aplikasi ditutup
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}