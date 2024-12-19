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
            frame.setSize(450, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null); // Centers the frame on the screen

            // Main panel with gradient background
            JPanel mainPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    // Gradient background
                    GradientPaint gradient = new GradientPaint(
                            0, 0, new Color(58, 123, 213),
                            0, getHeight(), new Color(0, 210, 255));
                    g2d.setPaint(gradient);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            mainPanel.setLayout(null);

            // Title label
            JLabel titleLabel = new JLabel("Welcome to VKK Wallet");
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setBounds(100, 101, 250, 30);
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mainPanel.add(titleLabel);

            // Panel for form content (with rounded corners and white background)
            JPanel formPanel = new JPanel();
            formPanel.setBounds(50, 151, 350, 280);
            formPanel.setBackground(Color.WHITE);
            formPanel.setLayout(null);
            formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

            // Username label and field with emoji
            JLabel userLabel = new JLabel("Username");
            userLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            userLabel.setBounds(60, 20, 100, 30);
            formPanel.add(userLabel);

            JLabel userIcon = new JLabel("👤");
            userIcon.setFont(new Font("SansSerif", Font.PLAIN, 24));
            userIcon.setBounds(20, 50, 40, 40);
            formPanel.add(userIcon);

            JTextField userField = new JTextField();
            userField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            userField.setBounds(60, 50, 250, 40);
            userField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            userField.setBackground(new Color(240, 240, 240));
            formPanel.add(userField);
            // Password label and field with emoji
            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            passwordLabel.setBounds(60, 100, 100, 30);
            formPanel.add(passwordLabel);

            JLabel passwordIcon = new JLabel("🔒");
            passwordIcon.setFont(new Font("SansSerif", Font.PLAIN, 24));
            passwordIcon.setBounds(20, 130, 40, 40);
            formPanel.add(passwordIcon);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            passwordField.setBounds(60, 130, 250, 40);
            passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            passwordField.setBackground(new Color(240, 240, 240));
            formPanel.add(passwordField);

            // Login button
            JButton loginButton = new JButton("Login");
            loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
            loginButton.setForeground(Color.WHITE);
            loginButton.setBounds(20, 190, 310, 45);
            loginButton.setFocusPainted(false);
            loginButton.setBorder(BorderFactory.createEmptyBorder());
            loginButton.setBackground(new Color(0, 153, 204));
            loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    loginButton.setBackground(new Color(0, 180, 240));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    loginButton.setBackground(new Color(0, 153, 204));
                }

                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    String userName = userField.getText();
                    String passWord = new String(passwordField.getPassword());
                    try {
                        userServiceHandle.handleLogin(userName, passWord, frame);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            formPanel.add(loginButton);

            // Register link
            JLabel registerLabel = new JLabel("Don’t have an account? Register here.");
            registerLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            registerLabel.setForeground(new Color(58, 123, 213));
            registerLabel.setBounds(0, 250, formPanel.getWidth(), 30);
            registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Add a MouseListener for click action
            registerLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        SignUpUI test = new SignUpUI();
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame.dispose();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    registerLabel.setForeground(new Color(100, 149, 237)); // Change color on hover
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    registerLabel.setForeground(new Color(58, 123, 213)); // Reset color on exit
                }
            });
            formPanel.add(registerLabel);

            // Add formPanel to mainPanel
            mainPanel.add(formPanel);

            // Add mainPanel to frame
            frame.getContentPane().add(mainPanel);
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new LoginUI();
    }
}
