public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        for (String bad : badWords) {
            text = text.replaceAll("(?i)" + bad, "****");
        }

        System.out.println(text);
    }
}
