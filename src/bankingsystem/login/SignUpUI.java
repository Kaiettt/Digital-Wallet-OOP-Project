package bankingsystem.login;

import bankingsystem.model.User;
import bankingsystem.userservice.userController.UserServiceHandle;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SignUpUI {

    public SignUpUI() throws SQLException, ClassNotFoundException {
        UserServiceHandle userServiceHandle = new UserServiceHandle();
        SwingUtilities.invokeLater(() -> {
            // Create the main frame
            JFrame frame = new JFrame("Banking App - Sign Up");
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
            JLabel titleLabel = new JLabel("Create Your Account");
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setBounds(75, 20, 350, 40);
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mainPanel.add(titleLabel);

            // Form panel
            JPanel formPanel = new JPanel();
            formPanel.setBounds(75, 90, 350, 500); // Moved up by 30
            formPanel.setBackground(Color.WHITE);
            formPanel.setLayout(null);
            formPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                    new EmptyBorder(20, 20, 20, 20))
            );

            // Full Name label and field
            JLabel fullNameLabel = new JLabel("Full Name");
            fullNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            fullNameLabel.setBounds(20, 20, 100, 20);
            formPanel.add(fullNameLabel);

            JTextField fullNameField = new JTextField();
            fullNameField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            fullNameField.setBounds(20, 50, 310, 40);
            fullNameField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            fullNameField.setBackground(new Color(245, 245, 245));
            formPanel.add(fullNameField);

            // Username label and field
            JLabel userLabel = new JLabel("Username");
            userLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            userLabel.setBounds(20, 110, 100, 20);
            formPanel.add(userLabel);

            JTextField userField = new JTextField();
            userField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            userField.setBounds(20, 140, 310, 40);
            userField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            userField.setBackground(new Color(245, 245, 245));
            formPanel.add(userField);

            // Password label and field
            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            passwordLabel.setBounds(20, 200, 100, 20);
            formPanel.add(passwordLabel);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            passwordField.setBounds(20, 230, 310, 40);
            passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            passwordField.setBackground(new Color(245, 245, 245));
            formPanel.add(passwordField);

            // Telephone label and field
            JLabel telephoneLabel = new JLabel("Telephone");
            telephoneLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            telephoneLabel.setBounds(20, 290, 100, 20);
            formPanel.add(telephoneLabel);

            JTextField telephoneField = new JTextField();
            telephoneField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            telephoneField.setBounds(20, 320, 310, 40);
            telephoneField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            telephoneField.setBackground(new Color(245, 245, 245));
            formPanel.add(telephoneField);

            // Sign Up button
            JButton signUpButton = new JButton("Sign Up");
            signUpButton.setFont(new Font("SansSerif", Font.BOLD, 16));
            signUpButton.setForeground(Color.WHITE);
            signUpButton.setBounds(20, 380, 310, 45);
            signUpButton.setFocusPainted(false);
            signUpButton.setBorder(BorderFactory.createEmptyBorder());
            signUpButton.setBackground(new Color(0, 153, 153));
            signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            signUpButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    signUpButton.setBackground(new Color(0, 180, 180));
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    signUpButton.setBackground(new Color(0, 153, 153));
                }

                @Override
                public void mouseClicked(MouseEvent evt) {
                    String fullName = fullNameField.getText();
                    String userName = userField.getText();
                    String passWord = new String(passwordField.getPassword());
                    String telephone = telephoneField.getText();
                    User user = new User(1, fullName, userName, telephone, null, passWord, null);
                    try {
                        userServiceHandle.handleSignUp(user);
                        new LoginUI();
                        JOptionPane.showMessageDialog(frame, "Account created successfully!");
                    } catch (SQLException ex) {
                        Logger.getLogger(SignUpUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SignUpUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame.dispose();
                }
            });
            formPanel.add(signUpButton);

            // Already have an account label
            JLabel loginLabel = new JLabel("Already have an account? Login here.");
            loginLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            loginLabel.setForeground(new Color(0, 153, 153));
            loginLabel.setBounds(20, 440, 310, 30);
            loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
            loginLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

            loginLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        new LoginUI();
                        frame.dispose();
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(SignUpUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    loginLabel.setForeground(new Color(0, 180, 180));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    loginLabel.setForeground(new Color(0, 153, 153));
                }
            });
            formPanel.add(loginLabel);

            mainPanel.add(formPanel);
            frame.getContentPane().add(mainPanel);
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new SignUpUI();
    }
}
