import java.util.*;

public class RotateListExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2; 
        System.out.println("Original List: " + numbers);
        rotateList(numbers, rotateBy);
        System.out.println("List after rotation by " + rotateBy + ": " + numbers);
    }

    public static <T> void rotateList(List<T> list, int k) {
        int n = list.size();
        k = k % n; 
        if (k == 0) return;

       
        List<T> rotated = new ArrayList<>();

       
        for (int i = k; i < n; i++) {
            rotated.add(list.get(i));
        }

       
        for (int i = 0; i < k; i++) {
            rotated.add(list.get(i));
        }

       
        for (int i = 0; i < n; i++) {
            list.set(i, rotated.get(i));
        }
    }
}
