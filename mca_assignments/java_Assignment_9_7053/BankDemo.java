class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void displaySavingsDetails() {
        System.out.println("Account Number (public accessed in subclass): " + accountNumber);
        System.out.println("Account Holder (protected accessed in subclass): " + accountHolder);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Balance (accessed via public method): " + getBalance());
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("ACC123", "Piyush", 5000);
        account1.displayAccountDetails();
        account1.deposit(2000);
        account1.withdraw(1500);
        System.out.println("\nAfter Transactions:");
        account1.displayAccountDetails();

        SavingsAccount savings = new SavingsAccount("ACC456", "Aarav", 10000, 4.5);
        System.out.println("\nSavings Account Details:");
        savings.displaySavingsDetails();
    }
}
