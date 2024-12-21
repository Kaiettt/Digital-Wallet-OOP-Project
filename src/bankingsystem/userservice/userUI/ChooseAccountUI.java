package bankingsystem.userservice.userUI;

import bankingsystem.model.Bank;
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
        int verticalOffset = 20; // Vertical position for account sections
        List<CheckingAccount> accounts = userService.getAccountByUser(user);
        for (CheckingAccount account : accounts) {
            addAccountSection(accountContainer, 20, verticalOffset, account.getAccountId(), account, 
                "C:\\Users\\ANH KIET\\Downloads\\profile (1).png", bankList);
            verticalOffset += 170;
        }

        // Set preferred size for accountContainer
        accountContainer.setPreferredSize(new Dimension(400, verticalOffset));

        // Add accountContainer to a scroll pane
        JScrollPane scrollPane = new JScrollPane(accountContainer);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Create new account button
        JButton btnCreateNewAccount = createNewAccountButton(bankList);
        contentPane.add(btnCreateNewAccount, BorderLayout.SOUTH);

        // Make the frame visible
        this.setVisible(true);
    }

    private JButton createNewAccountButton(List<Bank> bankList) {
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
        return btnCreateNewAccount;
    }

    private void addAccountSection(JPanel container, int x, int y, String accountId, CheckingAccount account, 
                                   String profileImagePath, List<Bank> bankList) {
        JLabel lblProfile = createProfileLabel(profileImagePath, x, y);
        container.add(lblProfile);

        JLabel lblAccountId = createAccountIdLabel(accountId, x, y);
        container.add(lblAccountId);

        JButton btnSelect = createSelectButton(x, y, account);
        container.add(btnSelect);

        JButton btnUpdate = createUpdateButton(x, y, account, bankList);
        container.add(btnUpdate);

        JButton btnDelete = createDeleteButton(x, y, account);
        container.add(btnDelete);
    }

    private JLabel createProfileLabel(String profileImagePath, int x, int y) {
        JLabel lblProfile = new JLabel();
        lblProfile.setIcon(new ImageIcon(profileImagePath));
        lblProfile.setBounds(x, y, 120, 120);
        return lblProfile;
    }

    private JLabel createAccountIdLabel(String accountId, int x, int y) {
        JLabel lblAccountId = new JLabel(accountId);
        lblAccountId.setBounds(x + 130, y, 229, 41);
        lblAccountId.setForeground(new Color(0x003161));
        lblAccountId.setFont(new Font("Tahoma", Font.BOLD, 18));
        return lblAccountId;
    }

    private JButton createSelectButton(int x, int y, CheckingAccount account) {
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
        return btnSelect;
    }

    private JButton createUpdateButton(int x, int y, CheckingAccount account, List<Bank> bankList) {
        JButton btnUpdate = new JButton("Cập");
        btnUpdate.setBounds(x + 215, y + 39, 75, 48);
        btnUpdate.setBackground(new Color(0xFFE31A));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.addActionListener(e -> {
            try {
                new UpdateAccount(bankList, user, this, account);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ChooseAccountUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return btnUpdate;
    }

    private JButton createDeleteButton(int x, int y, CheckingAccount account) {
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
        return btnDelete;
    }
}
