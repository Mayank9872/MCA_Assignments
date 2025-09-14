package Level_3;

import java.util.Scanner;

public class StudentMarksBasicMethods {

    // Method to calculate total
    public static int calculateTotal(int phy, int chem, int math) {
        return phy + chem + math;
    }

    // Method to calculate average
    public static double calculateAverage(int total) {
        return total / 3.0;
    }

    // Method to calculate percentage (assuming max 100 per subject)
    public static double calculatePercentage(int total) {
        return total / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Student " + i + ":");
            System.out.print("Physics: ");
            int phy = sc.nextInt();
            System.out.print("Chemistry: ");
            int chem = sc.nextInt();
            System.out.print("Maths: ");
            int math = sc.nextInt();

            int total = calculateTotal(phy, chem, math);
            double avg = calculateAverage(total);
            double percent = calculatePercentage(total);

            System.out.println("Total: " + total + ", Average: " + Math.round(avg*100)/100.0 + ", Percentage: " + Math.round(percent*100)/100.0 + "%");
        }

        
    }
}
