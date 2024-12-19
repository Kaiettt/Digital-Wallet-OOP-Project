/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userUI;

/**
 *
 * @author ANH KIET
 */import bankingsystem.model.Bank;
import bankingsystem.model.CheckingAccount;
import bankingsystem.model.User;
import bankingsystem.userservice.userController.UserServiceHandle;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChooseAccountUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private User user;
    private UserServiceHandle userService;

    public ChooseAccountUI(User user) throws SQLException, ClassNotFoundException {
        this.userService = new UserServiceHandle();
        this.user = user;

        // Frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 600);
        setLocationRelativeTo(null); // Center the window

        // Content pane setup
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Create a scrollable panel for account sections
        JPanel accountContainer = new JPanel();
        accountContainer.setLayout(null); // Absolute layout for account sections
        accountContainer.setBackground(new Color(0xFFF6E3));
        
        List<Bank> bankList = userService.getAllBanks();
        // Load accounts and add them to the container
        int y = 20; // Vertical position for account sections
        List<CheckingAccount> accounts = userService.getAccountByUser(user);
        for (CheckingAccount account : accounts) {
            addAccountSection(accountContainer, 20, y, account.getAccountId(), account,
                "C:\\Users\\ANH KIET\\Downloads\\profile (1).png",bankList);
            y += 170;
        }

        // Set preferred size for accountContainer
        accountContainer.setPreferredSize(new Dimension(400, y));

        // Add accountContainer to a scroll pane
        JScrollPane scrollPane = new JScrollPane(accountContainer);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Create new account button
        JButton btnCreateNewAccount = new JButton("Create new account");
        btnCreateNewAccount.setBounds(125, 20, 200, 40);
        btnCreateNewAccount.setBackground(new Color(96, 139, 193));
        btnCreateNewAccount.setForeground(Color.WHITE);
        btnCreateNewAccount.addActionListener(e -> {
            
            try {
                new CreateAccountUI(bankList, user, this);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ChooseAccountUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        contentPane.add(btnCreateNewAccount, BorderLayout.SOUTH);

        // Make the frame visible
        this.setVisible(true);
    }

    private void addAccountSection(JPanel container, int x, int y, String id, CheckingAccount account, String profileImagePath,List<Bank> bankList) {
        JLabel lblProfile = new JLabel();
        lblProfile.setIcon(new ImageIcon(profileImagePath));
        lblProfile.setBounds(x, y, 120, 120);
        container.add(lblProfile);

        JLabel lblEmail = new JLabel(id);
        lblEmail.setBounds(x + 130, y, 229, 41);
        lblEmail.setForeground(new Color(0x003161));
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
        container.add(lblEmail);

        // SELECT button
        JButton btnSelect = new JButton("Chọn");
        btnSelect.setBounds(x + 130, y + 39, 75, 48);
        btnSelect.setBackground(new Color(0x608BC1));
        btnSelect.setForeground(Color.WHITE);
        btnSelect.addActionListener(e -> {
            this.dispose();
            try {
                new UserMainUI(this.user, account);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ChooseAccountUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        container.add(btnSelect);

        // UPDATE button
        JButton btnUpdate = new JButton("Cập");
        btnUpdate.setBounds(x + 215, y + 39, 75, 48);
        btnUpdate.setBackground(new Color(0xFFE31A));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.addActionListener(e -> System.out.println("UPDATE button clicked"));
        btnUpdate.addActionListener(e -> {
            try {
                new UpdateAccount(bankList, user, this, account);
            } catch (SQLException ex) {
                Logger.getLogger(ChooseAccountUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChooseAccountUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        container.add(btnUpdate);

        // DELETE button
        JButton btnDelete = new JButton("Xóa");
        btnDelete.setBounds(x + 301, y + 39, 75, 48);
        btnDelete.setBackground(new Color(0xB03052));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.addActionListener(e -> {
            this.userService.handleDeleteAccount(account);
            this.dispose();
            try {
                new ChooseAccountUI(this.user);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ChooseAccountUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        container.add(btnDelete);
    }
}
