// write a program to demonstrate numeric overflow in java.
class Eighteen {
    public static void main(String[] args) {
        int maxInt = Integer.MAX_VALUE;
        int overflowInt = maxInt + 1;
        byte maxByte = Byte.MAX_VALUE; 
        byte overflowByte = (byte)(maxByte + 1); 
        short maxShort = Short.MAX_VALUE; 
        short overflowShort = (short)(maxShort + 1);
        
        long maxLong = Long.MAX_VALUE;
        long overflowLong = maxLong + 1;
        System.out.println("=== Integer Overflow ===");
        System.out.println("Max int: " + maxInt);
        System.out.println("Max int + 1: " + overflowInt); 
        System.out.println("\n=== Byte Overflow ===");
        System.out.println("Max byte: " + maxByte);
        System.out.println("Max byte + 1: " + overflowByte); 

        System.out.println("\n=== Short Overflow ===");
        System.out.println("Max short: " + maxShort);
        System.out.println("Max short + 1: " + overflowShort); 

        System.out.println("\n=== Long Overflow ===");
        System.out.println("Max long: " + maxLong);
        System.out.println("Max long + 1: " + overflowLong); 
    }
}


