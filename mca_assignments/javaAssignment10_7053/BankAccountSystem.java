class BankAccount {
 	private static String bankName = "SBI"; 
 	private static int totalAccounts = 0; 
 	private final int accountNumber; 
 	private String accountHolderName;
 	private double balance;
  
 	
 	public BankAccount(int accountNumber, String accountHolderName, double balance) {
     	this.accountNumber = accountNumber;
     	this.accountHolderName = accountHolderName;
   	  this.balance = balance;
     	totalAccounts++; 
 	}

 	public void displayAccountDetails() {
     	if (this instanceof BankAccount ) { 
			System.out.println("Bank account details :\n");
         	System.out.println("Bank Name : " + bankName);
         	System.out.println("Account Number : " + accountNumber);
         	System.out.println("Account Holder:  " + accountHolderName);
         	System.out.println("Balance : Rs. " + balance);
     	}
 	}

 	public static void getTotalAccounts() {
     	System.out.println("Total Bank Accounts : " + totalAccounts);
 	}
 }

 
 public class BankAccountSystem {
 	public static void main(String[] args) {
     	BankAccount acc1 = new BankAccount(10, "Rahul", 120000);
     	BankAccount acc2 = new BankAccount(11, "Niraj", 250000);

     	acc1.displayAccountDetails();
     	acc2.displayAccountDetails();
     	BankAccount.getTotalAccounts();
 	}
 

 }

