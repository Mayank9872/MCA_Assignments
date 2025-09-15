import java.util.Scanner;

public class BMICalculator {

    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0;

            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 25) status = "Normal";
            else if (bmi < 30) status = "Overweight";
            else status = "Obese";

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }

        return result;
    }

    public static void displayBMI(String[][] bmiData) {
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < bmiData.length; i++) {
            System.out.printf("%-10s %-10s %-10s %-15s%n", 
                              bmiData[i][0], bmiData[i][1], bmiData[i][2], bmiData[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        double[][] data = new double[n][2];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();
            System.out.print("Weight (kg): ");
            data[i][0] = sc.nextDouble();
        }

        String[][] bmiData = calculateBMI(data);
        displayBMI(bmiData);

        sc.close();
    }
}
