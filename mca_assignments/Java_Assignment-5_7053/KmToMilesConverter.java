import java.util.Scanner;

public class KmToMilesConverter {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        double km;

        System.out.print("Enter distance in kilometers: ");
        km = SC.nextDouble();

        double miles = km / 1.6;

        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");

        SC.close();
    }
}
