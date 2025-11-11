import java.util.*;

public class RemoveDuplicatesExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);

        List<Integer> result = removeDuplicates(numbers);

        System.out.println("Original List: " + numbers);
        System.out.println("After Removing Duplicates: " + result);
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> result = new ArrayList<>();
        Set<T> seen = new HashSet<>();

        for (T element : list) {
            if (!seen.contains(element)) {
                seen.add(element);
                result.add(element);
            }
        }

        return result;
    }
}
