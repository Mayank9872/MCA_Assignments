import java.util.*;

public class ShoppingCart {
    Map<String, Double> priceMap = new HashMap<>();
    Map<String, Double> orderedCart = new LinkedHashMap<>();

    public void addItem(String product, double price) {
        priceMap.put(product, price);
        orderedCart.put(product, price);
    }

    public void displayItemsInOrder() {
        System.out.println("Items in order added:");
        for (Map.Entry<String, Double> entry : orderedCart.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }
    }

    public void displayItemsSortedByPrice() {
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
            sortedByPrice.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Items sorted by price:");
        for (Map.Entry<Double, String> entry : sortedByPrice.entrySet()) {
            System.out.println(entry.getValue() + " -> ₹" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Laptop", 55000);
        cart.addItem("Headphones", 2000);
        cart.addItem("Mouse", 800);
        cart.addItem("Keyboard", 1500);

        System.out.println("HashMap (Unordered):");
        System.out.println(cart.priceMap);

        System.out.println();
        cart.displayItemsInOrder();

        System.out.println();
        cart.displayItemsSortedByPrice();
    }
}
