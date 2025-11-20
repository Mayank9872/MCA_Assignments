import java.util.regex.*;
import java.util.*;

public class RepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        String regex = "\\b(\\w+)\\b\\s+\\1\\b";
        Matcher m = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(text);

        Set<String> set = new LinkedHashSet<>();

        while (m.find()) {
            set.add(m.group(1));
        }

        for (String w : set) {
            System.out.println(w);
        }
    }
}
