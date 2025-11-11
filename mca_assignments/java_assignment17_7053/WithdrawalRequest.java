import java.util.*;

class WithdrawalRequest {
    String accountNumber;
    double amount;

    WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {
    Map<String, Double> accounts = new HashMap<>();
    Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public void requestWithdrawal(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        } else {
            System.out.println("Account " + accountNumber + " not found.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            double currentBalance = accounts.get(request.accountNumber);

            if (currentBalance >= request.amount) {
                accounts.put(request.accountNumber, currentBalance - request.amount);
                System.out.println("Withdrawal of ₹" + request.amount + " from account " + request.accountNumber + " successful.");
            } else {
                System.out.println("Insufficient balance for account " + request.accountNumber + ".");
            }
        }
    }

    public void displaySortedByBalance() {
        TreeMap<Double, String> sortedByBalance = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedByBalance.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, String> entry : sortedByBalance.entrySet()) {
            System.out.println(entry.getValue() + " -> ₹" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("A101", 5000);
        bank.addAccount("A102", 12000);
        bank.addAccount("A103", 3000);

        bank.requestWithdrawal("A101", 2000);
        bank.requestWithdrawal("A103", 4000);
        bank.requestWithdrawal("A102", 5000);

        System.out.println("\nProcessing Withdrawals:");
        bank.processWithdrawals();

        System.out.println("\nFinal Account Balances:");
        System.out.println(bank.accounts);

        System.out.println();
        bank.displaySortedByBalance();
    }
}
