
import java.io.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

abstract class Account{
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected ArrayList<Transactions> trans = new ArrayList<>();

    public Account(String accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
        Transactions transaction = new Transactions("Deposit", amount, "Deposit to account"); // Record the transaction
        trans.add(transaction); // add to Transactions ArrayList
        System.out.println(amount + " : Deposited. " + " New Balance : " + balance);
    }

    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("INSUFFICIENT BANK BALANCE!");
        }
        else{
            balance -= amount;
            Transactions transaction = new Transactions("Withdraw", amount, "Withdraw to account"); // Record the transaction
            trans.add(transaction); // Add to Transaction ArrayList
            System.out.println(amount + " : withdraw. " + " Remaining Balance : " + balance);
        }
    }

    public void showTransactionHistory(){
        if(trans.isEmpty()){
            System.out.println("NO Transactions YET!");
        }
        else {
            System.out.println("Transaction history for Account : " + accountNumber);
            for (Transactions transaction : trans) {
                System.out.println(transaction);
            }
        }
    }

    public double getBalance(){
        return balance;
    }

    public abstract void displayAccountDetails();

}

class savingAccount extends Account{
    private double interstRate;

    public savingAccount(String accountNumber, String accountHolderName, double balance, double interstRate){
        super(accountNumber, accountHolderName, balance);
        this.interstRate = interstRate;
    }

    public void addInterst(){
        double interst = balance * (interstRate)/100;
        deposit(interst);
    }

    @Override
    public void displayAccountDetails(){
        System.out.println("Saving Account - Account Number : " + accountNumber + ", Account Holder Name : " + accountHolderName + ", Balance : " + balance);
    }
}

class currentAccount extends Account{
    private double overdraftLimit;

    public currentAccount(String accountNumber, String accountHolderName, double balance, double overDratLimit){
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void withdraw(double amount){
        if(amount <= balance + overdraftLimit){
            System.out.println(amount + " withdrawn. " + balance + "remaining balance");
        }
        else{
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public void displayAccountDetails(){
        System.out.println("Current Account - Account Number : " + accountNumber + ", Account Holder Name : " + accountHolderName + ", Balance : " + balance);
    }
}

class Bank{
    private ArrayList<Account> accounts;

    Bank(){
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account){
        accounts.add(account);
        System.out.println("Account added sucessfully!");
    }

    public Account findAccount(String accountNumber){
        for(Account accountNum : accounts){
            if(accountNum.accountNumber.equals(accountNumber)){  // NOT UNDERSTAND
                return accountNum;
            }
        }
        return null;
    }

    public void transferfunds(String toAccount, String fromAccount, double amount){
        Account toTheAccount = findAccount(toAccount);
        Account fromTheAccount = findAccount(fromAccount);

        if(toTheAccount != null && fromTheAccount != null){
            fromTheAccount.withdraw(amount);
            toTheAccount.deposit(amount);
            System.out.println("Funds Transfer Successfully!");
        }
        else{
            System.out.println("Account NOT FOUND!");
        }
    }
}

class Transactions{
    private String type;
    private double amount;
    private String date;
    private String description;

    public Transactions(String type, double amount, String description){
        this.type = type;
        this.amount = amount;
        this.description = description;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.date = formatter.format(new Date());
    }

    @Override
    public String toString(){
        return "Date: " + date + "\t" + "Type: " + type + "\t" + "Amount: " + amount + "\t" + "Description: " + description;
    }

}

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        savingAccount saving1 = new savingAccount("2200430100008", "ANAND", 50000, 5.8);
        savingAccount saving2 = new savingAccount("2200430100006", "AMAN", 15000, 5.6);
        currentAccount current1 = new currentAccount("2200430100005", "AKHAND", 10000, 5.2);
        currentAccount current2 = new currentAccount("2200430100009", "ANAMIKA", 100000, 5.5);


        bank.addAccount(saving1);
        bank.addAccount(saving2);
        bank.addAccount(current1);
        bank.addAccount(current2);

        int choice;
        do{
            System.out.println("BANKING SYSTEM MENU");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer Funds");
            System.out.println("4. Check Balance");
            System.out.println("5. Display account details");
            System.out.println("6. EXIT");
            System.out.println("ENTER YOUR CHOICE : ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the bank account number : ");
                    String accNum = sc.next();
                    System.out.println("Enter the amount to deposit : ");
                    double depositAmount = sc.nextDouble();
                    Account acc = bank.findAccount(accNum);
                    if(acc != null){
                        acc.deposit(depositAmount);
                    }
                    else {
                        System.out.println("ACCOUNT NOT FOUND!");
                    }
                    break;

                case 2:
                    System.out.println("Enter the bank account number : ");
                    accNum = sc.next();
                    System.out.println("Enter the amount to withdraw : ");
                    double withdrawAmount = sc.nextDouble();
                    acc = bank.findAccount(accNum);
                    if(acc != null) {
                        acc.withdraw(withdrawAmount);
                    }
                    else{
                        System.out.println("ACCOUNT NOT FOUND!");
                    }
                    break;

                case 3:
                    System.out.println("Enter the bank account(fromAcc) number : ");
                    String fromAcc = sc.next();
                    System.out.println("Enter the bank account(toAcc) number : ");
                    String toAcc = sc.next();
                    System.out.println("Enter the amount to transfer : ");
                    double transferAmount = sc.nextDouble();
                    bank.transferfunds(toAcc, fromAcc, transferAmount);
                    break;

                case 4:
                    System.out.println("Enter the bank account number : ");
                    accNum = sc.next();
                    acc = bank.findAccount(accNum);
                    if(acc != null){
                        System.out.println("Current Balance : " + acc.getBalance());
                    }
                    else{
                        System.out.println("ACCOUNT NOT FOUND!");
                    }
                    break;

                case 5:
                    System.out.println("Enter the bank account number : ");
                    accNum = sc.next();
                    acc = bank.findAccount(accNum);
                    if(acc != null){
                        acc.displayAccountDetails();
                    }
                    else{
                        System.out.println("ACCOUNT NOT FOUND!");
                    }
                    break;

                case 6:
                    System.out.println("EXITING......!");
                    break;

                default:
                    System.out.println("INVALID CHOICE! Please try again.");
            }
        }while (choice != 6);
        sc.close();

    }
}



