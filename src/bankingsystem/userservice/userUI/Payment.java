/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userUI;

/**
 *
 * @author ANH KIET
 */
import bankingsystem.model.Account;
import bankingsystem.model.CheckingAccount;
import bankingsystem.model.User;
import bankingsystem.userservice.userController.UserServiceHandle;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Payment extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private List<JPanel> accountList;
    private JPanel mainPanel;
    private JLabel recommendationLabel;
    private UserServiceHandle userService;

    public Payment(User user, CheckingAccount account) throws SQLException, ClassNotFoundException {
        this.userService = new UserServiceHandle();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 600);
        setLocationRelativeTo(null); // Center the frame on the screen
        this.mainPanel = new JPanel();
        this.accountList = new ArrayList<JPanel>();
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        List<CheckingAccount> accountsTransactions = this.userService.getAccountInTransactions(account);
        addHeaderSection(user, account);
        addMainPanel(accountsTransactions, account, user);
        addNavigationBar();
        this.setVisible(true);
    }

    /**
     * Adds the header section with account details and buttons.
     */
    private void addHeaderSection(User user, CheckingAccount account) {
        // Title Label
        JLabel titleLabel = new JLabel("Payment");
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

        JLabel accountNumberLabel = new JLabel("Số tài khoản: " + account.getAccountId());
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        accountNumberLabel.setForeground(Color.WHITE);
        accountNumberLabel.setBounds(20, 30, 250, 20);
        cardPanel.add(accountNumberLabel);

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")); // Vietnamese locale
        String formattedBalance = currencyFormatter.format(account.getBalance());
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
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    handleWhenBackToMainUI(user, account);
                } catch (SQLException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
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

    public void handleWhenBackToMainUI(User user, CheckingAccount account) throws SQLException, ClassNotFoundException {

        UserMainUI mainUi = new UserMainUI(user, account);
        this.dispose();

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
    private void addMainPanel(List<CheckingAccount> accountsTransactions, CheckingAccount main_account, User user) {
        this.mainPanel.setLayout(null);
        this.mainPanel.setBackground(Color.decode("#F5F5F5"));
        this.mainPanel.setBounds(0, 180, 350, 350); // Positioned below the header
        contentPane.add(this.mainPanel);

        // Create a panel to hold the search bar
        JPanel searchBarPanel = new JPanel();
        searchBarPanel.setLayout(null);
        searchBarPanel.setBounds(20, 30, 300, 40); // Adjusted starting Y value for upward position
        searchBarPanel.setBackground(Color.WHITE); // Background color
        searchBarPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true)); // Rounded border

// Add an emoji label for the search icon
        JLabel searchIcon = new JLabel("🔍");
        searchIcon.setFont(new Font("SansSerif", Font.PLAIN, 16));
        searchIcon.setBounds(15, 8, 20, 24); // Position inside the search bar
        searchBarPanel.add(searchIcon);

// Create a text field for input
        JTextField searchField = new JTextField();
        searchField.setBounds(50, 8, 200, 24); // Adjusted width to fit within smaller panel
        searchField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        searchField.setBorder(null); // Remove default border
        searchField.setForeground(Color.GRAY);
        searchField.setText("Search..."); // Placeholder text

        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().trim();
                if (!searchText.isEmpty()) {
                    System.out.println("Search text entered: " + searchText);
                    try {
                        // You can perform any action here, such as triggering a search
                        handleSearchAccount(searchText, mainPanel, accountList, main_account, user);
                    } catch (SQLException ex) {
                        Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("Search field is empty.");
                }
            }
        });
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Search...")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("Search...");
                    searchField.setForeground(Color.GRAY);
                }
            }
        });
        searchBarPanel.add(searchField);
        this.mainPanel.add(searchBarPanel);

        this.recommendationLabel = new JLabel("Giao dịch gần đây");
        this.recommendationLabel.setForeground(new Color(0, 64, 128));
        this.recommendationLabel.setFont(new Font("TahAoma", Font.BOLD, 13));
        this.recommendationLabel.setBounds(40, 70, 150, 30); // Adjusted starting Y value for upward position
        this.mainPanel.add(this.recommendationLabel);

        generateAccountsUI(accountsTransactions, main_account, user);

    }

    public void generateAccountsUI(List<CheckingAccount> accountsTransactions, CheckingAccount main_account, User user) {
        // Adjusted card size and layout parameters
        int cardSize = 80;  // Smaller card size
        int padding = 15;  // Smaller padding between cards
        int cardsPerRow = 3;
        int totalWidth = cardsPerRow * cardSize + (cardsPerRow - 1) * padding;
        int startX = (this.mainPanel.getWidth() - totalWidth) / 2;  // Center the cards horizontally
        int startY = 100; // Adjusted starting Y value for upward position

// Smaller list of recommended receivers
        String[] emojis = {"\uD83D\uDC64", "\uD83D\uDC68", "\uD83D\uDC69", "\uD83D\uDC66", "\uD83D\uDC67", "\uD83D\uDC74", "\uD83D\uDC64", "\uD83D\uDC68"};

        int i = 0;
        for (CheckingAccount account : accountsTransactions) {
            int row = i / cardsPerRow;
            int col = i % cardsPerRow;
            JPanel userCard = createUserCard(emojis[i], account.getUser().getName(), account, main_account, user);
            userCard.setBounds(startX + col * (cardSize + padding), startY + row * (cardSize + padding), cardSize, cardSize);
            this.accountList.add(userCard);
            this.mainPanel.add(userCard);
            i++;
        }
    }

    public void generateSearchResult(List<User> users, CheckingAccount main_acount, User current_user) {
        // Adjusted card size and layout parameters
        int cardSize = 80;  // Smaller card size
        int padding = 15;  // Smaller padding between cards
        int cardsPerRow = 3;
        int totalWidth = cardsPerRow * cardSize + (cardsPerRow - 1) * padding;
        int startX = (this.mainPanel.getWidth() - totalWidth) / 2;  // Center the cards horizontally
        int startY = 100; // Adjusted starting Y value for upward position

// Smaller list of recommended receivers
        String[] emojis = {"\uD83D\uDC64", "\uD83D\uDC68", "\uD83D\uDC69", "\uD83D\uDC66", "\uD83D\uDC67", "\uD83D\uDC74", "\uD83D\uDC64", "\uD83D\uDC68"};

        int i = 0;
        for (User user : users) {
            for (Account account : user.getAccounts()) {
                int row = i / cardsPerRow;
                int col = i % cardsPerRow;

                JPanel userCard = createUserCard(emojis[i], user.getName(), (CheckingAccount) account, main_acount, current_user);
                userCard.setBounds(startX + col * (cardSize + padding), startY + row * (cardSize + padding), cardSize, cardSize);
                this.accountList.add(userCard);
                this.mainPanel.add(userCard);
                i++;
            }

        }
    }

    /**
     * Adds the navigation bar at the bottom of the frame.
     */

    public void handleSearchAccount(String name, JPanel mainPannel, List<JPanel> accountList, CheckingAccount main_account, User current_user) throws SQLException, ClassNotFoundException {
        for (JPanel jPanel : accountList) {
            mainPannel.remove(jPanel);
        }
        this.recommendationLabel.setText("Tìm kiếm tài khoản");
        // Ensure the layout is recalculated and the panel is repainted
        mainPanel.revalidate(); // Recalculate the layout
        mainPanel.repaint();    // Repaint the panel to reflect the changes
        List<User> userList = this.userService.getUsersByName(name);
        generateSearchResult(userList, main_account, current_user);

    }

    private void addNavigationBar() {
        NavigationBar bottomNavBar = new NavigationBar("Payment");

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

    public void handleClick() {
        this.dispose();
    }

    /**
     * Creates a styled user card with an emoji and name.
     */
    private JPanel createUserCard(String emoji, String name, CheckingAccount account, CheckingAccount main_account, User user) {
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

        // Add click action
        card.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                handleClick();
                
                PaymentHandleUI paymentHandleUI;
                try {
                    paymentHandleUI = new PaymentHandleUI();
                    paymentHandleUI.createAndShowGUI(name, account, main_account, user);
                } catch (SQLException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                card.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand
            }
        });

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
}
