import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {



        HashMap<String, String> dict = new HashMap<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = encryptThisString(scan.nextLine());
        System.out.println("Enter password: ");
        String password = encryptThisString(scan.nextLine());

        // besser implementieren
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "value");
        jsonObject.put("key2", "value2");
        FileWriter file = new FileWriter("output.json");
        file.write(jsonObject.toJSONString());
        file.close();

        dict.put("50a9ac4b554ca3bbd4b4ddf0f284fdfb5031d8eddb4131d3c2c54f0bd8ae2038be250dc1daf93b05bd73bfda51dc734b2a3d071dcbe329d41a989142d1e77d70", encryptThisString("password123"));


        Main check = new Main();

        if (check.is_valid_credentials(dict, username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied! Please check if your username and password were spelled correctly");
        }

    }

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
    public boolean is_valid_credentials(HashMap<String, String> dict, String username, String password) {

        for (String i : dict.keySet()) {
            if (i.equals(username) && dict.get(username).equals(password)) {
                return true;
            }
        }
        return false;

    }

}
