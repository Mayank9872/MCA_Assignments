package Level_3;

import java.util.Scanner;

public class NumberCheckerPart1 {

    // Count digits
    public static int countDigits(int num) {
        int count = 0;
        int temp = num;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

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

    // Duck number check
    public static boolean isDuck(int num) {
        int temp = num;
        while (temp > 0) {
            if (temp % 10 == 0) {
                return true;
            }
            temp /= 10;
        }
        return false;
    }

    // Armstrong number check
    public static boolean isArmstrong(int num) {
        int digits = countDigits(num);
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            int d = temp % 10;
            int pow = 1;
            for (int i = 0; i < digits; i++) {
                pow *= d; // calculate d^digits
            }
            sum += pow;
            temp /= 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Number of digits: " + countDigits(num));
        System.out.println("Duck number: " + isDuck(num));
        System.out.println("Armstrong number: " + isArmstrong(num));

        
    }
}
