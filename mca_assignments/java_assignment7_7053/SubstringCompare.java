import java.util.Scanner;

public class SubstringCompare {

    public static String createSubstringUsingCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String subCharAt = createSubstringUsingCharAt(text, start, end);
        String subBuiltIn = text.substring(start, end);

        boolean resultCompare = compareUsingCharAt(subCharAt, subBuiltIn);

        System.out.println("\nSubstring using charAt(): " + subCharAt);
        System.out.println("Substring using built-in substring(): " + subBuiltIn);
        System.out.println("Comparison result: " + resultCompare);

        sc.close();
    }
}
