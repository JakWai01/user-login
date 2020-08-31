import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> dict = new HashMap<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scan.nextLine();
        System.out.println("Enter password: ");
        String password = scan.nextLine();

        dict.put("robert", "password123");
        dict.put("Jakob", "password123");
        System.out.println(dict.get("robert"));


        Main check = new Main();

        if (check.is_valid_credentials(dict, username, password)) {
            System.out.println("Seriously??? You chose password123 as your password?");
        } else {
            System.out.println("GET LOST!");
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
