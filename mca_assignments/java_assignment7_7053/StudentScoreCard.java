import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {

    public static int[][] generateRandomMarks(int n) {
        Random rand = new Random();
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            marks[i][0] = rand.nextInt(101); // Physics
            marks[i][1] = rand.nextInt(101); // Chemistry
            marks[i][2] = rand.nextInt(101); // Maths
        }
        return marks;
    }

    public static double[][] calculateTotalsPercentages(int[][] marks) {
        double[][] result = new double[marks.length][3]; // total, average, percentage
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = Math.round((total / 3.0) * 100.0) / 100.0;
            double percentage = Math.round((total / 300.0 * 100.0) * 100.0) / 100.0;
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    public static String[] calculateGrades(double[][] percentages) {
        String[] grades = new String[percentages.length];
        for (int i = 0; i < percentages.length; i++) {
            double perc = percentages[i][2];
            if (perc >= 90) grades[i] = "A+";
            else if (perc >= 80) grades[i] = "A";
            else if (perc >= 70) grades[i] = "B";
            else if (perc >= 60) grades[i] = "C";
            else if (perc >= 50) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayScoreCard(int[][] marks, double[][] totals, String[] grades) {
        System.out.printf("%-8s %-8s %-8s %-8s %-8s %-8s %-10s %-6s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        System.out.println("-----------------------------------------------------------------------");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-8s %-8d %-8d %-8d %-8.0f %-8.2f %-10.2f %-6s%n",
