import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            int sumWhile = 0;
            int counter = 1;

            while (counter <= n) {
                sumWhile += counter;
                counter++;
            }

            int sumFormula = n * (n + 1) / 2;

            System.out.println("Sum using while loop: " + sumWhile);
            System.out.println("Sum using formula n*(n+1)/2: " + sumFormula);

            if (sumWhile == sumFormula) {
                System.out.println("Both computations are correct!");
            } else {
                System.out.println("There is a mismatch in computations.");
            }
        }

        sc.close();
    }
}
