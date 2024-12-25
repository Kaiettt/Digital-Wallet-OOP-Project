/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANH KIET
 */
public class Bank {
    private int id;
    private String name;
    private String branch;
    private List<Account> accounts;
    // Constructor, getters, and setters omitted for brevity

    public Bank() {
        this.accounts = new ArrayList<>();
    }


    public void addNewAccount(Account account){
        this.accounts.add(account);
    }
    public void removeAccount(Account account){
        this.accounts.remove(account);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
}

