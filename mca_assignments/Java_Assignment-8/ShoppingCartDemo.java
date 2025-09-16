import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return price * quantity;
    }

    void displayItem() {
        System.out.println(itemName + " | Price: " + price + " | Quantity: " + quantity + " | Total: " + getTotalPrice());
    }
}

class ShoppingCart {
    ArrayList<CartItem> cart = new ArrayList<>();

    void addItem(CartItem item) {
        cart.add(item);
        System.out.println(item.itemName + " added to the cart.");
    }

    void removeItem(String itemName) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equalsIgnoreCase(itemName)) {
                System.out.println(cart.get(i).itemName + " removed from the cart.");
                cart.remove(i);
                return;
            }
        }
        System.out.println("Item not found in the cart.");
    }

    void displayTotalCost() {
        double total = 0;
        System.out.println("\nCart Items:");
        for (CartItem item : cart) {
            item.displayItem();
            total += item.getTotalPrice();
        }
        System.out.println("Total Cart Value: " + total);
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        CartItem item1 = new CartItem("Laptop", 55000, 1);
        CartItem item2 = new CartItem("Headphones", 2000, 2);
        CartItem item3 = new CartItem("Mouse", 800, 1);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        cart.displayTotalCost();

        cart.removeItem("Headphones");
        cart.displayTotalCost();
    }
}
