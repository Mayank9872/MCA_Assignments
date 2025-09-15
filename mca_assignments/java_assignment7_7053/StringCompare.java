import java.util.Scanner;

public class StringCompare {
    
    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        // First check if lengths are equal
        if (s1.length() != s2.length()) {
            return false;
        }
        // Compare character by character
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter first string: ");
        String str1 = sc.next();

        System.out.print("Enter second string: ");
        String str2 = sc.next();

        boolean resultCharAt = compareUsingCharAt(str1, str2);

        boolean resultEquals = str1.equals(str2);

        System.out.println("\nComparison using charAt(): " + resultCharAt);
        System.out.println("Comparison using equals(): " + resultEquals);

        if (resultCharAt == resultEquals) {
            System.out.println("✅ Both methods give the SAME result.");
        } else {
            System.out.println("❌ Results are DIFFERENT.");
        }

        sc.close();
    }
}
