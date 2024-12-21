/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.adminservice.adminController;

import bankingsystem.database.userDB.DatabaseConnection;
import bankingsystem.model.User;
import java.util.List;

/**
 *
 * @author ANH KIET
 */
import bankingsystem.database.userDB.DBConnection;
import bankingsystem.database.userDB.DatabaseConnection;
import bankingsystem.model.Account;
import bankingsystem.model.Bank;
import bankingsystem.model.CheckingAccount;
import bankingsystem.model.Role;
import bankingsystem.model.SavingAccount;
import bankingsystem.model.Transaction;
import bankingsystem.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AdminServiceHandle {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Initialize the database connection
            conn = DatabaseConnection.initializeDatabaze();
            
            // Define the SQL query
            String sql = "SELECT id, name, email, phone_number,gender, address,role_id FROM users";

            // Prepare the statement
            pstmt = conn.prepareStatement(sql);

            // Execute the query
            rs = pstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                int role_id = rs.getInt("role_id");
                Role role = null;
                if(role_id == 1){
                    role = new Role(1, "ADMIN");
                }
                else role = new Role(2, "USER");
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setAddress(rs.getString("address"));
                user.setRole(role);
                
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    public List<Bank> getAllBanks() {
      List<Bank> banks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Initialize the database connection
            conn = DatabaseConnection.initializeDatabaze();
            
            // Define the SQL query
            String sql = "SELECT id, name, branch FROM banks";

            // Prepare the statement
            pstmt = conn.prepareStatement(sql);

            // Execute the query
            rs = pstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                Bank bank = new Bank();
                bank.setId(rs.getInt("id"));
                bank.setName(rs.getString("name"));
                bank.setBranch(rs.getString("branch"));
                banks.add(bank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return banks;
    }

   public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Initialize the database connection
            conn = DatabaseConnection.initializeDatabaze();

            // Define the SQL query
            String sql = "SELECT amount, from_account_id, to_account_id, event_date FROM transactions";

            // Prepare the statement
            pstmt = conn.prepareStatement(sql);

            // Execute the query
            rs = pstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                CheckingAccount from_account = new CheckingAccount();
                CheckingAccount to_account = new CheckingAccount();
                from_account.setAccountId(rs.getString("from_account_id"));
                to_account.setAccountId(rs.getString("to_account_id"));
                Transaction transaction = new Transaction();
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setFromAccount(from_account);
                transaction.setToAccount(to_account);
                transaction.setTime(rs.getTimestamp("event_date"));
                transactions.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return transactions;
    }
    
}
