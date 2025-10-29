import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMax {
    static void printMax(int[] arr, int n, int k) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.removeFirst();
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.removeLast();
            dq.addLast(i);
            if (i >= k - 1) System.out.print(arr[dq.peekFirst()] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        printMax(arr, arr.length, k);
    }
}
