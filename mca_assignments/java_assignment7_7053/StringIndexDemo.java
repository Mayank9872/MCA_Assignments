import java.util.Scanner;

public class StringIndexDemo {

    public static void generateException(String text) {
        System.out.println("Character at position 100: " + text.charAt(100));
    }

    public static void handleException(String text) {
        try {
            System.out.println("Character at position 100: " + text.charAt(100));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
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
