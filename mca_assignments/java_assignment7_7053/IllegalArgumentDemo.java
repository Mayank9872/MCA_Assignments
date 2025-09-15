import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String text) {
        // Start index > End index → causes IllegalArgumentException
        System.out.println("Substring: " + text.substring(5, 2));
    }

    public static void handleException(String text) {
        try {
            System.out.println("Substring: " + text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
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
