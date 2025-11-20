import java.util.Scanner;

public class ValidateHexColor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String color = sc.nextLine();

        if (color.matches("^#[0-9A-Fa-f]{6}$")) {
            System.out.println("Valid Hex Color");
        } else {
            System.out.println("Invalid Hex Color");
        }
    }
}
