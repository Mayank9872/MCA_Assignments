public class CountingSortStudentAges {

    public static void countingSort(int[] ages) {
        int max = 18; // maximum possible age
        int min = 10; // minimum possible age
        int range = max - min + 1;

        int[] count = new int[range];  // count array
        int[] output = new int[ages.length]; // sorted output array

        // Step 1: Count frequency of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Step 2: Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build the output array (stable sort)
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        // Step 4: Copy sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] ages = {12, 18, 11, 14, 10, 13, 15, 12, 17, 10};

        countingSort(ages);

        System.out.println("Sorted Student Ages in Ascending Order:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}
