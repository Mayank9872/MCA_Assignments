package Level_3;

import java.util.Scanner;

public class FootballHeights {

    // Method to find sum
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Method to find mean
    public static double findMean(int[] arr) {
        return (double) findSum(arr) / arr.length;
    }

    // Method to find shortest
    public static int findShortest(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Method to find tallest
    public static int findTallest(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[11];

        System.out.println("Enter the heights of 11 players in cms:");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.println("\nSum of heights: " + findSum(heights));
        System.out.println("Mean height: " + findMean(heights));
        System.out.println("Shortest player: " + findShortest(heights));
        System.out.println("Tallest player: " + findTallest(heights));

        
    }
}
