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
// Users class
public class User {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private Role role; // Aggregation
    private String gender;
    private List<Account> accounts;
    public int getId() {
        return id;
    }
    public User(){
        this.accounts = new ArrayList<>();
    }
    public User(int id, String name, String email, String phoneNumber, String address, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.role = role;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getGender(){
        return this.gender;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public void setAccount(List<Account> accounts){
        this.accounts =accounts;
    }
    public List<Account> getAccounts(){
        return this.accounts;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
   

    // Constructor, getters, and setters omitted for brevity
}

