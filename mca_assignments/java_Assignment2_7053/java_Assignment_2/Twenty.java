import java.util.Scanner;

public class Twenty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        String result = (num % 3 == 0 && num % 5 == 0) ? "Divisible by both" : "Not divisible by both";
        System.out.println(result);
        sc.close();
    }
}
