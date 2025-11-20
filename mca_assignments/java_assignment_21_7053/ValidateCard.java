public class ValidateCard {
    public static void main(String[] args) {
        String card = "5123456789012345";

        String regex = "^(4\\d{15}|5\\d{15})$";

        if (card.matches(regex)) {
            if (card.startsWith("4")) {
                System.out.println("Valid Visa Card");
            } else if (card.startsWith("5")) {
                System.out.println("Valid MasterCard");
            }
        } else {
            System.out.println("Invalid Card Number");
        }
    }
}
