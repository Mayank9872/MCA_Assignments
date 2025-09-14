import java.util.Scanner;

public class LargestDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (number != 0) {
            int digit = number % 10;
            digits[index] = digit;
            index++;

            if (index == maxDigit) {
                System.out.println("Maximum digit storage reached (10 digits). Remaining digits not stored.");
                break;
            }

            number /= 10;
        }

        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < index; i++) {
            int d = digits[i];

            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }

        System.out.println("Largest digit = " + largest);
        if (secondLargest != -1) {
            System.out.println("Second Largest digit = " + secondLargest);
        } else {
            System.out.println("Second Largest digit not found (all digits same or only one digit entered).");
        }

        sc.close();
    }
}
