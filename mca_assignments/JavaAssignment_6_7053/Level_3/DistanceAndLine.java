package Level_3;

import java.util.Scanner;

public class DistanceAndLine {

    // Method to calculate Euclidean distance
    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Method to calculate slope
    public static double calculateSlope(int x1, int y1, int x2, int y2) {
        return (double)(y2 - y1) / (x2 - x1);
    }

    // Method to calculate intercept
    public static double calculateIntercept(int x1, int y1, double slope) {
        return y1 - slope * x1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1 y1 x2 y2: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.println("Euclidean distance: " + distance);

        double slope = calculateSlope(x1, y1, x2, y2);
        double intercept = calculateIntercept(x1, y1, slope);
        System.out.println("Equation of line: y = " + slope + "x + " + intercept);

        
    }
}
