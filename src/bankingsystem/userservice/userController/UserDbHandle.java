/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userController;

import bankingsystem.database.userDB.DBConnection;
import bankingsystem.model.Account;
import bankingsystem.model.CheckingAccount;
import bankingsystem.model.Role;
import bankingsystem.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANH KIET
 */
public class UserDbHandle {
    
    
    public List<Account> getAcountByUserId(int id) throws SQLException, ClassNotFoundException{
        PreparedStatement pstmt = null;
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id from checking_accounts where user_id = ?";

        try {
        // Prepare the SQL statement
        pstmt = conn.prepareStatement(sql);

        // Set the user_id parameter to filter the accounts
        pstmt.setInt(1, id);  // Set the from_account_id parameter

        // Execute the query
        rs = pstmt.executeQuery();

        // Loop through the result set and map it to CheckingAccount objects
        while (rs.next()) {
            CheckingAccount account = new CheckingAccount();
            account.setAccountId(rs.getString("account_id"));
            
            accounts.add(account);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close the resources
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return accounts;
    }
    public List<User> findUserByName(String name) throws SQLException, ClassNotFoundException{
        PreparedStatement pstmt = null;
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, name FROM users WHERE name Like ?";

        try {
        // Prepare the SQL statement
        pstmt = conn.prepareStatement(sql);

        // Set the user_id parameter to filter the accounts
        pstmt.setString(1, name);  // Set the from_account_id parameter

        // Execute the query
        rs = pstmt.executeQuery();

        // Loop through the result set and map it to CheckingAccount objects
        while (rs.next()) {
            User user = new User();
            user.setName(rs.getString("name"));
            user.setId(rs.getInt("id"));
            List<Account> accounts = getAcountByUserId(user.getId());
            user.setAccount(accounts);
            users.add(user);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close the resources
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return users;
    }
    
   
}


