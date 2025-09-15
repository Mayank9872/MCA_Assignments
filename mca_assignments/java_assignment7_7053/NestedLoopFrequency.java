import java.util.Scanner;

public class NestedLoopFrequency {

    public static String[][] charFrequencies(String text) {
        char[] chars = text.toCharArray();
        int len = chars.length;
        int[] freq = new int[len];

        for (int i = 0; i < len; i++) {
            freq[i] = 1;
            if (chars[i] == '0') continue;
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') count++;
        }

        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[index][0] = String.valueOf(chars[i]);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
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
