class BankAccount{
    int accountNumber;
    Double balance;
}

class SavingsAccount extends BankAccount{
    double interestRate;
    void displayAccountType(){
        System.out.println("\nAccount details :\n");
        System.out.println("Account number : "+accountNumber);
        System.out.println("Balance : Rs. "+balance);
    }
}

class CheckingAccount extends BankAccount{
    double withdrawLimit;
    void displayAccountType(){
        System.out.println("\nAccount details :\n");
        System.out.println("Account number : "+accountNumber);
        System.out.println("Balance : Rs. "+balance);
        System.out.println("Withdraw limit : Rs. "+withdrawLimit);
    }
}

class FixedDeposit extends BankAccount{
    double interestRate;
    double tenure;
    void displayAccountType(){
        System.out.println("\nAccount details :\n");
        System.out.println("Account number : "+accountNumber);
        System.out.println("Balance : Rs. "+balance);
        System.out.println("Interest rate : "+interestRate+" %");
        System.out.println("Tenure : "+tenure+" years");
    }
}
public class bankAccountTypes{
    public static void main(String[] args) {
        SavingsAccount acc1=new SavingsAccount();
        acc1.accountNumber=123;
        acc1.balance=20000.0;
        acc1.interestRate=12.3;
        acc1.displayAccountType();;

        CheckingAccount acc2=new CheckingAccount();
        acc2.accountNumber=124;
        acc2.balance=1200.0;
        acc2.withdrawLimit=500;
        acc2.displayAccountType();;

        FixedDeposit acc3=new FixedDeposit();
        acc3.accountNumber=125;
        acc3.balance=35000.4;
        acc3.interestRate=34.8;
        acc3.tenure=5.5;
        acc3.displayAccountType();;
    }
}