import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRecords {

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

    // Hier wurde String username und String password eingefügt
    public boolean selectAll(String username, String password){
        String sql = "SELECT * FROM users";
        // select all and search for the right one
        try {
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {
                if (rs.getString("username_hash").equals(username) && rs.getString("password_hash").equals(password)) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    /**
     * @param args the command line arguments 
     */
    /*public static void main(String[] args) {
        SelectRecords app = new SelectRecords();
        app.selectAll();
    }*/

}  