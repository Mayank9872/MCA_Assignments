package Level_3;

import java.util.Scanner;

public class NumberCheckerPart3 {

    // Reverse number
    public static int reverseNumber(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    // Palindrome check
    public static boolean isPalindrome(int num) {
        return num == reverseNumber(num);
    }

    // Duck number check
    public static boolean isDuck(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Reversed number: " + reverseNumber(num));
        System.out.println("Palindrome: " + isPalindrome(num));
        System.out.println("Duck number: " + isDuck(num));

        
    }
}

