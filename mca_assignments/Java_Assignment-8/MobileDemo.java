class MobilePhone {
    String brand;
    String model;
    double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
}

public class MobileDemo {
    public static void main(String[] args) {
        MobilePhone m1 = new MobilePhone("Samsung", "Galaxy S23", 75000);
        MobilePhone m2 = new MobilePhone("Apple", "iPhone 15", 120000);

        System.out.println("Mobile Phone 1:");
        m1.displayDetails();

        System.out.println("\nMobile Phone 2:");
        m2.displayDetails();
    }
}
