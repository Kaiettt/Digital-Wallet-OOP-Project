/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userUI;

/**
 *
 * @author ANH KIET
 */

import bankingsystem.model.CheckingAccount;
import bankingsystem.model.Loan;
import bankingsystem.model.User;
import bankingsystem.userservice.userController.UserServiceHandle;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class PaymentHandleUI {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> createAndShowGUI());
//    }
    private UserServiceHandle userServiceHandle;
    public PaymentHandleUI() throws SQLException, ClassNotFoundException{
        this.userServiceHandle = new UserServiceHandle();
    }
     void createAndShowGUI(String name,CheckingAccount account,CheckingAccount main_account,User user)  {
        
        
        System.out.println(account.getAccountId());
        JFrame frame = new JFrame("Thanh toán");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0x608BC1)); // Pink background
        headerPanel.setBounds(0, 0, 400, 100);
        headerPanel.setLayout(null);

        JLabel userInitials = new JLabel("NH", SwingConstants.CENTER);
        userInitials.setFont(new Font("SansSerif", Font.BOLD, 16));
        userInitials.setForeground(Color.WHITE);
        userInitials.setBounds(20, 20, 50, 50);
        userInitials.setOpaque(true);
        userInitials.setBackground(new Color(0x007BFF)); // Darker pink
        userInitials.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        userInitials.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(userInitials);

        JLabel userName = new JLabel(name);
        userName.setFont(new Font("SansSerif", Font.BOLD, 14));
        userName.setForeground(Color.WHITE);
        userName.setBounds(80, 20, 300, 25);
        headerPanel.add(userName);

        JLabel userPhone = new JLabel(account.getAccountId());
        userPhone.setFont(new Font("SansSerif", Font.PLAIN, 12));
        userPhone.setForeground(Color.WHITE);
        userPhone.setBounds(80, 45, 300, 20);
        headerPanel.add(userPhone);
        

        
        
        frame.add(headerPanel);

        // Amount Section
        JPanel amountPanel = new JPanel();
        amountPanel.setBounds(20, 120, 360, 80);
        amountPanel.setLayout(null);
        amountPanel.setBorder(BorderFactory.createLineBorder(new Color(224, 224, 224), 2));

        // Replace JLabel with JTextField for input
        JTextField amountField = new JTextField("");
        amountField.setFont(new Font("SansSerif", Font.BOLD, 30));
        amountField.setForeground(Color.BLACK);
        amountField.setHorizontalAlignment(SwingConstants.CENTER);
        amountField.setBounds(20, 10, 320, 40);
        amountField.setBorder(BorderFactory.createEmptyBorder()); // Remove border for a clean look
        amountPanel.add(amountField);


        JButton clearButton = new JButton("x");
        clearButton.setBounds(310, 10, 30, 30);
        clearButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        clearButton.setBackground(new Color(224, 224, 224));
        clearButton.setFocusPainted(false);
        amountPanel.add(clearButton);

        frame.add(amountPanel);

        // Message Section
        JPanel messagePanel = new JPanel();
        messagePanel.setBounds(20, 220, 360, 150);
        messagePanel.setLayout(null);
        messagePanel.setBorder(BorderFactory.createLineBorder(new Color(224, 224, 224), 2));

        JTextField messageField = new JTextField("Nhập hoặc chọn bên dưới");
        messageField.setBounds(10, 10, 260, 40);
        messageField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        messageField.setForeground(Color.GRAY);
        messagePanel.add(messageField);

        JButton giftButton = new JButton("Chọn");
        giftButton.setBounds(280, 10, 70, 40);
        giftButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
        giftButton.setBackground(new Color(0x608BC1));
        giftButton.setForeground(Color.white);
        giftButton.setFocusPainted(false);
        messagePanel.add(giftButton);

        JPanel categoriesPanel = new JPanel();
        categoriesPanel.setBounds(10, 60, 340, 80);
        categoriesPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

        String[] categories = {"Tiền ăn uống", "Tiền chợ/siêu thị", "Tiền cho gia đình", "Trả tiền hàng", "Khác"};
        for (String category : categories) {
            JButton categoryButton = new JButton(category);
            categoryButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
            categoryButton.setBackground(new Color(224, 224, 224));
            categoryButton.setFocusPainted(false);
            // Add ActionListener for click action
            categoryButton.addActionListener(e -> {
                messageField.setText(categoryButton.getText());

                // You can replace the above code with your own action, like updating a label or field.
            });
            categoriesPanel.add(categoryButton);
        }

        messagePanel.add(categoriesPanel);

        frame.add(messagePanel);

        JButton transferButton = new JButton("Chuyển tiền");
        transferButton.setBounds(20, 400, 360, 50);
        transferButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        transferButton.setBackground(new Color(0x608BC1));
        transferButton.setForeground(Color.WHITE);
        transferButton.setFocusPainted(false);
        transferButton.setBorder(BorderFactory.createEmptyBorder());
        transferButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add MouseListener to handle hover and click effects
        transferButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // On hover: Change background color (hover effect)
                transferButton.setBackground(new Color(0x4A74C2)); // Lighter shade of blue for hover effect
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // On exit: Revert to original background color
                transferButton.setBackground(new Color(0x608BC1)); // Original color
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                // On click (when pressed): Change background color (click effect)
                transferButton.setBackground(new Color(0x3B5A9E)); // Darker shade of blue for click effect
                
                try {
                    try {
                        double amount = Double.parseDouble(amountField.getText());
                        if (amount > main_account.getBalance()) {
                        int option = JOptionPane.showConfirmDialog(
                            null,
                            "Số dư không đủ, bạn có muốn mượn tiền không?",
                            "Transaction Error",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.ERROR_MESSAGE
                        );

                        if (option == JOptionPane.YES_OPTION) {
                            // Handle loan logic
                            handleLoan(amount - main_account.getBalance(), main_account);

                            // Update account balance
                            main_account.setBalance(amount);
                        }
                        // No need to explicitly wait as the code proceeds after the dialog closes
                    }

                    // Proceed with the remaining code after the dialog
                    frame.dispose();
                    PaymentUI UI = new PaymentUI(amountField.getText(), main_account, account, name, user);
                            
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, 
                            "Invalid amount entered. Please enter a valid number.", 
                            "Input Error", 
                            JOptionPane.WARNING_MESSAGE);
                        return; // Exit the method
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(PaymentHandleUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PaymentHandleUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                // After click release: Revert to hover color or normal color
                transferButton.setBackground(new Color(0x4A74C2)); // Reverts to hover color
            }
        });
        frame.add(transferButton);
        
        
        JButton backbtn = new JButton("Hủy");
        backbtn.setBounds(20, 460, 360, 50);
        backbtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        backbtn.setBackground(new Color(0x608BC1));
        backbtn.setForeground(Color.WHITE);
        backbtn.setFocusPainted(false);
        backbtn.setBorder(BorderFactory.createEmptyBorder());
        backbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // On hover: Change background color (hover effect)
                backbtn.setBackground(new Color(0x4A74C2)); // Lighter shade of blue for hover effect
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // On exit: Revert to original background color
                backbtn.setBackground(new Color(0x608BC1)); // Original color
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                // On click (when pressed): Change background color (click effect)
                backbtn.setBackground(new Color(0x3B5A9E)); // Darker shade of blue for click effect
                frame.dispose();
                try {
                    Payment ui = new Payment(user,main_account);
                } catch (SQLException ex) {
                    Logger.getLogger(PaymentHandleUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PaymentHandleUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                // After click release: Revert to hover color or normal color
                backbtn.setBackground(new Color(0x4A74C2)); // Reverts to hover color
            }
        });
        frame.add(backbtn);
        frame.setVisible(true);
    }
    public void handleLoan(double money,CheckingAccount account){
        this.userServiceHandle.createNewLoan(money, account);
    }
}

