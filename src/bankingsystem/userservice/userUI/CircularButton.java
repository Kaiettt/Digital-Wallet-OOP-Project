/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userUI;

/**
 *
 * @author ANH KIET
 */
import javax.swing.*;
import java.awt.*;
// Custom CircularButton class
class CircularButton extends JButton {
    private final Color backgroundColor;

    public CircularButton(String text, Color backgroundColor) {
        super(text);
        this.backgroundColor = backgroundColor;

        // General button customizations
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.BOLD, 16));
        setForeground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Button background with circular shape
        if (getModel().isPressed()) {
            g2.setColor(backgroundColor.darker()); // Darker color on press
        } else if (getModel().isRollover()) {
            g2.setColor(backgroundColor.brighter()); // Lighter color on hover
        } else {
            g2.setColor(backgroundColor); // Default background color
        }
        g2.fillOval(0, 0, getWidth(), getHeight());

        // Ensure proper text rendering
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(80, 80); // Default circular size
    }

    @Override
    public boolean contains(int x, int y) {
        int radius = Math.min(getWidth(), getHeight()) / 2;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        return Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2);
    }
}
