// write a program to show the difference between char and string datatypes.
class eleven {
    public static void main(String[] args) {
        char singleChar = 'A';
        String word = "Apple";
        System.out.println("Using char:");
        System.out.println("Value of singleChar: " + singleChar);

        System.out.println("\nUsing String:");
        System.out.println("Value of word: " + word);

        System.out.println("\nLength of char (always 1): " + 1);
        System.out.println("Length of String: " + word.length());

        System.out.println("\nConcatenating char and String:");
        System.out.println("char + String: " + (singleChar + word));
    }
}

