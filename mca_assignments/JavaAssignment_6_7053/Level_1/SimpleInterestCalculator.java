package Level_1;

import java.util.Scanner;

public class SimpleInterestCalculator {

    // Function to calculate Simple Interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        double si = (principal * rate * time) / 100;
        return si;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter Principal amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = sc.nextDouble();

        // Call the function
        double si = calculateSimpleInterest(principal, rate, time);

        // Output
        System.out.println("The Simple Interest is " + si +
                " for Principal " + principal +
                ", Rate of Interest " + rate +
                " and Time " + time);

        sc.close();
    }
}

