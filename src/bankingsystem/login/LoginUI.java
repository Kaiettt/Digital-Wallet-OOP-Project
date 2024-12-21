package bankingsystem.login;

import bankingsystem.userservice.userController.UserServiceHandle;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginUI {

    public LoginUI() throws SQLException, ClassNotFoundException {
        UserServiceHandle userServiceHandle = new UserServiceHandle();
        SwingUtilities.invokeLater(() -> {
            // Create the main frame
            JFrame frame = new JFrame("Banking App - Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);

            // Main panel with gradient background
            JPanel mainPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    GradientPaint gradient = new GradientPaint(
                            0, 0, new Color(34, 193, 195),
                            0, getHeight(), new Color(253, 187, 45)
                    );
                    g2d.setPaint(gradient);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            mainPanel.setLayout(null);

            // Title label
            JLabel titleLabel = new JLabel("Welcome to VKK Wallet");
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setBounds(75, 80, 350, 40);
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mainPanel.add(titleLabel);

            // Subtitle
            JLabel subtitleLabel = new JLabel("Secure Banking Made Simple");
            subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            subtitleLabel.setForeground(Color.WHITE);
            subtitleLabel.setBounds(75, 120, 350, 30);
            subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mainPanel.add(subtitleLabel);

            // Form panel
            JPanel formPanel = new JPanel();
            formPanel.setBounds(75, 180, 350, 350);
            formPanel.setBackground(Color.WHITE);
            formPanel.setLayout(null);
            formPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                    new EmptyBorder(20, 20, 20, 20))
            );

            // Username label and field
            JLabel userLabel = new JLabel("Username");
            userLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            userLabel.setBounds(20, 20, 100, 20);
            formPanel.add(userLabel);

            JTextField userField = new JTextField();
            userField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            userField.setBounds(20, 50, 310, 40);
            userField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            userField.setBackground(new Color(245, 245, 245));
            formPanel.add(userField);

            // Password label and field
            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            passwordLabel.setBounds(20, 110, 100, 20);
            formPanel.add(passwordLabel);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            passwordField.setBounds(20, 140, 310, 40);
            passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            passwordField.setBackground(new Color(245, 245, 245));
            formPanel.add(passwordField);

            // Login button
            JButton loginButton = new JButton("Login");
            loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
            loginButton.setForeground(Color.WHITE);
            loginButton.setBounds(20, 200, 310, 45);
            loginButton.setFocusPainted(false);
            loginButton.setBorder(BorderFactory.createEmptyBorder());
            loginButton.setBackground(new Color(0, 153, 153));
            loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            loginButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    loginButton.setBackground(new Color(0, 180, 180));
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    loginButton.setBackground(new Color(0, 153, 153));
                }

                @Override
                public void mouseClicked(MouseEvent evt) {
                    String userName = userField.getText();
                    String passWord = new String(passwordField.getPassword());
                    try {
                        userServiceHandle.handleLogin(userName, passWord, frame);
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            formPanel.add(loginButton);

            // Register label
            JLabel registerLabel = new JLabel("Don’t have an account? Register here.");
            registerLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            registerLabel.setForeground(new Color(0, 153, 153));
            registerLabel.setBounds(20, 270, 310, 30);
            registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

            registerLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        SignUpUI test = new SignUpUI();
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame.dispose();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    registerLabel.setForeground(new Color(0, 180, 180));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    registerLabel.setForeground(new Color(0, 153, 153));
                }
            });
            formPanel.add(registerLabel);

            mainPanel.add(formPanel);
            frame.getContentPane().add(mainPanel);
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new LoginUI();
    }
}
