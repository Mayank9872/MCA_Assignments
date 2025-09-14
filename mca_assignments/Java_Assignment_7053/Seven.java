// write a program to print default values of instance variables in a class.
class Seven {
    byte byteVar;
    short shortVar;
    int intVar;
    long longVar;
    float floatVar;
    double doubleVar;
    char charVar;
    boolean booleanVar;
    String stringVar;

    public void printDefaultValues() {
        System.out.println("Default byte: " + byteVar);
        System.out.println("Default short: " + shortVar);
        System.out.println("Default int: " + intVar);
        System.out.println("Default long: " + longVar);
        System.out.println("Default float: " + floatVar);
        System.out.println("Default double: " + doubleVar);
        System.out.println("Default char: '" + charVar + "'");
        System.out.println("Default boolean: " + booleanVar);
        System.out.println("Default String: " + stringVar);
    }

    public static void main(String[] args) {
        Seven obj = new Seven();
        obj.printDefaultValues();
    }
}

