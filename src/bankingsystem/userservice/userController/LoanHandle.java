/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userController;
import bankingsystem.database.userDB.DatabaseConnection;
import bankingsystem.model.CheckingAccount;
import bankingsystem.model.Loan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ANH KIET
 */
public class LoanHandle {

    public LoanHandle() {
    }

    void addNewLoan(double amount, CheckingAccount account) {
    Loan db_loan = getLoanByAccountId(account); // Retrieve existing loan
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        // Initialize the database connection
        conn = DatabaseConnection.initializeDatabaze();

        if (db_loan != null) {
            // SQL query to update the loan amount
            String sql = "UPDATE loans SET amount = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setDouble(1, db_loan.getAmount() + amount); // Add to existing loan amount
            pstmt.setInt(2, db_loan.getId());
        } else {
            // SQL query to insert a new loan
            String sql = "INSERT INTO loans (account_id, amount, status) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, account.getAccountId());
            pstmt.setDouble(2, amount);
            pstmt.setString(3, "Pending"); // Assuming the initial status is "Pending"
        }

        // Execute the update or insert query
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace(); // Handle SQL exceptions
    } finally {
        try {
            // Close resources
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


    public Loan getLoanByAccountId(CheckingAccount account) {
    Loan loan = null; // To hold the result
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        // Initialize the database connection
        conn = DatabaseConnection.initializeDatabaze();

        // SQL query to fetch loan details
        String sql = "SELECT id, amount, status FROM loans WHERE account_id = ?";

        // Prepare the statement
        pstmt = conn.prepareStatement(sql);

        // Set the account_id parameter
        pstmt.setString(1, account.getAccountId());

        // Execute the query
        rs = pstmt.executeQuery();

        // Process the result set
        if (rs.next()) {
            int id = rs.getInt("id");
            double amount = rs.getDouble("amount");
            String status = rs.getString("status");

            // Create and populate a Loan object
            loan = new Loan(id, account,amount, status);
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

    return loan;
}

    
}
