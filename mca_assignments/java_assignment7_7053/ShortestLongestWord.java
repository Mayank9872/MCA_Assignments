import java.util.Scanner;

public class ShortestLongestWord {

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

    public static int[] findShortestAndLongest(String[][] wordWithLengths) {
        int minIndex = 0, maxIndex = 0;
        int minLen = Integer.parseInt(wordWithLengths[0][1]);
        int maxLen = Integer.parseInt(wordWithLengths[0][1]);

        for (int i = 1; i < wordWithLengths.length; i++) {
            int length = Integer.parseInt(wordWithLengths[i][1]);
            if (length < minLen) {
                minLen = length;
                minIndex = i;
            }
            if (length > maxLen) {
                maxLen = length;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = splitUsingCharAt(text);
        String[][] wordWithLengths = getWordsWithLengths(words);
        int[] result = findShortestAndLongest(wordWithLengths);

        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (int i = 0; i < wordWithLengths.length; i++) {
            System.out.println(wordWithLengths[i][0] + "\t" + wordWithLengths[i][1]);
        }

        System.out.println("\nShortest Word: " + wordWithLengths[result[0]][0] +
                           " (Length: " + wordWithLengths[result[0]][1] + ")");
        System.out.println("Longest Word: " + wordWithLengths[result[1]][0] +
                           " (Length: " + wordWithLengths[result[1]][1] + ")");

        sc.close();
    }
}
