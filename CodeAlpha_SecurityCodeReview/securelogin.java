import java.security.MessageDigest;
import java.util.Scanner;

    public class securelogin {

        public static String hashPassword(String password) throws Exception {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hash = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();

            for(byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        }

        public static void main(String[] args) throws Exception {

            Scanner sc = new Scanner(System.in);

            String storedUser = "UROOJ";

            String storedHash =
                    hashPassword("UROOJ123");

            System.out.print("Username: ");
            String user = sc.nextLine();

            System.out.print("Password: ");
            String pass = sc.nextLine();

            if(user.equals(storedUser) &&
                    hashPassword(pass).equals(storedHash)) {

                System.out.println("Login Successful");

            } else {

                System.out.println("Login Failed");
            }
        }
    }

