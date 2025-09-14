package Level_1;

import java.util.Scanner;

public class HandshakeCalculator {

    // Function to calculate maximum handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Call the function
        int maxHandshakes = calculateHandshakes(n);

        // Output
        System.out.println("The maximum number of possible handshakes among " + n +
                           " students is: " + maxHandshakes);

        sc.close();
    }
}

