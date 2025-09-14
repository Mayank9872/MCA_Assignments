package Level_3;

import java.util.Scanner;

public class OTPGenerator {

    // Generate 6-digit OTP using basic formula
    public static int generateOTP(int seed) {
        int otp = (seed % 900000) + 100000; // 6-digit number
        return otp;
    }

    public static boolean checkUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] otps = new int[10];

        System.out.println("Enter 10 seed numbers to generate OTPs:");
        for (int i = 0; i < 10; i++) {
            int seed = sc.nextInt();
            otps[i] = generateOTP(seed);
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }

        System.out.println("All OTPs unique: " + checkUnique(otps));
        
    }
}
