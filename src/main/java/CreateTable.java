import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createNewTable() {
        // SQLite connection string  
        String url = "jdbc:sqlite:userdata.db";

        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + " username_hash VARCHAR,\n"
                + " password_hash VARCHAR"
                + ");";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments 
     */
    /*public static void main(String[] args) {
        createNewTable();
    }*/

}  