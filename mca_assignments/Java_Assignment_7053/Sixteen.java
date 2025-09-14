// write a program to demonstate the use of a static final variable.
class Sixteen {
    public static final double PI = 3.14159;
    public static void main(String[] args) {
        System.out.println("Value of PI: " + Sixteen.PI);
        double radius = 5.0;
        double area = PI * radius * radius;

        System.out.println("Area of circle with radius " + radius + " is: " + area);
    }
}


