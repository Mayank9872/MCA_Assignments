import java.util.Scanner;

public class Sixteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a >= b && a >= c)
            System.out.println("Largest: " + a);
        else if(b >= a && b >= c)
            System.out.println("Largest: " + b);
        else
            System.out.println("Largest: " + c);
        sc.close();
    }
}
