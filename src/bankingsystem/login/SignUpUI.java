package bankingsystem.login;

import bankingsystem.model.User;
import bankingsystem.userservice.userController.UserServiceHandle;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SignUpUI {

    private JFrame frame;
    private UserServiceHandle userServiceHandle;

    public SignUpUI() throws SQLException, ClassNotFoundException {
        userServiceHandle = new UserServiceHandle();
        
        // Create the main frame
        frame = new JFrame("Banking App - Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 550); // Decreased height of the frame
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
        JLabel titleLabel = new JLabel("Create a New Account");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(100, 51, 250, 30); // Adjusted position upwards
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel);

        // Panel for form content (with rounded corners and white background)
        JPanel formPanel = new JPanel();
        formPanel.setBounds(50, 101, 350, 400); // Adjusted position and height
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(null);
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Add form fields
        addFormFields(formPanel);

        // Add formPanel to mainPanel
        mainPanel.add(formPanel);

        // Add mainPanel to frame
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    private void addFormFields(JPanel formPanel) {
        // Full Name
        JLabel fullNameEmoji = new JLabel("👤");
        fullNameEmoji.setFont(new Font("SansSerif", Font.PLAIN, 20));
        fullNameEmoji.setBounds(30, 55, 30, 30);
        formPanel.add(fullNameEmoji);

        JLabel fullNameLabel = new JLabel("Full Name");
        fullNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        fullNameLabel.setBounds(60, 20, 100, 30);
        formPanel.add(fullNameLabel);

        JTextField fullNameField = new JTextField();
        fullNameField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        fullNameField.setBounds(60, 50, 250, 40);
        fullNameField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        fullNameField.setBackground(new Color(240, 240, 240));
        fullNameField.setOpaque(true);
        formPanel.add(fullNameField);

        // Username
        JLabel userEmoji = new JLabel("🔑");
        userEmoji.setFont(new Font("SansSerif", Font.PLAIN, 20));
        userEmoji.setBounds(30, 140, 30, 30);
        formPanel.add(userEmoji);

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        userLabel.setBounds(60, 100, 100, 30);
        formPanel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        userField.setBounds(60, 130, 250, 40);
        userField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        userField.setBackground(new Color(240, 240, 240));
        userField.setOpaque(true);
        formPanel.add(userField);

        // Password
        JLabel passwordEmoji = new JLabel("🔒");
        passwordEmoji.setFont(new Font("SansSerif", Font.PLAIN, 20));
        passwordEmoji.setBounds(30, 215, 30, 30);
        formPanel.add(passwordEmoji);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        passwordLabel.setBounds(60, 180, 100, 30);
        formPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        passwordField.setBounds(60, 210, 250, 40);
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        passwordField.setBackground(new Color(240, 240, 240));
        passwordField.setOpaque(true);
        formPanel.add(passwordField);

        // Telephone
        JLabel telephoneEmoji = new JLabel("📞");
        telephoneEmoji.setFont(new Font("SansSerif", Font.PLAIN, 20));
        telephoneEmoji.setBounds(30, 290, 30, 30);
        formPanel.add(telephoneEmoji);

        JLabel telephoneLabel = new JLabel("Telephone");
        telephoneLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        telephoneLabel.setBounds(60, 260, 100, 30);
        formPanel.add(telephoneLabel);

        JTextField telephoneField = new JTextField();
        telephoneField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        telephoneField.setBounds(60, 290, 250, 40);
        telephoneField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        telephoneField.setBackground(new Color(240, 240, 240));
        telephoneField.setOpaque(true);
        formPanel.add(telephoneField);

        // Sign-up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBounds(20, 340, 310, 45);
        signUpButton.setFocusPainted(false);
        signUpButton.setBorder(BorderFactory.createEmptyBorder());
        signUpButton.setBackground(new Color(0, 153, 204));
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton.setOpaque(true);

        signUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    String fullName = fullNameField.getText();
                    String userName = userField.getText();
                    String passWord = new String(passwordField.getPassword());
                    String telephone = telephoneField.getText();
                    User user = new User(1, fullName, userName, telephone, null, passWord, null);
                    userServiceHandle.handleSignUp(user);
                    frame.dispose();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(SignUpUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        formPanel.add(signUpButton);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new SignUpUI();
    }
}
