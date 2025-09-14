import java.util.Scanner;

public class DiscountedFee {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        
        System.out.print("Enter the student fee in INR: ");
        double fee = SC.nextDouble();
        
        System.out.print("Enter the discount percentage: ");
        double discountPercent = SC.nextDouble();
        
        double discount = fee * discountPercent / 100.0;
        double finalFee = fee - discount;
        
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
        SC.close();
    }
}
