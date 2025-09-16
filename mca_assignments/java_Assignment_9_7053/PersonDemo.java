class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Piyush", 25);
        Person p2 = new Person(p1);

        System.out.println("Original Person:");
        p1.displayDetails();

        System.out.println("\nCloned Person:");
        p2.displayDetails();
    }
}
