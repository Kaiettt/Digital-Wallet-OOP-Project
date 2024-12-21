package bankingsystem.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ANH KIET
 */
public abstract class Account {
    private String accountId;
    private double balance;
    private String accountType;
    private User user; // Aggregation
    private Bank bank; // Aggregation
    
    public Account(){
        
    }
    // Constructor
    public Account(String accountId, double balance, String accountType, User user, Bank bank) {
        this.accountId = accountId;
        this.balance = balance;
        this.accountType = accountType;
        this.user = user;
        this.bank = bank;
    }


    public void makeTrasaction(double money){
        this.balance  = this.balance - money;
    }
    public void receiveMoney(double money){
        this.balance = this.balance + money;
    }
    // Getters and setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    // Abstract method
    public abstract void displayAccountDetails();
}

