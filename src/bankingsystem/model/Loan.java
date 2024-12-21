/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.model;

/**
 *
 * @author ANH KIET
 */
public class Loan {
    private int id;
    private Account account; // Composition
    private double amount;
    private String status;
    public Loan() {
    }
    public Loan(int id, Account account, double amount, String status) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }



    
    // Constructor, getters, and setters omitted for brevity
}

