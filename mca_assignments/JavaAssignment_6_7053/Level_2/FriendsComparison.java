package Level_2;

import java.util.Scanner;

public class FriendsComparison {

    public static int findYoungest(int age1, int age2, int age3) {
        if (age1 < age2 && age1 < age3) {
            return 1;
        } else if (age2 < age1 && age2 < age3) {
            return 2;
        } else {
            return 3;
        }
    }

    public static int findTallest(int h1, int h2, int h3) {
        if (h1 > h2 && h1 > h3) {
            return 1;
        } else if (h2 > h1 && h2 > h3) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age of Amar: ");
        int age1 = sc.nextInt();
        System.out.print("Enter height of Amar: ");
        int h1 = sc.nextInt();

        System.out.print("Enter age of Akbar: ");
        int age2 = sc.nextInt();
        System.out.print("Enter height of Akbar: ");
        int h2 = sc.nextInt();

        System.out.print("Enter age of Anthony: ");
        int age3 = sc.nextInt();
        System.out.print("Enter height of Anthony: ");
        int h3 = sc.nextInt();

        int youngest = findYoungest(age1, age2, age3);
        int tallest = findTallest(h1, h2, h3);

        if (youngest == 1) System.out.println("Youngest is Amar");
        if (youngest == 2) System.out.println("Youngest is Akbar");
        if (youngest == 3) System.out.println("Youngest is Anthony");

        if (tallest == 1) System.out.println("Tallest is Amar");
        if (tallest == 2) System.out.println("Tallest is Akbar");
        if (tallest == 3) System.out.println("Tallest is Anthony");

        
    }
}
