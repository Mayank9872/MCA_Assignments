import java.util.*;

public class NthFromEndExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2; 
        String result = findNthFromEnd(list, n);

        System.out.println("LinkedList: " + list);
        System.out.println("The " + n + "th element from the end is: " + result);
    }

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
      
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

      
        for (int i = 0; i < n; i++) {
            if (first.hasNext()) {
                first.next();
            } else {
                return null; 
            }
        }

     
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }
}
