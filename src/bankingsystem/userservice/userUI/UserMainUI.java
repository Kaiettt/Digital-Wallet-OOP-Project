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
import bankingsystem.model.SavingAccount;
import bankingsystem.model.Transaction;
import bankingsystem.model.User;
import bankingsystem.userservice.userController.UserServiceHandle;
import bankingsystem.userservice.userUI.featuregroup.InformationAccount;
import bankingsystem.userservice.userUI.featuregroup.ShowSavingGoals;
import bankingsystem.userservice.userUI.featuregroup.Wallet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UserMainUI extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private User user;
    private CheckingAccount account;
    private UserServiceHandle userServiceHandle;
    // Constructor to initialize the user interface components
    public UserMainUI(User user,CheckingAccount account) throws SQLException, ClassNotFoundException {
        userServiceHandle = new UserServiceHandle();
        this.user = user;
        this.account = account;
        // Set the default close operation and frame size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 600); // Set initial position and size
		setLocationRelativeTo(null); // Center the frame on the screen

		// Initialize content pane and set layout
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(247, 246, 246));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
        
        addHeadpart(user,account);
        // Add navigation buttons
        addNavigationButtons();
        
        // Add additional labels for user info
        addUserInfoLabels();
        
        // Add navigation bar at the bottom
        addNavigationBar();
        this.setVisible(true);
    }
    

