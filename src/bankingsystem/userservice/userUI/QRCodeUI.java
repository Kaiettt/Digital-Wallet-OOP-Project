package bankingsystem.userservice.userUI;

import bankingsystem.model.CheckingAccount;
import bankingsystem.model.User;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class QRCodeUI {

    public QRCodeUI(User main_user,CheckingAccount account) {
        // Frame setup
        JFrame frame = new JFrame("QR CODE");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        // Header Label
        JLabel headerLabel = new JLabel("Gửi hoặc tải xuống mã QR", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setBounds(50, 10, 300, 30);
        frame.add(headerLabel);

        // User Information
        JLabel userLabel = new JLabel(main_user.getName(), SwingConstants.CENTER);
        userLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userLabel.setBounds(50, 50, 300, 30);
        frame.add(userLabel);

        JLabel idLabel = new JLabel(account.getAccountId(), SwingConstants.CENTER);
        idLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        idLabel.setBounds(50, 80, 300, 30);
        frame.add(idLabel);

        // QR Code Container
        JPanel qrPanel = new JPanel();
        qrPanel.setLayout(new BorderLayout());
        qrPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        qrPanel.setBounds(75, 130, 250, 250);

        // QR Code Image (Placeholder)
        ImageIcon qrIcon = new ImageIcon("D:/oopproject/BankSystem/src/Screenshot 2024-12-15 141255.png"); // Replace with your image file
        JLabel qrLabel = new JLabel(qrIcon, SwingConstants.CENTER);
        qrPanel.add(qrLabel, BorderLayout.CENTER);
        frame.add(qrPanel);

        // Notes under QR Code
        JLabel noteLabel = new JLabel("<html>Nhận tiền từ mọi <b>Ngân hàng</b> và Ví điện tử</html>", SwingConstants.CENTER);
        noteLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        noteLabel.setBounds(50, 400, 300, 30);
        frame.add(noteLabel);


        
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
                try {
                    // On click (when pressed): Change background color (click effect)
                    UserMainUI userMainUI = new UserMainUI(main_user,account);
                } catch (SQLException ex) {
                    Logger.getLogger(QRCodeUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(QRCodeUI.class.getName()).log(Level.SEVERE, null, ex);
                }
              frame.dispose();
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                // After click release: Revert to hover color or normal color
                backbtn.setBackground(new Color(0x4A74C2)); // Reverts to hover color
            }
        });
        frame.add(backbtn);
        // Display the frame
        frame.setVisible(true);
    }


}
