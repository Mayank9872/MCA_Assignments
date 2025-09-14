package Level_3;

import java.util.Scanner;

public class NumberCheckerPart4 {

    // Prime check
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Neon number check
    public static boolean isNeon(int num) {
        int square = num * num;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    // Spy number check
    public static boolean isSpy(int num) {
        int sum = 0, product = 1;
        while (num > 0) {
            int d = num % 10;
            sum += d;
            product *= d;
            num /= 10;
        }
        return sum == product;
    }

    // Automorphic check
    public static boolean isAutomorphic(int num) {
        int square = num * num;
        int temp = num;
        while (temp > 0) {
            if (temp % 10 != square % 10) return false;
            temp /= 10;
            square /= 10;
        }
        return true;
    }

    // Buzz number check
    public static boolean isBuzz(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Prime: " + isPrime(num));
        System.out.println("Neon: " + isNeon(num));
        System.out.println("Spy: " + isSpy(num));
        System.out.println("Automorphic: " + isAutomorphic(num));
        System.out.println("Buzz: " + isBuzz(num));

        
    }
}
