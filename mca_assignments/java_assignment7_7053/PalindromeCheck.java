import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Iterative comparison from start and end
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive method
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using reverse array comparison
    public static boolean isPalindromeArray(String text) {
        int len = text.length();
        char[] original = text.toCharArray();
        char[] reverse = new char[len];

        for (int i = 0; i < len; i++) {
            reverse[i] = text.charAt(len - 1 - i);
        }

        for (int i = 0; i < len; i++) {
            if (original[i] != reverse[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text to check palindrome: ");
        String text = sc.nextLine();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean arrayResult = isPalindromeArray(text);

        System.out.println("Palindrome check (Iterative): " + iterativeResult);
        System.out.println("Palindrome check (Recursive): " + recursiveResult);
        System.out.println("Palindrome check (Array method): " + arrayResult);

        sc.close();
    }
}
