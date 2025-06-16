package db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionDB {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static MongoDatabase connect() {
        if (database == null) {
            try {
                // Ganti sesuai konfigurasi MongoDB kamu
                String uri = "mongodb://localhost:27017";
                mongoClient = MongoClients.create(uri);
                database = mongoClient.getDatabase("manageschoolDB");
                System.out.println("MongoDB connected successfully to 'manageschoolDB'.");
            } catch (Exception e) {
                System.err.println("Failed to connect to MongoDB:");
                e.printStackTrace();
            }
        }
        return database;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            database = null;
            System.out.println("MongoDB connection closed.");
        }
    }
}
