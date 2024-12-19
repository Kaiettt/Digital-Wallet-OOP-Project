/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userController;

import bankingsystem.model.Account;
import bankingsystem.model.Bank;
import bankingsystem.model.CheckingAccount;
import bankingsystem.model.Transaction;
import bankingsystem.model.User;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author ANH KIET
 */
public class UserServiceHandle {

    private LoginSignupHandle loginSignupHandle;
    private AccountHandle accountHandle;
    private TransactionHandle transactionHandle;
    private UserDbHandle userDbHandle;
    private BankHandle bankHandle;
    public UserServiceHandle() throws SQLException, ClassNotFoundException {
        this.loginSignupHandle = new LoginSignupHandle();
        this.accountHandle = new AccountHandle();
        this.transactionHandle = new TransactionHandle();
        this.userDbHandle = new UserDbHandle();
        this.bankHandle = new BankHandle();
    }

    public void handleSignUp(User user) throws SQLException, ClassNotFoundException {
        loginSignupHandle.addNewUser(user);
    }

    public void handleLogin(String usrername, String password, JFrame loginFrame) throws SQLException, ClassNotFoundException {
        loginSignupHandle.handleLogin(usrername, password, loginFrame);
    }

    public List<CheckingAccount> getAccountByUser(User user) throws ClassNotFoundException, SQLException {
        return accountHandle.getCheckingAccounts(user);
    }

    public List<CheckingAccount> getAccountInTransactions(CheckingAccount account) throws SQLException, ClassNotFoundException {
        return transactionHandle.getAccountsInTransactions(account);
    }

    public List<User> getUsersByName(String name) throws SQLException, ClassNotFoundException {
        return userDbHandle.findUserByName(name);
    }

    public Transaction confirmTransaction(String money, CheckingAccount from_acount, Account to_account) throws SQLException, ClassNotFoundException {
        return transactionHandle.CreateTransaction(money, from_acount, to_account);
    }

    public List<Transaction> getTransactionsbyAccount(CheckingAccount account) throws SQLException, ClassNotFoundException {
        return transactionHandle.getTransactionsbyAccount(account);
    }

    public CheckingAccount getAccountById(String id) throws SQLException, ClassNotFoundException {
        return accountHandle.getAccountById(id);
    }
    
    public List<Bank> getAllBanks(){
        return this.bankHandle.getAllBanks();
    }

    public void handleCreateNewAccount(CheckingAccount account) {
        this.accountHandle.saveNewAccount(account);
    }
    
    public void handleDeleteAccount(CheckingAccount account){
        this.accountHandle.deleteAccountbyId(account.getAccountId());
    }

    public void handleUpdateAccount(CheckingAccount account) {
        this.accountHandle.updateAccount(account);
    }
}
