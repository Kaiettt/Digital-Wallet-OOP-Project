/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.model;

/**
 *
 * @author ANH KIET
 */
public class CheckingAccount extends Account {
    public CheckingAccount(String accountId, double balance, String accountType, User user, Bank bank) {
        super(accountId, balance, accountType, user, bank);
    }
    public CheckingAccount(){
        
    }
    @Override
    public void displayAccountDetails() {
        System.out.println("Checking Account ID: " + getAccountId());
        System.out.println("Balance: " + getBalance());
    }
}

