/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userController;
import bankingsystem.database.userDB.DBConnection;
import bankingsystem.model.Account;
import bankingsystem.model.CheckingAccount;
import bankingsystem.model.Transaction;
import bankingsystem.model.User;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ANH KIET
 */
public class TransactionHandle {
    private AccountHandle accountHandle;
    public TransactionHandle(){
        this.accountHandle=  new AccountHandle();
    }
    public List<CheckingAccount> getAccountsInTransactions(CheckingAccount account) throws SQLException, ClassNotFoundException{
        PreparedStatement pstmt = null;
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        List<CheckingAccount> accounts = new ArrayList<>();
        String sql = "SELECT TOP 6 ca.account_id, u.name AS user_name, u.phone_number AS phone_number " +
                     "FROM checking_accounts ca " +
                     "INNER JOIN users u ON ca.user_id = u.id " +
                     "WHERE ca.account_id IN (" +
                     "    SELECT t.to_account_id " +
                     "    FROM transactions t " +
                     "    WHERE t.from_account_id = ?" +
                     ");";

        try {
        // Prepare the SQL statement
        pstmt = conn.prepareStatement(sql);

        // Set the user_id parameter to filter the accounts
        pstmt.setString(1, account.getAccountId());  // Set the from_account_id parameter

        // Execute the query
        rs = pstmt.executeQuery();

        // Loop through the result set and map it to CheckingAccount objects
        while (rs.next()) {
            User user = new User();
            user.setName(rs.getString("user_name"));
            CheckingAccount account_db = new CheckingAccount();
            account_db.setUser(user);
            account_db.setAccountId(rs.getString("account_id"));
            
            accounts.add(account_db);
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

    
    
    public Transaction CreateTransaction(String money, CheckingAccount from_account, Account to_account) throws SQLException, ClassNotFoundException {
    double from_money = from_account.getBalance()-Double.parseDouble(money);
    double to_money = to_account.getBalance()+Double.parseDouble(money);
    System.out.println(".()");
    from_account.setBalance(from_money);
    to_account.setBalance(to_money);
    accountHandle.updateBalance(from_account,to_account);
    Transaction transaction = new Transaction();
    transaction.setAmount(Double.parseDouble(money));
    transaction.setFromAccount(from_account);
    transaction.setToAccount(to_account);
    Instant now = Instant.now();
    transaction.setTime(Timestamp.from(now));
    
    // Get the connection
    Connection conn = DBConnection.getConnection();
    
    // SQL query to insert a transaction
    String sql = "INSERT INTO transactions (amount, from_account_id, to_account_id, event_date, transaction_type) "
               + "VALUES (?, ?, ?, ?, ?)";
    
    // Create the PreparedStatement with Statement.RETURN_GENERATED_KEYS
    try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setDouble(1, transaction.getAmount());
        pstmt.setString(2, transaction.getFromAccount().getAccountId());
        pstmt.setString(3, transaction.getToAccount().getAccountId());
        pstmt.setTimestamp(4, transaction.getTime());
        pstmt.setString(5, "Transfer"); // Set the transaction type as "Transfer"

        // Execute the update
        int rowAffected = pstmt.executeUpdate();
        
        // Check if the row was affected
        if (rowAffected > 0) {
            // Get the generated keys (auto-generated ID for the transaction)
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int transactionId = generatedKeys.getInt(1); // Get the first column (auto-incremented ID)
                    transaction.setId(transactionId); // Set the transaction ID to the created transaction object
                    System.out.println("A transaction was created with ID: " + transactionId);
                } else {
                    System.out.println("No ID obtained.");
                }
            }
        } else {
            System.out.println("Insertion failed.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return transaction;
}

    public List<Transaction> getTransactionsbyAccount(CheckingAccount account) throws SQLException, ClassNotFoundException {
    List<Transaction> transactions = new ArrayList<>();
    String mainAccountId = account.getAccountId();

    // SQL query to fetch transactions where the account is either sender or receiver
    String sql = "SELECT id,amount, from_account_id,to_account_id, event_date FROM transactions " +
                 "WHERE from_account_id = ? OR to_account_id = ?";

    try (Connection conn = DBConnection.getConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Set the parameters for the query
        pstmt.setString(1, mainAccountId);
        pstmt.setString(2, mainAccountId);

        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                // Extract data from ResultSet
                double amount = rs.getDouble("amount");
                String toAccountId = rs.getString("to_account_id");
                String fromAccountId = rs.getString("from_account_id");
                CheckingAccount to_account = accountHandle.getAccountById(toAccountId);
                CheckingAccount from_account = accountHandle.getAccountById(fromAccountId);
                Timestamp eventDate = rs.getTimestamp("event_date");

                // Create a Transaction object
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setAmount(amount);
                transaction.setFromAccount(from_account);
                transaction.setToAccount(to_account);
                transaction.setTime(eventDate);

                // Add the transaction to the list
                transactions.add(transaction);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception or rethrow as a custom exception
    }

    return transactions;
}



}


