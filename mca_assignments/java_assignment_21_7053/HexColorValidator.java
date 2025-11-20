import java.util.regex.*;

public class HexColorValidator {
    public static boolean isValidHexColor(String s) {
        return s.matches("^#[0-9A-Fa-f]{6}$");
    }

    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500"));
        System.out.println(isValidHexColor("#ff4500"));
        System.out.println(isValidHexColor("#123"));
    }
}
