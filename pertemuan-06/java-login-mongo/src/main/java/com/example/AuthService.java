package com.example;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class AuthService {
    public static boolean authenticate(String username, String password) {
        MongoCollection<Document> users = MongoDBConnection.getUserCollection();

        Document user = users.find(
                Filters.and(
                        Filters.eq("username", username),
                        Filters.eq("password", password)))
                .first();

        return user != null;
    }
    
    public static String getFullName(String username) {
        MongoCollection<Document> users = MongoDBConnection.getUserCollection();
        Document user = users.find(Filters.eq("username", username)).first();

        if (user != null && user.containsKey("fullName")) {
            return user.getString("fullName");
        }
        return username;
    }
}
