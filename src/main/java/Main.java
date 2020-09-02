import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, ParseException {



        /*HashMap<String, String> dict = new HashMap<>();*/

        System.out.println("Choose operation:\nREGISTER (1)\nLOGIN (2)");
        Scanner scan = new Scanner(System.in);
        int operation = scan.nextInt();

        if (operation == 1) {

            Create.createNewDatabase("userdata.db");
            CreateTable.createNewTable();
            InsertRecords rec = new InsertRecords();
            System.out.println("Please enter a new username: ");
            String newusername = encryptThisString(scan.next());
            System.out.println("Please enter a new password:");
            String newpassword = encryptThisString(scan.next());
            rec.insert(newusername, newpassword);

        }
        if (operation == 2) {
            System.out.println("Enter username: ");
            String username = encryptThisString(scan.next());
            System.out.println("Enter password: ");
            String password = encryptThisString(scan.next());
            Main check = new Main();

            if (check.is_valid_credentials(username, password)) {
                System.out.println("Access granted!");
            } else {
                System.out.println("Access denied! Please check if your username and password were spelled correctly");
            }
        }



        // Main exists = new Main();

        /*if (!exists.checkExistence("config.json")) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(encryptThisString("robert"), encryptThisString("password123"));
            jsonObject.put(encryptThisString("Jakob"), encryptThisString("Waibel"));
            FileWriter file = new FileWriter("config.json");
            file.write(jsonObject.toJSONString());
            file.close();
        }*/



    }

    /*public boolean checkExistence(String fileName)
    {
        // Creating Method of Class File to use exists() method
        File tempMedia = new File(fileName);

        // If File exists return true
        if (tempMedia.exists())
        {
            return true;
        }

        // If no File exists so far return false and display the message below
        return false;
    }*/

    public static String encryptThisString(String input) {
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean is_valid_credentials(String username, String password) throws IOException, ParseException {
        /*JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("config.json"));
        *//*jsonObject.containsKey(username) && jsonObject.get(username).equals(password)*/
        SelectRecords select = new SelectRecords();

        if (select.selectAll(username, password)) {
            return true;
        }
        return false;
    }

}
