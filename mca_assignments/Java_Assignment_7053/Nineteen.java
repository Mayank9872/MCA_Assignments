// write a program  to check if a long value can be stored in a float variable and display the result.
class Nineteen {
    public static void main(String[] args) {
        // Test long values
        long[] testValues = {
            123456789L,
            1234567890123456789L,
            16777216L,      
            Long.MAX_VALUE
        };

        for (long value : testValues) {
            float floatValue = (float) value;
            long roundTrip = (long) floatValue;

            System.out.println("Original long: " + value);
            System.out.println("Converted to float: " + floatValue);
            System.out.println("Back to long: " + roundTrip);

            if (value == roundTrip) {
                System.out.println(" Can be stored in float without precision loss.\n");
            } else {
                System.out.println(" Cannot be stored in float accurately.\n");
            }
        }
    }
}


