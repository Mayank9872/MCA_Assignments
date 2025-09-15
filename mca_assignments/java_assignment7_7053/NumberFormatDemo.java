import java.util.Scanner;

public class NumberFormatDemo {

    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Converted number: " + number);
    }

    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.next();

        System.out.println("\nCalling method to generate exception:");
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }

        System.out.println("\nCalling method to handle exception:");
        handleException(input);

        sc.close();
    }
}
