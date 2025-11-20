import java.util.regex.*;

public class ValidateLicensePlate {
    public static void main(String[] args) {
        String plate = "AB1234";

        String regex = "^[A-Z]{2}[0-9]{4}$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(plate);

        if (m.matches()) {
            System.out.println("Valid License Plate");
        } else {
            System.out.println("Invalid License Plate");
        }
    }
}
