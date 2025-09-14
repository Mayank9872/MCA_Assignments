// write a program to demonstrate autoboxing and unboxing.
class Nine {
    public static void main(String[] args) {
        int primitiveInt = 50;
        Integer boxedInt = primitiveInt;  
        
        System.out.println("Autoboxing:");
        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Boxed Integer: " + boxedInt);
        System.out.println();

        Double boxedDouble = 99.99;        
        double primitiveDouble = boxedDouble;  

        System.out.println("Unboxing:");
        System.out.println("Boxed Double: " + boxedDouble);
        System.out.println("Primitive double: " + primitiveDouble);
    }
}


