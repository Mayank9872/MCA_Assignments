public class NullPointerDemo {

    
    public static void generateException() {
        String text = null;
        System.out.println("Length of text: " + text.length()); 
    }

   
    public static void handleException() {
        String text = null;
        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Calling method to generate exception:");
        try {
            generateException();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }

        System.out.println("\nCalling method to handle exception:");
        handleException();
    }
}
