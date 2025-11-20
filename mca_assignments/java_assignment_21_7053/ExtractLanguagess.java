import java.util.regex.*;

public class ExtractLanguagess {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        String regex = "\\b(Java|Python|JavaScript|Go|C|C\\+\\+|C#|Ruby|PHP|Kotlin|Swift|React|Angular|TypeScript)\\b";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
