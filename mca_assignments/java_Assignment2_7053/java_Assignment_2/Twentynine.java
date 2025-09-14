import java.util.Scanner;

public class Twentynine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int original = num, rev = 0;
        while(num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        System.out.println((rev == original) ? "Palindrome" : "Not Palindrome");
        sc.close();
    }
}
