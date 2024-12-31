package src;

import java.util.ArrayList;

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