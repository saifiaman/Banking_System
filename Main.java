
import java.io.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

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



