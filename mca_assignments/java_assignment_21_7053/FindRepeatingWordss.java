import java.util.regex.*;

public class FindRepeatingWordss {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\b\\s+\\1\\b";

        Matcher m = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(text);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}
