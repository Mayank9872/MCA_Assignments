import java.util.Scanner;

public class SplitWordsWithLength {

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
        words[wordIndex] = currentWord;
        return words;
    }

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = splitUsingCharAt(text);
        String[][] wordWithLengths = getWordsWithLengths(words);

        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (int i = 0; i < wordWithLengths.length; i++) {
            String word = wordWithLengths[i][0];
            int length = Integer.parseInt(wordWithLengths[i][1]);
            System.out.println(word + "\t" + length);
        }

        sc.close();
    }
}
