import java.util.Scanner;

public class StringToCharArrayCompare {

    public static char[] getCharsUsingCharAt(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    public static boolean compareCharArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] userDefined = getCharsUsingCharAt(text);
        char[] builtIn = text.toCharArray();

        boolean result = compareCharArrays(userDefined, builtIn);

        System.out.print("\nCharacters using user-defined method: ");
        for (char c : userDefined) {
            System.out.print(c + " ");
        }

        System.out.print("\nCharacters using built-in toCharArray(): ");
        for (char c : builtIn) {
            System.out.print(c + " ");
        }

        System.out.println("\nComparison result: " + result);

        sc.close();
    }
}