public void addNavigationButtons() {
    JButton userbtn = createIconButton("User ", "👤", new Color(235, 87, 87));
    userbtn.setBounds(39, 256, 80, 50);  // Increased y value by 20
    userbtn.addActionListener(e -> {
            new InformationAccount(this.user,this.account,this);
            this.dispose();
    });
    contentPane.add(userbtn);

    JButton receivebtn = createIconButton("Receive ", "📥", new Color(47, 128, 237));
    receivebtn.setBounds(123, 256, 80, 50);  // Increased y value by 20
    receivebtn.addActionListener(e -> {
            QRCodeUI qrcodeUI = new QRCodeUI(this.user, this.account);
            this.dispose();
    });
    contentPane.add(receivebtn);

    JButton paymentbtn = createIconButton("Payment ", "💳", new Color(39, 174, 96));
    paymentbtn.setBounds(206, 256, 80, 50);  // Increased y value by 20
    paymentbtn.addActionListener(e -> {
        try {
            Payment renderUI = new Payment(this.user, this.account);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(UserMainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserMainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    contentPane.add(paymentbtn);

    JButton walletbtn = createIconButton("Wallet ", "💰", new Color(235, 87, 87));
    walletbtn.setBounds(39, 319, 80, 50);  // Increased y value by 20
    walletbtn.addActionListener(e -> {
            Loan loan = userServiceHandle.getLoanByAccountId(account);
            if(loan == null){
                loan = new Loan();
                loan.setAmount(0);
            }
            new Wallet(account, loan,this,this.user);
            this.dispose();
    });
    contentPane.add(walletbtn);
    JButton historybtn = createIconButton("History ", "🕰️", new Color(47, 128, 237));
    historybtn.setBounds(123, 319, 80, 50);  // Increased y value by 20
    historybtn.addActionListener(e -> {
            List<Transaction> transactionsHistory = new ArrayList<>();
        try {
            transactionsHistory = userServiceHandle.getTransactionsbyAccount(this.account);
        } catch (SQLException ex) {
            Logger.getLogger(UserMainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserMainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            MomoTransactionUI transactionUI = new MomoTransactionUI(transactionsHistory,this.user,this.account);
            this.dispose();
    });
    contentPane.add(historybtn);

    JButton savingButton = createIconButton("Saving ", "💸", new Color(39, 174, 96));
    savingButton.addActionListener(e -> {
            SavingAccount saving_account = userServiceHandle.getSavingAccountByUser(user);
            new ShowSavingGoals(this, saving_account);
            this.dispose();
    });
    savingButton.setBounds(206, 319, 80, 50);  // Increased y value by 20
    contentPane.add(savingButton);


    
}
    
    private JButton createIconButton(String text, String emoji, Color backgroundColor) {
        // Use proper HTML structure for the button with correct alignment and font size.
        String buttonContent = "<html><div style='text-align: center;'>"
                               + "<span style='font-size: 10px;'>" + emoji + "</span><br>"
                               + "<span style='font-size: 10px;'>" + text + "</span></div></html>";
        
        NewButton button = new NewButton(buttonContent,backgroundColor,Color.white);
        button.setFont(new Font("Arial", Font.BOLD, 10));  // Font for text and emoji           // Set text color
        button.setForeground(Color.WHITE);
        return button;
    }
    private JButton createIconButton(String text, String emoji, Color backgroundColor,String Circle) {
        // Create button content with HTML for alignment and emoji
        String buttonContent = "<html><div style='text-align: center;'>"
                + "<span style='font-size: 16px;'>" + emoji + "</span><br>"
                + "<span style='font-size: 4px;'>" + text + "</span></div></html>";

        CircularButton button = new CircularButton(buttonContent, backgroundColor);
        button.setFont(new Font("Arial", Font.BOLD, 10)); // Adjust font size for text and emoji
        button.setForeground(Color.WHITE); // Set text color
        return button;
    }
    private void addHeadpart(User user,CheckingAccount account) {
        // Card Panel inside gradient
        JPanel cardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                // Blue theme gradient
                GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 123, 255), getWidth(), getHeight(), new Color(102, 178, 255));
                g2d.setPaint(gradient);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Reduced rounding
            }
        };
        
        cardPanel.setLayout(null);
        cardPanel.setBounds(20, 100, 310, 100); // Adjusted size and position
        cardPanel.setOpaque(false);
        contentPane.add(cardPanel);
    
        // Account Holder Name
        JLabel nameLabel = new JLabel(user.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Reduced font size
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(20, 10, 250, 20); // Adjusted position
        cardPanel.add(nameLabel);
    
        // Account Number
        JLabel accountNumberLabel = new JLabel("Số tài khoản: " + account.getAccountId());
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Reduced font size
        accountNumberLabel.setForeground(Color.WHITE);
        accountNumberLabel.setBounds(20, 30, 250, 20); // Adjusted position
        cardPanel.add(accountNumberLabel);
        
        
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")); // Vietnamese locale
        String formattedBalance = currencyFormatter.format(account.getBalance());
        // Account Balance
        JLabel balanceLabel = new JLabel("Số dư: " + formattedBalance);
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Reduced font size
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setBounds(20, 50, 250, 20); // Adjusted position
        cardPanel.add(balanceLabel);
    
        // Transaction History Button
        JButton historyButton = new JButton("Lịch sử giao dịch");
        historyButton.setFont(new Font("Arial", Font.PLAIN, 10)); // Reduced font size
        historyButton.setBounds(20, 70, 120, 20); // Adjusted position and height
        styleButton(historyButton);
        cardPanel.add(historyButton);
    
        // Account & Card Button
        JButton accountButton = new JButton("Tài khoản & Thẻ");
        accountButton.setFont(new Font("Arial", Font.PLAIN, 10)); // Reduced font size
        accountButton.setBounds(160, 70, 120, 20); // Adjusted position and height
        styleButton(accountButton);
        cardPanel.add(accountButton);

        JButton notibtn = createIconButton("", "🔔", new Color(0x1F509A),"asd");
        int buttonWidth = 50;
        int buttonHeight = 50;
        int frameWidth = 350;
        notibtn.setBounds(frameWidth - buttonWidth - 30, 10, buttonWidth, buttonHeight); // 10px padding from top-right
        contentPane.add(notibtn);

        JButton btnLogout  = createIconButton("", "↩️", new Color(0x1F509A),"asd");
        btnLogout.setBounds(10, 10, 50, 50);// 10px padding from top-right
        contentPane.add(btnLogout );


        JLabel back_head = new JLabel("");
        back_head.setBackground(new Color(0x1F509A));
        back_head.setOpaque(true);
        back_head.setBounds(0, 0, 400, 150);
        contentPane.add(back_head);
    }
    
    // Style the buttons in the card section
    private void styleButton(JButton button) {
        button.setFocusPainted(false);
        button.setBackground(new Color(255, 255, 255, 200)); // Transparent white
        button.setForeground(new Color(0, 123, 255));
        button.setBorder(BorderFactory.createLineBorder(new Color(34, 153, 84), 1));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
        
    private void addUserInfoLabels() {
        // Background panel for user information
        JPanel messagePanel = new JPanel();
        messagePanel.setBounds(21, 250, 275, 140);  // Increased y value by 20
        messagePanel.setLayout(null);
        messagePanel.setBorder(BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
        contentPane.add(messagePanel);
    
        // Title: Share money with your friends
        JLabel lblShareMoney = new JLabel("Share money with your friends");
        lblShareMoney.setForeground(new Color(0, 64, 128));
        lblShareMoney.setFont(new Font("TahAoma", Font.PLAIN, 13));
        lblShareMoney.setBounds(30, 220, 290, 28);  // Increased y value by 20
        contentPane.add(lblShareMoney);
    
        // // Labels for owned/owed balances
        // addBalanceLabels();
    } 


    // Add the navigation bar at the bottom
    private void addNavigationBar() {
        NavigationBar bottomNavBar = new NavigationBar("Home");
        int navbarHeight = 70;
        bottomNavBar.setBounds(0, getHeight() - navbarHeight - 30, getWidth(), navbarHeight);
        contentPane.add(bottomNavBar);

        // Adjust navigation bar position dynamically when window is resized
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                bottomNavBar.setBounds(0, getHeight() - navbarHeight - 30, getWidth(), navbarHeight);
            }
        });
    }
}

