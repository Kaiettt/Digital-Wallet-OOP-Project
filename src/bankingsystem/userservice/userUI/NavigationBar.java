/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userUI;

/**
 *
 * @author ANH KIET
 */
import java.awt.*;
import javax.swing.*;

public class NavigationBar extends JPanel {

    private JButton activeButton; // Track the active button

    public NavigationBar(String buttonChoosed) {
        setLayout(new GridLayout(1, 4)); // 4 columns for 4 buttons
        setBackground(new Color(240, 240, 240)); // Light gray background

        // Create buttons for the navigation bar
        JButton homeButton = createNavButton("Home", buttonChoosed);
        JButton friendsButton = createNavButton("Payment", buttonChoosed);
        JButton groupsButton = createNavButton("Wallet", buttonChoosed);
        JButton myLoopButton = createNavButton("History", buttonChoosed);


        // Add buttons to the panel
        add(homeButton);
        add(friendsButton);
        add(groupsButton);
        add(myLoopButton);
    }

    private JButton createNavButton(String text,String chooseButton) {
        JButton button = new JButton(text);
        boolean isActive = text.equals(chooseButton);
        // Customize button appearance
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false); // Remove focus border
        button.setBackground(isActive ? new Color(0x007BFF) : Color.WHITE); // Blue for active, white for inactive
        button.setForeground(isActive ? Color.WHITE : new Color(50, 50, 50)); // White text for active button
        button.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Subtle border
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setHorizontalAlignment(SwingConstants.CENTER);

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (button != activeButton) {
                    button.setBackground(new Color(220, 220, 220)); // Light gray on hover
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (button != activeButton) {
                    button.setBackground(Color.WHITE); // Back to white when not hovering
                }
            }

        });

        if (isActive) {
            setActiveButton(button); // Set the initial active button
        }

        return button;
    }

    private void setActiveButton(JButton newActiveButton) {
        // Reset the previous active button to default
        if (activeButton != null) {
            activeButton.setBackground(Color.WHITE);
            activeButton.setForeground(new Color(50, 50, 50));
        }

        // Set the new active button
        activeButton = newActiveButton;
        activeButton.setBackground(new Color(0x007BFF)); // Blue for active
        activeButton.setForeground(Color.WHITE); // White text for active button
    }
}

