/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userController;

import bankingsystem.adminservice.bank.main.Main;
import bankingsystem.database.userDB.DBConnection;
import bankingsystem.model.Role;
import bankingsystem.model.User;
import bankingsystem.userservice.userUI.ChooseAccountUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ANH KIET
 */
public class LoginSignupHandle {
    public static void addNewUser(User user) throws SQLException, ClassNotFoundException {
    Connection conn = DBConnection.getConnection();
    String sql = "INSERT INTO users (name, email, phone_number, address, password, role_id) VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getPhoneNumber());
        pstmt.setString(4, user.getAddress());
        pstmt.setString(5, user.getPassword());
        pstmt.setInt(6, 2);

        int rowAffected = pstmt.executeUpdate();
        if (rowAffected > 0) {
            System.out.println("A new user was inserted successfully.");
        } else {
            System.out.println("Insertion failed.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}   
    
    
    
    public User loadUserByUsernameAndPassword(String email, String password,Connection conn) throws ClassNotFoundException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;

        String sql = "SELECT u.id,u.name, u.email, u.phone_number, u.address, u.password, u.role_id, r.name AS role_name "
           + "FROM users u "
           + "JOIN roles r ON u.role_id = r.id "
           + "WHERE u.email = ? AND u.password = ?";

        try {

            // Prepare the SQL statement
            pstmt = conn.prepareStatement(sql);

            // Set the parameters using the provided email and password
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            // Execute the query
            rs = pstmt.executeQuery();

            // Check if the result set contains any data (i.e., a matching user)
            if (rs.next()) {
                    Role role = new Role(rs.getInt("role_id"), rs.getString("role_name"));
                // Create a new User object from the result set
                user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("address"),
                    rs.getString("password"),
                    role
                );
            } else {
                System.out.println("No user found with the provided email and password.");
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
        System.out.println(user.getName() + user.getEmail());
        return user;
    } 
    
    public void handleLogin(String username,String password,JFrame loginFrame) throws SQLException, ClassNotFoundException{
        Connection conn = DBConnection.getConnection();
         
        User user = loadUserByUsernameAndPassword(username,password,conn);
        if(user != null){
             
             System.out.println(user.getId() + user.getRole().getName());
            if(user.getRole().getName().equals("USER")){

                ChooseAccountUI frame = new ChooseAccountUI(user);
                frame.setLocationRelativeTo(null); // Center the window
            }
            else {
                Main adminUi = new Main();
            }
            loginFrame.dispose();
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Người dùng không tồn tại", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

}
