import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String text1 = "My SSN is 123-45-6789.";
        String text2 = "My SSN is 123456789.";

        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        System.out.println(text1.matches(".*" + regex + ".*") ? "123-45-6789 is valid" : "Invalid");
        System.out.println(text2.matches(".*" + regex + ".*") ? "Valid" : "123456789 is invalid");
    }
}
