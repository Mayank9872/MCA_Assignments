import java.util.*;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int n = 5;
        List<String> result = generateBinaryNumbers(n);
        System.out.println("First " + n + " Binary Numbers: " + result);
    }

    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < n; i++) {
            String front = queue.remove();
            result.add(front);

            queue.add(front + "0");
            queue.add(front + "1");
        }

        return result;
    }
}
