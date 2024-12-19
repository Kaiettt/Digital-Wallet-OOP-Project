/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userController;

import bankingsystem.database.userDB.DatabaseConnection;
import bankingsystem.model.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ANH KIET
 */
public class BankHandle {
    
   

public List<Bank> getAllBanks() {
    String sql = "SELECT id, name, branch FROM banks";
    List<Bank> bankList = new ArrayList<>();
    
    // Initialize the connection
    try (Connection conn = DatabaseConnection.initializeDatabaze();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        
        // Iterate through the result set
        while (rs.next()) {
            // Create a new Bank object for each row
            Bank bank = new Bank();
            bank.setId(rs.getInt("id"));         // Assuming id is an integer
            bank.setName(rs.getString("name")); // Assuming name is a string
            bank.setBranch(rs.getString("branch")); // Assuming branch is a string
            
            // Add the Bank object to the list
            bankList.add(bank);
        }
        
    } catch (Exception e) {
        e.printStackTrace(); // Print stack trace for debugging
    }
    
    return bankList; // Return the list of banks
}

}
