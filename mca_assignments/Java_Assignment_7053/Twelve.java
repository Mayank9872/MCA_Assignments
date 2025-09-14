// write a program to demonstrate type promotion in arithmetic operations.
class Twelve {
    public static void main(String[] args) {
        
        byte b = 10;
        short s = 20;
        char c = 30;
        int i = 40;
        long l = 50L;
        float f = 60.0f;
        double d = 70.0;

        int result1 = b + s + c;
        System.out.println("Result of b + s + c (promoted to int): " + result1);

        long result2 = i + l;
        System.out.println("Result of i + l (promoted to long): " + result2);

        float result3 = l + f;
        System.out.println("Result of l + f (promoted to float): " + result3);

        double result4 = f + d;
        System.out.println("Result of f + d (promoted to double): " + result4);

        int result5 = b + i;
        System.out.println("Result of b + i (promoted to int): " + result5);
    }
}
