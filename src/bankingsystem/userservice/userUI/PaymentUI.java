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
import bankingsystem.userservice.userController.UserServiceHandle;
import java.awt.*;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class PaymentUI {

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> createAndShowGUI());
//    }
    private UserServiceHandle userServiceHandle;

    public PaymentUI(String money, CheckingAccount from_acount, CheckingAccount to_account, String name, User main_user) throws SQLException, ClassNotFoundException {
        this.userServiceHandle = new UserServiceHandle();
        JFrame frame = new JFrame("Thanh toán an toàn");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0x608BC1)); // Pink background
        headerPanel.setBounds(0, 0, 400, 60);
        headerPanel.setLayout(null);

        JLabel headerLabel = new JLabel("Thanh toán an toàn", SwingConstants.CENTER);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(0, 10, 400, 40);
        headerPanel.add(headerLabel);

        frame.add(headerPanel);

        // Account Panel
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(null);
        accountPanel.setBounds(20, 80, 360, 100);
        accountPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel accountLabel = new JLabel("Tài khoản/Thẻ");
        accountLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        accountLabel.setBounds(10, 10, 150, 20);
        accountPanel.add(accountLabel);

        JButton momoButton = new JButton("Ví VVK");
        momoButton.setBounds(10, 40, 100, 40);
        momoButton.setBackground(new Color(0x608BC1)); // Light pink
        momoButton.setForeground(Color.white);
        momoButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
        momoButton.setFocusPainted(false);
        accountPanel.add(momoButton);

        frame.add(accountPanel);

        // Transaction Details Panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(null);
        detailsPanel.setBounds(20, 200, 360, 200);
        detailsPanel.setBorder(BorderFactory.createTitledBorder("CHI TIẾT GIAO DỊCH"));

        Locale vietnameseLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnameseLocale);
        String formattedAmount = currencyFormatter.format(Double.parseDouble(money));
        JLabel amountLabel = new JLabel("Số tiền: " + formattedAmount);
        amountLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        amountLabel.setBounds(10, 20, 200, 20);
        detailsPanel.add(amountLabel);

        JLabel recipientLabel = new JLabel(name);
        recipientLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        recipientLabel.setBounds(10, 50, 300, 20);
        detailsPanel.add(recipientLabel);

        JLabel feeLabel = new JLabel("Phí giao dịch: Miễn phí");
        feeLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        feeLabel.setBounds(10, 80, 300, 20);
        detailsPanel.add(feeLabel);

        JLabel refLabel = new JLabel("Mã tham chiếu: 72166255586");
        refLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        refLabel.setBounds(10, 110, 300, 20);
        detailsPanel.add(refLabel);

        frame.add(detailsPanel);

        // Confirm Button
        NewButton confirmButton = new NewButton("Xác nhận", new Color(0x007BFF), Color.white);
        confirmButton.setBounds(20, 420, 360, 50);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        confirmButton.addActionListener(e -> {
            try {
                Transaction transaction = userServiceHandle.confirmTransaction(money, from_acount, to_account);
                TransactionDetails transactionUI = new TransactionDetails(name, transaction, to_account, main_user, "Payment", from_acount);

                frame.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(PaymentUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PaymentUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Change the background color when hovered
                confirmButton.setBackground(new Color(0x0056b3)); // Darker blue on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Revert back to original background color when hover ends
                confirmButton.setBackground(new Color(0x007BFF)); // Original blue
            }
        });
        frame.add(confirmButton);

        frame.setVisible(true);
    }
}
