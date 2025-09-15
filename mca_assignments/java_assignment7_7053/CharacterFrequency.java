import java.util.Scanner;

public class CharacterFrequency {

    public static String[][] getCharFrequencies(String text) {
        int[] freq = new int[256]; 

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean counted = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    counted = true;
                    break;
                }
            }
            if (!counted) uniqueCount++;
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean counted = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    counted = true;
                    break;
                }
            }
            if (!counted) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                index++;
            }
        }

        return result;
    }

    public static void displayFrequencies(String[][] freqData) {
        System.out.printf("%-10s %-10s%n", "Character", "Frequency");
        System.out.println("--------------------");
        for (int i = 0; i < freqData.length; i++) {
            System.out.printf("%-10s %-10s%n", freqData[i][0], freqData[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] freqData = getCharFrequencies(text);
        displayFrequencies(freqData);

        sc.close();
    }
}
