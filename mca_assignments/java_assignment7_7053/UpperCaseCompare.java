import java.util.Scanner;

public class UpperCaseCompare {

    public static String convertToUpperUsingCharAt(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32); // convert lowercase to uppercase
            } else {
                result += ch; // keep as is
            }
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

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String userDefined = convertToUpperUsingCharAt(text);
        String builtIn = text.toUpperCase();

        boolean result = compareUsingCharAt(userDefined, builtIn);

        System.out.println("\nConverted using charAt(): " + userDefined);
        System.out.println("Converted using toUpperCase(): " + builtIn);
        System.out.println("Comparison result: " + result);

        sc.close();
    }
}
