import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecords {

    private Connection connect() {
        // SQLite connection string  
        String url = "jdbc:sqlite:userdata.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void insert(String username, String password) {
        String sql = "INSERT INTO users(username_hash, password_hash) VALUES(?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public static void main(String[] args) {

        InsertRecords app = new InsertRecords();
        // insert three new rows  
        app.insert("Aryan", 30000);
        app.insert("Robert", 40000);
        app.insert("Jerry", 50000);
    }*/

}  