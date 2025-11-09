import java.util.ArrayList;

class Bank {
    String name;
    ArrayList<Customer> customers;

    Bank(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    void openAccount(Customer c, double amount) {
        c.balance += amount;
        customers.add(c);
        System.out.println(c.name + " opened an account in " + name + " with balance: " + c.balance);
    }
}

class Customer {
    String name;
    double balance;

    Customer(String name) {
        this.name = name;
        this.balance = 0;
    }

    void viewBalance() {
        System.out.println(name + "'s balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank("State Bank");
        Bank bank2 = new Bank("City Bank");

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        bank1.openAccount(c1, 1000);
        bank2.openAccount(c2, 2000);

        c1.viewBalance();
        c2.viewBalance();
    }
}
