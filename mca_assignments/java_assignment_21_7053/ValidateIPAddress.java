import java.util.regex.*;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String ip = "192.168.1.10";

        String regex = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}"
                     + "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ip);

        if (m.matches()) {
            System.out.println("Valid IP Address");
        } else {
            System.out.println("Invalid IP Address");
        }
    }
}
