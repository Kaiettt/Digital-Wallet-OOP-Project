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
import bankingsystem.model.Transaction;
import bankingsystem.model.User;
import java.awt.*;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TransactionPanel extends JPanel {

    private JPanel transactionsContainer;  // Container for all transactions
    private JScrollPane scrollPane;        // Scroll pane for transactions

    public TransactionPanel() {
        // Set up the main panel (this)
        this.setLayout(null);  // Use null layout to match your existing layout
        this.setBackground(Color.WHITE);

        // Create container for transactions with BoxLayout
        transactionsContainer = new JPanel();
        transactionsContainer.setLayout(new BoxLayout(transactionsContainer, BoxLayout.Y_AXIS));
        transactionsContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Smaller padding
        transactionsContainer.setBackground(Color.WHITE);

        // Create scroll pane for transactions
        scrollPane = new JScrollPane(transactionsContainer);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBackground(Color.WHITE);

        // Add scroll pane to this panel
        this.add(scrollPane);
    }

    public void setBoundsAndResize(int x, int y, int width, int height) {
        // Set bounds for the main panel
        this.setBounds(x, y, width, height);

        // Set bounds for the scroll pane
        scrollPane.setBounds(0, 0, width, height);
    }

    public void addNewTransaction(Transaction transaction, CheckingAccount main_account, JFrame transactionUI, List<JPanel> transactionPanels) {
        JPanel card = createTransactionPanel(transaction, main_account, transactionUI);
        transactionsContainer.add(card);
        transactionPanels.add(card);
        transactionsContainer.add(Box.createRigidArea(new Dimension(0, 10))); // Smaller gap

        // Refresh the panel
        transactionsContainer.revalidate();
        transactionsContainer.repaint();
    }

    public void removeAllTransactions() {
        transactionsContainer.removeAll(); // Remove all components from the container
        transactionsContainer.revalidate(); // Refresh the layout manager
        transactionsContainer.repaint(); // Repaint to reflect the changes visually
    }

    public void GenerateTransactionDetailUI(String name, Transaction transaction, User user, CheckingAccount main_account) throws SQLException, ClassNotFoundException {
        if (transaction.getFromAccount().getAccountId().equals(main_account.getAccountId())) {
            TransactionDetails transactionDetailsUI = new TransactionDetails(name, transaction, (CheckingAccount) transaction.getToAccount(), user, "Transaction", main_account);
        } else {
            TransactionDetails transactionDetailsUI = new TransactionDetails(name, transaction, (CheckingAccount) transaction.getFromAccount(), user, "Transaction", main_account);
        }
    }

    private JPanel createTransactionPanel(Transaction transaction, CheckingAccount main_account, JFrame transactionUI) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(5, 5)); // Reduced gap between components
        mainPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(240, 240, 240), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Reduced padding
        ));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setMaximumSize(new Dimension(300, 70)); // Smaller width and height

        // Add a MouseListener for click events
        mainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    if (transaction.getToAccount().getAccountId().equals(main_account.getAccountId())) {
                        GenerateTransactionDetailUI(transaction.getFromAccount().getUser().getName(), transaction, main_account.getUser(), main_account);
                    } else if (transaction.getFromAccount().getAccountId().equals(main_account.getAccountId())) {
                        GenerateTransactionDetailUI(transaction.getToAccount().getUser().getName(), transaction, main_account.getUser(), main_account);
                    }

                    transactionUI.dispose();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(TransactionPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                mainPanel.setBackground(new Color(245, 245, 245)); // Highlight effect
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                mainPanel.setBackground(Color.WHITE); // Revert to default background
            }
        });

        // Left icon panel
        JPanel iconPanel = new JPanel();
        iconPanel.setPreferredSize(new Dimension(20, 20)); // Smaller icon size
        iconPanel.setBackground(new Color(200, 200, 255));

        JLabel iconLabel = new JLabel("+");
        iconLabel.setForeground(Color.WHITE);
        iconLabel.setFont(new Font("Arial", Font.BOLD, 12)); // Smaller font size
        iconPanel.add(iconLabel);

        mainPanel.add(iconPanel, BorderLayout.WEST);

        // Center content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 1));
        contentPanel.setBackground(Color.WHITE);

        JLabel typeLabel = null;
        if (transaction.getToAccount().getAccountId().equals(main_account.getAccountId())) {
            typeLabel = new JLabel(transaction.getFromAccount().getUser().getName());
            typeLabel.setFont(new Font("Arial", Font.BOLD, 10)); // Smaller font size
        } else if (transaction.getFromAccount().getAccountId().equals(main_account.getAccountId())) {
            typeLabel = new JLabel(transaction.getToAccount().getUser().getName());
            typeLabel.setFont(new Font("Arial", Font.BOLD, 10)); // Smaller font size
        }

        JLabel sourceLabel = new JLabel("");
        sourceLabel.setForeground(Color.GRAY);
        sourceLabel.setFont(new Font("Arial", Font.PLAIN, 8)); // Smaller font size

        JLabel idLabel = new JLabel(transaction.getId() + "VVK");
        idLabel.setForeground(Color.GRAY);
        idLabel.setFont(new Font("Arial", Font.PLAIN, 8)); // Smaller font size

        contentPanel.add(typeLabel);
        contentPanel.add(sourceLabel);
        contentPanel.add(idLabel);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Right panel for amount and date
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(3, 1));
        rightPanel.setBackground(Color.WHITE);

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String formattedBalance = currencyFormatter.format(transaction.getAmount());

        JLabel amountLabel = null;
        if (transaction.getToAccount().getAccountId().equals(main_account.getAccountId())) {
            amountLabel = new JLabel("+ " + formattedBalance);
            amountLabel.setFont(new Font("Arial", Font.BOLD, 10)); // Smaller font size
            amountLabel.setForeground(Color.GREEN);
            amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        } else if (transaction.getFromAccount().getAccountId().equals(main_account.getAccountId())) {
            amountLabel = new JLabel("- " + formattedBalance);
            amountLabel.setFont(new Font("Arial", Font.BOLD, 10)); // Smaller font size
            amountLabel.setForeground(Color.RED);
            amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        }

        JLabel statusLabel = new JLabel("confirmed");
        statusLabel.setForeground(new Color(100, 200, 150));
        statusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 8)); // Smaller font size

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(transaction.getTime());
        JLabel dateLabel = new JLabel(formattedDate);
        dateLabel.setForeground(Color.GRAY);
        dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 8)); // Smaller font size

        rightPanel.add(amountLabel);
        rightPanel.add(statusLabel);
        rightPanel.add(dateLabel);

        mainPanel.add(rightPanel, BorderLayout.EAST);

        return mainPanel;
    }

}
