package bankingsystem.userservice.userUI;

import bankingsystem.model.CheckingAccount;
import bankingsystem.model.Transaction;
import bankingsystem.model.User;
import bankingsystem.userservice.userController.UserServiceHandle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TransactionDetails {
    // Constructor to initialize the frame and UI components  
    private UserServiceHandle userServiceHandle;
    public TransactionDetails(String name,Transaction transaction,CheckingAccount other_account,User main_user,String type,CheckingAccount main_account ) throws SQLException, ClassNotFoundException {
        this.userServiceHandle = new UserServiceHandle();
        JFrame frame = new JFrame("Chi tiết giao dịch");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Absolute layout
        frame.setLocationRelativeTo(null);
        // Blue Header Panel
        Color headerColor = new Color(0x608BC1);
        JPanel headerPanel = new JPanel(null); // Absolute layout for header
        headerPanel.setBackground(headerColor);
        headerPanel.setBounds(0, 0, 400, 120);

        // Header Title
        JLabel headerLabel = new JLabel("Chi tiết giao dịch");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setBounds(120, 20, 160, 30); // Position and size

        JButton btnLogout  = createIconButton("", "↩️", new Color(0x608BC1),"asd");
        btnLogout.setBounds(10, 10, 50, 50); // 10px padding from top-left
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(".actionPerformed()");
                if(type.equals("Payment")){
                    try {
                        Payment payementUI = new Payment(main_user,main_account);
                        frame.dispose();
                    } catch (SQLException ex) {
                        Logger.getLogger(TransactionDetails.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(TransactionDetails.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(type.equals("Transaction")){
                     List<Transaction> transactionsHistory = new ArrayList<>();
                        try {
                            transactionsHistory = userServiceHandle.getTransactionsbyAccount(main_account);
                        } catch (SQLException ex) {
                            Logger.getLogger(UserMainUI.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(UserMainUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        MomoTransactionUI transactionUI = new MomoTransactionUI(transactionsHistory,main_user,main_account);
                        frame.dispose();
                }
            }
        });
        // Transaction Amount
        // Get the default currency format
        Locale vietnameseLocale = new Locale("vi", "VN");

        // Get currency format for Vietnamese Dong
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnameseLocale);
        // Format the amount as currency
        String formattedAmount = currencyFormatter.format(transaction.getAmount());
        JLabel amountLabel = new JLabel(formattedAmount);
        amountLabel.setForeground(Color.WHITE);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 35));
        amountLabel.setBounds(120, 60, 200, 30); // Position and size

        // Add labels to header panel
        headerPanel.add(btnLogout);
        headerPanel.add(headerLabel);
        headerPanel.add(amountLabel);
        frame.add(headerPanel);

        // Transaction Details Panel
        JPanel detailsPanel = new JPanel(null);
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBounds(0, 120, 400, 300);
        
        
        // Define the desired date format
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        // Format the timestamp
        String formattedDate = formatter.format(transaction.getTime());
        // Add detail rows manually
        addDetailRow(detailsPanel, "Tên: ",name, 20, 10, new Font("Arial", Font.BOLD, 17), Color.BLACK);
        addStatusRow(detailsPanel, "Trạng thái", "Thành công", 20, 60, new Color(0x118B50));
        addDetailRow(detailsPanel, "Thời gian", formattedDate, 20, 110, new Font("Arial", Font.PLAIN, 14), Color.BLACK);
        addDetailRow(detailsPanel, "Mã giao dịch", transaction.getId() + "VKK", 20, 160, new Font("Arial", Font.BOLD, 14), Color.BLACK);
        addDetailRow(detailsPanel, "Tài khoản/thẻ", "Ví Trả Sau", 20, 210, new Font("Arial", Font.PLAIN, 14), Color.BLACK);
        addDetailRow(detailsPanel, "Tổng phí", "Miễn phí", 20, 260, new Font("Arial", Font.PLAIN, 14), Color.BLACK);
        addDetailRow(detailsPanel, "Thành tiền", transaction.getAmount() + "", 20, 310, new Font("Arial", Font.PLAIN, 14), Color.BLACK);

        frame.add(detailsPanel);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(null);
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBounds(0, 400, 400, 300);
        
        JButton chiaTienButton = new JButton("Chia tiền");
        chiaTienButton.setFont(new Font("Arial", Font.BOLD, 16));
        chiaTienButton.setForeground(headerColor);
        chiaTienButton.setBackground(Color.WHITE);
        chiaTienButton.setBorder(BorderFactory.createLineBorder(headerColor, 2));
        chiaTienButton.setFocusPainted(false); // Remove the gray focus line
        chiaTienButton.setBounds(50, 20, 120, 50);

        JButton giaoDichMoiButton = new JButton("Giao dịch mới");
        giaoDichMoiButton.setFont(new Font("Arial", Font.BOLD, 16));
        giaoDichMoiButton.setForeground(Color.WHITE);
        giaoDichMoiButton.setBackground(headerColor);
        giaoDichMoiButton.setBorderPainted(false);
        giaoDichMoiButton.setBounds(200, 20, 150, 50); // Position and size

        buttonPanel.add(chiaTienButton);
        buttonPanel.add(giaoDichMoiButton);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }

    // Method to create the logout button
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

    // Helper method to add detail rows
    private static void addDetailRow(JPanel panel, String key, String value, int x, int y, Font font, Color color) {
        JLabel keyLabel = new JLabel(key);
        keyLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        keyLabel.setBounds(x, y, 150, 20);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(font);
        valueLabel.setForeground(color);
        valueLabel.setBounds(x + 200, y, 200, 20);

        panel.add(keyLabel);
        panel.add(valueLabel);
    }

    // Helper method to add status row
    private static void addStatusRow(JPanel panel, String key, String status, int x, int y, Color statusColor) {
        JLabel keyLabel = new JLabel(key);
        keyLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        keyLabel.setBounds(x, y, 150, 20);

        JLabel statusLabel = new JLabel(status);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        statusLabel.setForeground(statusColor);
        statusLabel.setBounds(x + 200, y, 200, 20);

        panel.add(keyLabel);
        panel.add(statusLabel);
    }
//
//    // Main method to run the constructor and display the UI
//    public static void main(String[] args) {
//        new TransactionDetails();
//    }
}
