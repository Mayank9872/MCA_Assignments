import java.util.Scanner;

public class StringSplitDemo {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] splitUsingCharAt(String str) {
        int length = findLength(str);

        // Count words
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        String currentWord = "";

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                currentWord += ch;
            } else {
                words[wordIndex] = currentWord;
                wordIndex++;
                currentWord = "";
            }
        }
        words[wordIndex] = currentWord; // last word
        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] userDefined = splitUsingCharAt(text);
        String[] builtIn = text.split(" ");

        boolean result = compareStringArrays(userDefined, builtIn);

        System.out.print("\nWords using user-defined split: ");
        for (String word : userDefined) {
            System.out.print(word + " | ");
        }

        System.out.print("\nWords using built-in split(): ");
        for (String word : builtIn) {
            System.out.print(word + " | ");
        }

        System.out.println("\nComparison result: " + result);

        sc.close();
    }
}
