package bankingsystem.userservice.userUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ANH KIET
 */
import bankingsystem.model.CheckingAccount;
import bankingsystem.model.Transaction;
import bankingsystem.model.User;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MomoTransactionUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private User user;
    private CheckingAccount main_account;
    private List<Transaction> transactionsHistory;
    private List<JButton> displayOptionList;
    private List<JPanel> transactionPannelsList;
    private TransactionPanel transactionPanel;

    public MomoTransactionUI(List<Transaction> transactionsHistory, User user, CheckingAccount main_account) {
        this.user = user;
        this.transactionPanel = new TransactionPanel();
        this.displayOptionList = new ArrayList<>();
        this.transactionPannelsList = new ArrayList<>();
        this.main_account = main_account;
        this.transactionsHistory = transactionsHistory;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 600);
        setLocationRelativeTo(null); // Center the frame on the screen
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        addHeaderSection();
        addMainPanel();
        addNavigationBar();
        this.setVisible(true);
    }

    /**
     * Adds the header section with account details and buttons.
     */
    private void addHeaderSection() {
        // Title Label
        JLabel titleLabel = new JLabel("Transactions");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(65, 20, 200, 30);
        contentPane.add(titleLabel);

        // Card Panel
        JPanel cardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 123, 255), getWidth(), getHeight(),
                        new Color(102, 178, 255));
                g2d.setPaint(gradient);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        cardPanel.setLayout(null);
        cardPanel.setBounds(20, 70, 310, 100);
        cardPanel.setOpaque(false);
        contentPane.add(cardPanel);

        // Account Details
        JLabel nameLabel = new JLabel(user.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(20, 10, 250, 20);
        cardPanel.add(nameLabel);
        // Account Details
        JLabel accountNumberLabel = new JLabel("Số tài khoản: " + main_account.getAccountId());
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        accountNumberLabel.setForeground(Color.WHITE);
        accountNumberLabel.setBounds(20, 30, 250, 20);
        cardPanel.add(accountNumberLabel);

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")); // Vietnamese locale
        String formattedBalance = currencyFormatter.format(main_account.getBalance());
        JLabel balanceLabel = new JLabel("Số dư: " + formattedBalance);
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setBounds(20, 50, 250, 20);
        cardPanel.add(balanceLabel);

        // Buttons
        JButton historyButton = createStyledButton("Lịch sử giao dịch");
        historyButton.setBounds(20, 70, 120, 20);
        cardPanel.add(historyButton);

        JButton accountButton = createStyledButton("Tài khoản & Thẻ");
        accountButton.setBounds(160, 70, 120, 20);
        cardPanel.add(accountButton);

        JButton btnGift4 = createIconButton("", "🔔", new Color(0x1F509A), "asd");
        int buttonWidth = 50;
        int buttonHeight = 50;
        int frameWidth = 350;
        btnGift4.setBounds(frameWidth - buttonWidth - 30, 10, buttonWidth, buttonHeight); // 10px padding from top-right
        contentPane.add(btnGift4);

        JButton btnLogout = createIconButton("", "↩️", new Color(0x1F509A), "asd");
        btnLogout.setBounds(10, 10, 50, 50);// 10px padding from top-right
        btnLogout.addActionListener(e -> {
            this.dispose();
            try {
                UserMainUI usermain = new UserMainUI(user, main_account);
            } catch (SQLException ex) {
                Logger.getLogger(MomoTransactionUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MomoTransactionUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        contentPane.add(btnLogout);
        // Back Panel
        JLabel backHead = new JLabel("");
        backHead.setBackground(new Color(0x1F509A));
        backHead.setOpaque(true);
        backHead.setBounds(0, 0, 400, 120);
        contentPane.add(backHead);
    }

    private JButton createIconButton(String text, String emoji, Color backgroundColor, String Circle) {
        // Create button content with HTML for alignment and emoji
        String buttonContent = "<html><div style='text-align: center;'>"
                + "<span style='font-size: 16px;'>" + emoji + "</span><br>"
                + "<span style='font-size: 4px;'>" + text + "</span></div></html>";

        CircularButton button = new CircularButton(buttonContent, backgroundColor);
        button.setFont(new Font("Arial", Font.BOLD, 10)); // Adjust font size for text and emoji
        button.setForeground(Color.WHITE); // Set text color
        return button;
    }

    /**
     * Adds the main content panel with user cards.
     */
    private void addMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#F5F5F5"));
        mainPanel.setBounds(0, 130, 350, 390); // Positioned below the header
        contentPane.add(mainPanel);
// Create a panel to hold the buttons
        // Create a button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(20, 60, 300, 40); // Adjusted width to fit the frame
        buttonPanel.setBackground(Color.WHITE); // Background color
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true)); // Rounded border

        // Button dimensions
        int panelWidth = 300;     // Width of the panel
        int buttonHeight = 24;    // Height of each button
        int buttonCount = 4;      // Number of buttons
        int buttonSpacing = 4;    // Spacing between buttons
        int buttonWidth = (panelWidth - (buttonCount + 1) * buttonSpacing) / buttonCount; // Calculate button width

        // Define button colors
        Color buttonBackground = new Color(240, 240, 240); // Light gray
        Color buttonForeground = Color.BLACK;             // Black text
        Color hoverBackground = new Color(200, 200, 255); // Light blue for hover

        ActionListener buttonAction = e -> {
            JButton source = (JButton) e.getSource();
            handleWhenClickDisplayOption(source);
        };

        // Create the "Hôm qua" button
        JButton btnHomQua = new JButton("Hôm qua");
        btnHomQua.setBounds(buttonSpacing, 8, buttonWidth, buttonHeight); // Positioned with spacing
        styleButton(btnHomQua, buttonBackground, buttonForeground, hoverBackground); // Apply custom styles
        displayOptionList.add(btnHomQua);
        btnHomQua.addActionListener(buttonAction); // Add action listener
        buttonPanel.add(btnHomQua);

        // Create the "Tuần này" button
        JButton btnTuanNay = new JButton("Tuần này");
        btnTuanNay.setBounds(buttonSpacing * 2 + buttonWidth, 8, buttonWidth, buttonHeight); // Positioned next to "Hôm qua"
        styleButton(btnTuanNay, buttonBackground, buttonForeground, hoverBackground); // Apply custom styles
        displayOptionList.add(btnTuanNay);
        btnTuanNay.addActionListener(buttonAction);
        buttonPanel.add(btnTuanNay);

        // Create the "Tháng này" button
        JButton btnThangNay = new JButton("Tháng này");
        btnThangNay.setBounds(buttonSpacing * 3 + 2 * buttonWidth, 8, buttonWidth, buttonHeight); // Positioned next to "Tuần này"
        styleButton(btnThangNay, buttonBackground, buttonForeground, hoverBackground); // Apply custom styles
        displayOptionList.add(btnThangNay);
        btnThangNay.addActionListener(buttonAction);
        buttonPanel.add(btnThangNay);

        // Create the "All" button
        JButton btnAll = new JButton("All");
        btnAll.setBounds(buttonSpacing * 4 + 3 * buttonWidth, 8, buttonWidth, buttonHeight); // Correctly positioned next to "Tháng này"
        styleButton(btnAll, new Color(173, 216, 230), buttonForeground, hoverBackground); // Apply custom styles
        displayOptionList.add(btnAll);
        btnAll.addActionListener(buttonAction);
        buttonPanel.add(btnAll);

        // Add the button panel to the main panel
        mainPanel.add(buttonPanel);

        JLabel recommendationLabel = new JLabel("Recent transactions");
        recommendationLabel.setForeground(new Color(0, 64, 128));
        recommendationLabel.setFont(new Font("TahAoma", Font.BOLD, 13));
        recommendationLabel.setBounds(45, 100, 150, 30); // Positioned at the top center
        mainPanel.add(recommendationLabel);

        // In your main UI code
        this.transactionPanel = new TransactionPanel();
        // Set the bounds for the transaction panel section
        this.transactionPanel.setBoundsAndResize(48, 130, 250, 300); // Adjust these values as needed
        mainPanel.add(this.transactionPanel);

        for (Transaction transaction : this.transactionsHistory) {
            transactionPanel.addNewTransaction(transaction, this.main_account, this, this.transactionPannelsList);
        }

    }

    // Method to style a button
    void styleButton(JButton button, Color buttonBackground, Color buttonForeground, Color hoverBackground) {
        button.setFont(new Font("SansSerif", Font.BOLD, 10)); // Adjust font size for compact buttons
        button.setBackground(buttonBackground);
        button.setForeground(buttonForeground);
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Subtle border

    }

    /**
     * Adds the navigation bar at the bottom of the frame.
     */
    private void addNavigationBar() {
        NavigationBar bottomNavBar = new NavigationBar("History");

        int navbarHeight = 50;
        bottomNavBar.setBounds(0, getHeight() - navbarHeight - 30, getWidth(), navbarHeight);
        contentPane.add(bottomNavBar);

        // Adjust position on resize
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                bottomNavBar.setBounds(0, getHeight() - navbarHeight - 30, getWidth(), navbarHeight);
            }
        });
    }

    /**
     * Creates a styled user card with an emoji and name.
     */
    private JPanel createUserCard(String emoji, String name) {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        card.setLayout(null);
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel avatar = new JLabel(emoji, SwingConstants.CENTER);
        avatar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 36));
        avatar.setBounds(0, 10, 80, 50);
        card.add(avatar);

        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nameLabel.setForeground(Color.decode("#4A4A4A"));
        nameLabel.setBounds(0, 60, 80, 20);
        card.add(nameLabel);

        return card;
    }

    /**
     * Creates a styled button.
     */
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(255, 255, 255, 200));
        button.setForeground(new Color(0, 123, 255));
        button.setBorder(BorderFactory.createLineBorder(new Color(34, 153, 84), 1));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    public void handleWhenClickDisplayOption(JButton button) {
        for (JButton jButton : this.displayOptionList) {
            jButton.setBackground(new Color(240, 240, 240));
        }
        button.setBackground(new Color(173, 216, 230));
        button.setOpaque(true);
        filterTransactionByOption(button);
    }

    public void filterTransactionByOption(JButton buttonClicked) {
        this.transactionPanel.removeAllTransactions();

        // Clear the list to avoid memory leaks or duplicates
        this.transactionPannelsList.clear();

        // Get filtered list of transactions
        String source = buttonClicked.getText();
        List<Transaction> filterList = getFilterList(source);

        // Add new transaction panels
        for (Transaction transaction : filterList) {
            this.transactionPanel.addNewTransaction(transaction, this.main_account, this, this.transactionPannelsList);
        }

        // Refresh the UI
        transactionPanel.revalidate();
        transactionPanel.repaint();
    }

    public List<Transaction> getFilterList(String source) {
        List<Transaction> filterList = new ArrayList<>();

        if (source.equals("All")) {
            return this.transactionsHistory;
        }

        Calendar now = Calendar.getInstance(); // Current date and time

        // Handling "Yesterday"
        if (source.equals("Hôm qua")) {
            now.set(Calendar.HOUR_OF_DAY, 0);
            now.set(Calendar.MINUTE, 0);
            now.set(Calendar.SECOND, 0);
            now.set(Calendar.MILLISECOND, 0);
            long startOfToday = now.getTimeInMillis();
            long startOfYesterday = startOfToday - (24 * 60 * 60 * 1000);

            // Filter transactions from yesterday
            for (Transaction transaction : this.transactionsHistory) {
                Timestamp transactionTime = transaction.getTime();
                if (transactionTime.getTime() >= startOfYesterday && transactionTime.getTime() < startOfToday) {
                    filterList.add(transaction);
                }
            }
        } // Handling "This Month"
        else if (source.equals("Tháng này")) {
            now.set(Calendar.DAY_OF_MONTH, 1);
            now.set(Calendar.HOUR_OF_DAY, 0);
            now.set(Calendar.MINUTE, 0);
            now.set(Calendar.SECOND, 0);
            now.set(Calendar.MILLISECOND, 0);
            long startOfMonth = now.getTimeInMillis();

            // Filter transactions from this month
            for (Transaction transaction : this.transactionsHistory) {
                Timestamp transactionTime = transaction.getTime();
                if (transactionTime.getTime() >= startOfMonth) {
                    filterList.add(transaction);
                }
            }
        } // Handling "This Week"
        else if (source.equals("Tuần này")) {
            now.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // Assuming the week starts on Monday
            now.set(Calendar.HOUR_OF_DAY, 0);
            now.set(Calendar.MINUTE, 0);
            now.set(Calendar.SECOND, 0);
            now.set(Calendar.MILLISECOND, 0);
            long startOfWeek = now.getTimeInMillis();

            // Filter transactions from this week
            for (Transaction transaction : this.transactionsHistory) {
                Timestamp transactionTime = transaction.getTime();
                if (transactionTime.getTime() >= startOfWeek) {
                    filterList.add(transaction);
                }
            }
        }

        // Return filtered list
        return filterList;
    }

}
