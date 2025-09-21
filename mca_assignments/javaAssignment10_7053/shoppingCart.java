class Product {
 	private static double discount = 10.0; 
 	private final int productID; 
 	private String productName;
 	private double price;
 	private int quantity;

 	public Product(int productID, String productName, double price, int quantity) {
     	this.productID = productID;
     	this.productName = productName;
     	this.price = price;
     	this.quantity = quantity;
 	}

 	public void displayProductDetails() {
     	if (this instanceof Product) { 
			System.out.println("Product details :\n");
         	System.out.println("Product ID : " + productID);
         	System.out.println("Name : " + productName);
         	System.out.println("Price : Rs. " + price);
         	System.out.println("Quantity : " + quantity);
         	System.out.println("Discount : " + discount + "%");
     	}
 	}

 	public static void updateDiscount(double newDiscount) {
     	discount = newDiscount;
 	}
 }

 
 public class shoppingCart {
 	public static void main(String[] args) {
     	Product prod1 = new Product(30, "Washing machine", 6500, 1);
     	Product prod2 = new Product(31, "Shoes", 1100, 3);

     	prod1.displayProductDetails();
     	prod2.displayProductDetails();
     	Product.updateDiscount(15);
     	System.out.println("Discount has been updated!");
 	}
 }

