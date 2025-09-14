// write a program to show memory allocation difference between primitive and reference variables.
class Fifteen {
    public static void main(String[] args) {
        int primitiveValue = 10;
        Integer referenceValue = Integer.valueOf(10);
        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Primitive value: " + primitiveValue);
        System.out.println("Reference value (Integer): " + referenceValue);
        System.out.println("Array contents:");
        for (int val : array) {
            System.out.print(val + " ");
        }

        System.out.println("\n");
        System.out.println("IdentityHashCode of referenceValue: " + System.identityHashCode(referenceValue));
        System.out.println("IdentityHashCode of array: " + System.identityHashCode(array));
        System.out.println("\n--- Memory Concept Explanation ---");
        System.out.println("Primitive types are stored directly in the stack (inside method frames).");
        System.out.println("Reference types store the reference in the stack, but the actual object is in the heap.");
    }
}



