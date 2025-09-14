//  write a program to use var(java 10+) for type inference.
class Seventeen {
    public static void main(String[] args) {
        var number = 10; 
        var pi = 3.14159; 
        var message = "Hello, Java 10!";
        var names = java.util.List.of("Alice", "Bob", "Charlie");
        for (var name : names) {
            System.out.println("Name: " + name);
        }

        var map = java.util.Map.of("India", "New Delhi", "USA", "Washington D.C.");
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nInferred Types:");
        System.out.println("number is of type: " + ((Object)number).getClass().getSimpleName());
        System.out.println("pi is of type: " + ((Object)pi).getClass().getSimpleName());
        System.out.println("message is of type: " + message.getClass().getSimpleName());
        System.out.println("names is of type: " + names.getClass().getName());
    }
}


