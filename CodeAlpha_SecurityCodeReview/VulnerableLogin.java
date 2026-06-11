import java.util.Scanner;

public class VulnerableLogin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if(username.equals("UROOJ") && password.equals("urooj123")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");


        }
        username.equals("UROOJ");
        password.equals("urooj123");
    }
}