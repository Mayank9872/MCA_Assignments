// write a program to demonstate implicit and explicit type casting.
class Eight {
    public static void main(String[] args) {
        int intVal = 100;
        long longVal = intVal;      
        float floatVal = longVal;   

        System.out.println("Implicit Type Casting:");
        System.out.println("int value: " + intVal);
        System.out.println("long value (from int): " + longVal);
        System.out.println("float value (from long): " + floatVal);
        System.out.println();

        double doubleVal = 99.99;
        int castedInt = (int) doubleVal;     
        byte castedByte = (byte) castedInt;  

        System.out.println("Explicit Type Casting:");
        System.out.println("double value: " + doubleVal);
        System.out.println("int value (from double): " + castedInt);
        System.out.println("byte value (from int): " + castedByte);
    }
}



