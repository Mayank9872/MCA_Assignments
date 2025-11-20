import java.util.Scanner;

public class LicensePlateValidator {
    public static boolean isValid(String plate) {
        return plate.matches("^[A-Z]{2}[0-9]{4}$");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String plate = sc.nextLine();

        if (isValid(plate)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
