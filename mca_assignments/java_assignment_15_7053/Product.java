import java.util.ArrayList;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void showProduct() {
        System.out.println(name + " - $" + price);
    }
}

class Order {
    int orderId;
    ArrayList<Product> products;
    Customer customer;

    Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        products = new ArrayList<>();
    }

    void addProduct(Product p) {
        products.add(p);
    }

    void showOrder() {
        System.out.println("Order ID: " + orderId + " by " + customer.name);
        for (Product p : products) {
            p.showProduct();
        }
        System.out.println();
    }
}

class Customer {
    String name;
    ArrayList<Order> orders;

    Customer(String name) {
        this.name = name;
        orders = new ArrayList<>();
    }

    void placeOrder(Order o) {
        orders.add(o);
        System.out.println(name + " placed Order ID: " + o.orderId);
    }

    void showOrders() {
        System.out.println("Customer: " + name);
        for (Order o : orders) {
            o.showOrder();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 800);
        Product p2 = new Product("Mouse", 20);
        Product p3 = new Product("Keyboard", 40);

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        Order o1 = new Order(101, c1);
        o1.addProduct(p1);
        o1.addProduct(p2);

        Order o2 = new Order(102, c2);
        o2.addProduct(p3);

        c1.placeOrder(o1);
        c2.placeOrder(o2);

        c1.showOrders();
        c2.showOrders();
    }
}
