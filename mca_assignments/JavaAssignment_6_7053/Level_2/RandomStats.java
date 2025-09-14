package Level_2;

public class RandomStats {

    public static void main(String[] args) {
        int[] numbers = new int[5];

        // Generate 5 random 4-digit numbers
        for (int i = 0; i < 5; i++) {
            numbers[i] = (int) (1000 + Math.random() * 9000);
        }

        System.out.println("Generated numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int sum = 0, min = numbers[0], max = numbers[0];
        for (int i = 0; i < 5; i++) {
            sum += numbers[i];
            if (numbers[i] < min) min = numbers[i];
            if (numbers[i] > max) max = numbers[i];
        }

        double avg = (double) sum / 5;

        System.out.println("Average = " + avg);
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }
}
