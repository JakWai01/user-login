import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scan.nextLine();
        System.out.println("Enter password: ");
        String password = scan.nextLine();
        Main check = new Main();
        if (check.is_valid_credentials(username, password)) {
            System.out.println("Seriously??? You chose password123 as your password?");

        } else {
            System.out.println("GET LOST!");

        }

    }

    public boolean is_valid_credentials(String username, String password) {
        if (username.equals("robert") && password.equals("password123")) {
            return true;
        }
        else {
            return false;
        }
    }

}
