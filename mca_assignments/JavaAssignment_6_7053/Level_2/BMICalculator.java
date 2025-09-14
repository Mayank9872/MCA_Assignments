package Level_2;

import java.util.Scanner;

public class BMICalculator {

    public static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        return weight / (heightM * heightM);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter weight (kg) of person " + i + ": ");
            double weight = sc.nextDouble();

            System.out.print("Enter height (cm) of person " + i + ": ");
            double height = sc.nextDouble();

            double bmi = calculateBMI(weight, height);

            System.out.println("BMI of person " + i + " = " + bmi);

            if (bmi < 18.5) {
                System.out.println("Status: Underweight");
            } else if (bmi < 25) {
                System.out.println("Status: Normal");
            } else if (bmi < 30) {
                System.out.println("Status: Overweight");
            } else {
                System.out.println("Status: Obese");
            }
        }

        
    }
}
