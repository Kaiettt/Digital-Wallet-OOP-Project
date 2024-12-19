/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.database.userDB;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author ANH KIET
 */
public class DBConnection {
      public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DatabaseConnection.initializeDatabaze();
    }
      public static void main(String[] args) throws SQLException, ClassNotFoundException {
          Connection connection = getConnection();
          
    }
}
