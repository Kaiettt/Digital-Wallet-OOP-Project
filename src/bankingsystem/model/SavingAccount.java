/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.model;

/**
 *
 * @author ANH KIET
 */
public class SavingAccount extends Account {
    private double interestRate;
    public SavingAccount(String accountId, double balance, String accountType, User user, Bank bank, double interestRate) {
        super(accountId, balance, accountType, user, bank);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Saving Account ID: " + getAccountId());
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate);
    }
}

