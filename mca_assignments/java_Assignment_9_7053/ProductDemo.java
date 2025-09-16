class Product {
    String productName;
    double price;
    static int totalProducts = 0;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}

public class ProductDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Headphones", 2000);
        Product p3 = new Product("Mouse", 800);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
        System.out.println();
        p3.displayProductDetails();
        System.out.println();

        Product.displayTotalProducts();
    }
}
