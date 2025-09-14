// write a program to use wrapper class methods to convert numbers to binary and hexadecimal.
import java.util.Scanner;
class Fourteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int number = scanner.nextInt();

        String binaryStr = Integer.toBinaryString(number);
        String hexStr = Integer.toHexString(number);

        System.out.println("Binary representation: " + binaryStr);
        System.out.println("Hexadecimal representation: " + hexStr);

        scanner.close();
    }
}

