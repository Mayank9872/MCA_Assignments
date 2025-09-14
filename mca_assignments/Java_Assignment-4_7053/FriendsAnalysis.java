import java.util.Scanner;

public class FriendsAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter Amar's height: ");
        double amarHeight = sc.nextDouble();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter Akbar's height: ");
        double akbarHeight = sc.nextDouble();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Enter Anthony's height: ");
        double anthonyHeight = sc.nextDouble();

        // Find youngest
        int minAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        if (minAge == amarAge) {
            System.out.println("The youngest friend is Amar.");
        } else if (minAge == akbarAge) {
            System.out.println("The youngest friend is Akbar.");
        } else {
            System.out.println("The youngest friend is Anthony.");
        }

        // Find tallest
        double maxHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        if (maxHeight == amarHeight) {
            System.out.println("The tallest friend is Amar.");
        } else if (maxHeight == akbarHeight) {
            System.out.println("The tallest friend is Akbar.");
        } else {
            System.out.println("The tallest friend is Anthony.");
        }

        sc.close();
    }
}
