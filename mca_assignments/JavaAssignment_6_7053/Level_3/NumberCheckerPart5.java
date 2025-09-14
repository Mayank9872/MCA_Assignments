package Level_3;

import java.util.Scanner;

public class NumberCheckerPart5 {

    // Sum of proper divisors
    public static int sumOfDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum;
    }

    // Product of divisors
    public static int productOfDivisors(int num) {
        int product = 1;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) product *= i;
        }
        return product;
    }

    // Cube product of divisors
    public static long cubeProductOfDivisors(int num) {
        long product = 1;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) product *= (i * i * i);
        }
        return product;
    }

    // Perfect number
    public static boolean isPerfect(int num) {
        return sumOfDivisors(num) == num;
    }

    // Abundant number
    public static boolean isAbundant(int num) {
        return sumOfDivisors(num) > num;
    }

    // Deficient number
    public static boolean isDeficient(int num) {
        return sumOfDivisors(num) < num;
    }

    // Strong number (sum factorial of digits)
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    public static boolean isStrong(int num) {
        int sum = 0, temp = num;
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Sum of divisors: " + sumOfDivisors(num));
        System.out.println("Product of divisors: " + productOfDivisors(num));
        System.out.println("Cube product of divisors: " + cubeProductOfDivisors(num));
        System.out.println("Perfect number: " + isPerfect(num));
        System.out.println("Abundant number: " + isAbundant(num));
        System.out.println("Deficient number: " + isDeficient(num));
        System.out.println("Strong number: " + isStrong(num));

        
    }
}
