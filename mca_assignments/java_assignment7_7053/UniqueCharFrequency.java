import java.util.Scanner;

public class UniqueCharFrequency {

    public static int getStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static char[] uniqueCharacters(String text) {
        int len = getStringLength(text);
        char[] temp = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j] == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[uniqueCount] = ch;
                uniqueCount++;
            }
        }

        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }
        return uniqueChars;
    }

    public static String[][] charFrequencies(String text) {
        int[] freq = new int[256]; 
        int len = getStringLength(text);
        for (int i = 0; i < len; i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    public static void displayFrequencies(String[][] data) {
        System.out.printf("%-10s %-10s%n", "Character", "Frequency");
        System.out.println("--------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10s %-10s%n", data[i][0], data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] freqData = charFrequencies(text);
        displayFrequencies(freqData);

        sc.close();
    }
}
