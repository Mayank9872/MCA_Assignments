package Level_3;

import java.util.Scanner;

public class NumberCheckerPart2 {

    // Sum of digits
    public static int sumDigits(int num) {
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

    // Sum of squares of digits
    public static int sumSquaresDigits(int num) {
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            int d = temp % 10;
            sum += d * d; // square of digit
            temp /= 10;
        }
        return sum;
    }

    // Harshad number check
    public static boolean isHarshad(int num) {
        int sum = sumDigits(num);
        return num % sum == 0;
    }

    // Frequency of digits
    public static void digitFrequency(int num) {
        for (int i = 0; i <= 9; i++) {
            int temp = num;
            int count = 0;
            while (temp > 0) {
                if (temp % 10 == i) {
                    count++;
                }
                temp /= 10;
            }
            if (count > 0) {
                System.out.println("Digit " + i + ": " + count + " times");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Sum of digits: " + sumDigits(num));
        System.out.println("Sum of squares of digits: " + sumSquaresDigits(num));
        System.out.println("Harshad number: " + isHarshad(num));
        System.out.println("Digit frequency:");
        digitFrequency(num);

        
    }
}
