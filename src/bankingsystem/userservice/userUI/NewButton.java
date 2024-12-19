/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userUI;

/**
 *
 * @author ANH KIET
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class NewButton extends JButton {
    private Color backgroundColor;
    private Color foregroundColor;
    public NewButton(String text,Color backgroundColor,Color foregroundColor) {
        super(text);
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;

        // Button customization
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFont(new Font("Arial", Font.BOLD, 16));
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Button background
        if (getModel().isPressed()) {
            g2.setColor(new Color(80, 120, 200)); // Pressed color
        } else if (getModel().isRollover()) {
            g2.setColor(new Color(100, 140, 220)); // Hover color
        } else {
            g2.setColor(this.backgroundColor); // Default color
        }
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        // Button text
        g2.setColor(Color.WHITE);
        super.paintComponent(g);
    }
}

