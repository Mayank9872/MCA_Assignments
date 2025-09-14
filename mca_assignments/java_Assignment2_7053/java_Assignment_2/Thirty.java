import java.util.Scanner;

public class Thirty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 numbers:");
        for(int i=0; i<10; i++)
            arr[i] = sc.nextInt();
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int num : arr) {
            if(num > largest) {
                secondLargest = largest;
                largest = num;
            } else if(num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        System.out.println("Second largest: " + secondLargest);
        sc.close();
    }
}
