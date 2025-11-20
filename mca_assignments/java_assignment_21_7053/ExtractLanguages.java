import java.util.regex.*;
import java.util.*;

public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        String regex = "\\b(Java|Python|JavaScript|Go|C|C\\+\\+|C#|Ruby|PHP|Kotlin|Swift|R|TypeScript)\\b";

        Matcher m = Pattern.compile(regex).matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
