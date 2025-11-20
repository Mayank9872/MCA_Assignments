import java.util.regex.*;

public class ValidateeeSSN {
    public static void main(String[] args) {
        String text = "My SSN is 123-45-6789.";
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        Matcher m = Pattern.compile(regex).matcher(text);
        if (m.find()) {
            System.out.println("Valid SSN: " + m.group());
        } else {
            System.out.println("Invalid SSN");
        }
    }
}
