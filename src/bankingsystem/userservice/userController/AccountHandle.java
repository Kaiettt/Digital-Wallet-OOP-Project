/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userController;

import bankingsystem.database.userDB.DBConnection;
import bankingsystem.database.userDB.DatabaseConnection;
import bankingsystem.model.Account;
import bankingsystem.model.Bank;
import bankingsystem.model.CheckingAccount;
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
public class AccountHandle {
    public AccountHandle(){
        
    }
   
    
    public List<CheckingAccount> getCheckingAccounts(User user) throws ClassNotFoundException, SQLException {
    PreparedStatement pstmt = null;
    Connection conn = DBConnection.getConnection();
    ResultSet rs = null;
    List<CheckingAccount> accounts = new ArrayList<>();

    // Define the SQL query to fetch accounts by user_id
    String sql = "SELECT account_id, balance, account_type, overdraft_limit, user_id, bank_id "
               + "FROM checking_accounts WHERE user_id = ?";

    try {
        // Prepare the SQL statement
        pstmt = conn.prepareStatement(sql);

        // Set the user_id parameter to filter the accounts
        pstmt.setInt(1, user.getId());

        // Execute the query
        rs = pstmt.executeQuery();

        // Loop through the result set and map it to CheckingAccount objects
        while (rs.next()) {
            Bank bank = new Bank();
            bank.setId(rs.getInt("bank_id"));
//            user.setId(rs.getInt('user_id'));
            CheckingAccount account = new CheckingAccount();
            account.setAccountId(rs.getString("account_id"));
            account.setBalance(rs.getInt("balance"));
            account.setAccountType("Checking");
            account.setUser(user);
            account.setBank(bank);
            // Add the account to the list
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
     public CheckingAccount getAccountById(String id) throws SQLException, ClassNotFoundException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    User user = null;
    CheckingAccount account = null;
    Connection conn = DBConnection.getConnection();

    // SQL query to fetch the user's name associated with the checking account
    String sql = "SELECT name FROM users WHERE id = (SELECT user_id FROM checking_accounts WHERE account_id = ?)";

    try {
        // Prepare the statement
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);

        // Execute the query
        rs = pstmt.executeQuery();

        if (rs.next()) {
            // Get the user's name
            String name = rs.getString("name");

            // Create a User object
            user = new User();
            user.setName(name);

            // Create a CheckingAccount object and associate it with the user
            account = new CheckingAccount();
            account.setAccountId(id);
            account.setUser(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception or rethrow as a custom exception
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return account;

}

public void updateBalance(CheckingAccount from_account, Account to_account) throws ClassNotFoundException {
    // Define the SQL query
    String sql = "UPDATE checking_accounts SET balance = ? WHERE account_id = ?";

    // Get the connection object
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstm = conn.prepareStatement(sql)) {

        // Update the "from_account" balance
        pstm.setDouble(1, from_account.getBalance()); // Set the new balance
        pstm.setString(2, from_account.getAccountId()); // Use the account ID for the WHERE clause
        int rowsAffectedFrom = pstm.executeUpdate();
        System.out.println("Rows updated for 'from_account': " + rowsAffectedFrom);

        // Update the "to_account" balance
        pstm.setDouble(1, to_account.getBalance()); // Set the new balance
        pstm.setString(2, to_account.getAccountId()); // Use the account ID for the WHERE clause
        int rowsAffectedTo = pstm.executeUpdate();
        System.out.println("Rows updated for 'to_account': " + rowsAffectedTo);

    } catch (SQLException e) {
        // Handle SQL exceptions
        e.printStackTrace();
    }
}


void saveNewAccount(CheckingAccount account) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        // Initialize database connection
        conn = DatabaseConnection.initializeDatabaze();

        // SQL query to insert a new checking account
        String sql = "INSERT INTO checking_accounts " +
                     "(account_id, balance, account_type, overdraft_limit, user_id, bank_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        // Prepare the statement
        pstmt = conn.prepareStatement(sql);

        // Set parameters using the account object
        pstmt.setString(1, account.getAccountId()); // Assuming account_id is an int
        pstmt.setDouble(2, account.getBalance()); // Assuming balance is a double
        pstmt.setString(3, account.getAccountType()); // Assuming account_type is a String
        pstmt.setDouble(4, 5); // Assuming overdraft_limit is a double
        pstmt.setInt(5, account.getUser().getId()); // Assuming user_id is an int
        pstmt.setInt(6, account.getBank().getId()); // Assuming bank_id is an int

        // Execute the query
        int rowsInserted = pstmt.executeUpdate();

        // Check the result
        if (rowsInserted > 0) {
            System.out.println("A new checking account was saved successfully!");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log exception for debugging
    } finally {
        // Close resources in the finally block to ensure they are always released
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle closing exceptions
        }
    }
}
    
public void deleteAccountbyId(String id) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        // Initialize database connection
        conn = DatabaseConnection.initializeDatabaze();

        // SQL query to delete an account based on account_id
        String sql = "DELETE FROM checking_accounts WHERE account_id = ?";

        // Prepare the statement
        pstmt = conn.prepareStatement(sql);

        // Set the parameter
        pstmt.setString(1, id); // Assuming account_id is stored as a string

        // Execute the query
        int rowsDeleted = pstmt.executeUpdate();

        // Check the result
        if (rowsDeleted > 0) {
            System.out.println("Account with ID " + id + " was successfully deleted!");
        } else {
            System.out.println("No account found with ID " + id + ".");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log exception for debugging
    } finally {
        // Close resources in the finally block to ensure they are always released
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle closing exceptions
        }
    }
}

    void updateAccount(CheckingAccount account) {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        // Initialize the database connection
        conn = DatabaseConnection.initializeDatabaze();

        // SQL query to update bank_id for the specific account_id
        String sql = "UPDATE checking_accounts SET bank_id = ? WHERE account_id = ?";

        // Prepare the SQL statement
        pstmt = conn.prepareStatement(sql);

        // Set the parameters
        pstmt.setInt(1, account.getBank().getId()); // Assuming getBank().getBankId() returns the bank ID
        pstmt.setString(2, account.getAccountId()); // Assuming getAccountId() returns the account ID

        // Execute the update
        int rowsUpdated = pstmt.executeUpdate();

        // Check if the update was successful
        if (rowsUpdated > 0) {
            System.out.println("Account updated successfully.");
        } else {
            System.out.println("No account found with the given ID.");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle any SQL exceptions
    } finally {
        // Close the resources in the finally block to avoid resource leaks
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


}
