import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3]; 
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            int physics, chemistry, maths;

            System.out.print("Physics: ");
            physics = sc.nextInt();
            if (physics < 0) {
                System.out.println("Invalid marks. Enter again.");
                i--;
                continue;
            }

            System.out.print("Chemistry: ");
            chemistry = sc.nextInt();
            if (chemistry < 0) {
                System.out.println("Invalid marks. Enter again.");
                i--;
                continue;
            }

            System.out.print("Maths: ");
            maths = sc.nextInt();
            if (maths < 0) {
                System.out.println("Invalid marks. Enter again.");
                i--;
                continue;
            }

            marks[i][0] = physics;
            marks[i][1] = chemistry;
            marks[i][2] = maths;

            int total = physics + chemistry + maths;
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) {
                grade[i] = 'A';
            } else if (percentage[i] >= 75) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else {
                grade[i] = 'F';
            }
        }

        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d -> Physics: %d, Chemistry: %d, Maths: %d, Percentage: %.2f, Grade: %c%n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }

        sc.close();
    }
}
