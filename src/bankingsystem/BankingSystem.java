/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankingsystem;

import bankingsystem.login.LoginUI;
import java.sql.SQLException;

/**
 *
 * @author ANH KIET
 */
public class BankingSystem {

    /**
     * @param args the command line arguments
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new LoginUI();
    }

}
