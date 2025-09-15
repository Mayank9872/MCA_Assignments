import java.util.Scanner;

public class FirstNonRepeating {

    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256]; 

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0'; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char firstUnique = findFirstNonRepeatingChar(text);

        if (firstUnique != '\0') {
            System.out.println("First non-repeating character: " + firstUnique);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}
