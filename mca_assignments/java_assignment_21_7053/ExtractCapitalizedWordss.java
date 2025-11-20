import java.util.regex.*;

public class ExtractCapitalizedWordss {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        Pattern p = Pattern.compile("\\b[A-Z][a-zA-Z]*\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            if (!m.group().equals("The"))
                System.out.println(m.group());
        }
    }
}
