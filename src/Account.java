package src;

import java.util.ArrayList;


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
        trans.add(transaction); // add to src.Transactions ArrayList
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
            System.out.println("NO src.Transactions YET!");
        }
        else {
            System.out.println("Transaction history for src.Account : " + accountNumber);
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