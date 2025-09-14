package Level_3;

import java.util.Scanner;

public class ZaraBonusBasicMethods {

    // Method to calculate bonus
    public static double calculateBonus(double salary, int years) {
        if (years > 5) return salary * 0.05;
        else return salary * 0.02;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter salary of employee " + i + ": ");
            double salary = sc.nextDouble();
            System.out.print("Enter years of service: ");
            int years = sc.nextInt();

            double bonus = calculateBonus(salary, years);
            double newSalary = salary + bonus;

            totalOldSalary += salary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.println("Old salary: " + salary + ", Bonus: " + bonus + ", New salary: " + newSalary);
        }

        System.out.println("\nTotal old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
        System.out.println("Total bonus amount: " + totalBonus);

        
    }
}
