/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.model;

import java.sql.Timestamp;

/**
 *
 * @author ANH KIET
 */
public class Transaction {
    private int id;
    private double amount;
    private String transactionType;
    private Account fromAccount; // Composition
    private Account toAccount; // Composition
    private Timestamp  time;
    // Constructor, getters, and setters omitted for brevity

    public Transaction(double amount, String transactionType, Account fromAccount, Account toAccount, Timestamp time) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.time = time;
    }

    public Transaction() {
    }

    public Transaction(int id, double amount, String transactionType, Account fromAccount, Account toAccount, Timestamp time) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.time = time;
    }
    
    public String getTransactionDetail() {
    StringBuilder details = new StringBuilder();
    details.append("Transaction Details:\n")
           .append("ID: ").append(id).append("\n")
           .append("Amount: ").append(amount).append("\n")
           .append("Transaction Type: ").append(transactionType).append("\n")
           .append("From Account: ")
           .append(fromAccount != null ? fromAccount.getAccountId(): "N/A").append("\n") // Assuming Account has getId()
           .append("To Account: ")
           .append(toAccount != null ? toAccount.getAccountId(): "N/A").append("\n") // Assuming Account has getId()
           .append("Timestamp: ").append(time != null ? time.toString() : "N/A");
    return details.toString();
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    
    public void output(){
        System.out.println(this.getId() + " " + this.getAmount() + " " + this.getFromAccount().getAccountId() + " " + this.getToAccount().getAccountId());
    }
}
