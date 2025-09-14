import java.util.Scanner;

public class Twentythree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int fact = 1, i = 1;
        do {
            fact *= i;
            i++;
        } while(i <= num);
        System.out.println("Factorial: " + fact);
        sc.close();
    }
}
