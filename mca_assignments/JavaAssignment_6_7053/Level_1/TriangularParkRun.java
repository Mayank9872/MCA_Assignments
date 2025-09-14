package Level_1;

import java.util.Scanner;

public class TriangularParkRun {

    public static double calculateRounds(double a, double b, double c, double distance) {
        double perimeter = a + b + c;
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side1 of the triangle (m): ");
        double side1 = sc.nextDouble();

        System.out.print("Enter side2 of the triangle (m): ");
        double side2 = sc.nextDouble();

        System.out.print("Enter side3 of the triangle (m): ");
        double side3 = sc.nextDouble();

        double rounds = calculateRounds(side1, side2, side3, 5000);
        System.out.println("The athlete must complete " + Math.ceil(rounds) + " rounds.");

        sc.close();
    }
}
