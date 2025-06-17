package masterKey;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import db.ConnectionDB;
import org.mindrot.jbcrypt.BCrypt;

/**
 * AdminMaster - menyimpan admin baru ke collection 'master' jika belum ada.
 * Author: HUSAIN
 */
public class AdminMaster {
    private String username;
    private String password;
    private String role;

    public AdminMaster(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void simpanKeDatabase() {
        MongoDatabase db = ConnectionDB.connect();
        MongoCollection<Document> collection = db.getCollection("master");

        // Cek apakah username sudah ada
        Document existing = collection.find(Filters.eq("username", username)).first();

        if (existing != null) {
            System.out.println("⚠️ Username '" + username + "' sudah terdaftar. Data tidak disimpan ulang.");
            return;
        }

        // Hash password sebelum disimpan
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        Document doc = new Document("username", username)
                .append("password", hashedPassword)
                .append("role", role);

        collection.insertOne(doc);
        System.out.println("✅ Admin '" + username + "' berhasil disimpan ke collection 'master'.");
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // Untuk dijalankan manual dari NetBeans
    public static void main(String[] args) {
        AdminMaster admin = new AdminMaster("husain1", "husain123", "superadmin");
        admin.simpanKeDatabase();
    }
}
