package bankingsystem.adminservice.bank.swing;

import bankingsystem.adminservice.bank.model.Model_Menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.Timer;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MenuiItem extends javax.swing.JPanel {

    private boolean selected;
    private boolean hover;

    private int rippleRadius = 0; // Bán kính của ripple
    private int clickX = -1; // Tọa độ X khi click
    private int clickY = -1; // Tọa độ Y khi click
    private Timer rippleTimer; // Timer để thực hiện hiệu ứng ripple

    private Animator animator; // Animator cho hiệu ứng thay đổi kích thước
    private float animatSize = 1f; // Kích thước hiện tại của menu item
    private int targetSize = 1; // Kích thước mục tiêu của menu item khi nhấn

    public MenuiItem(Model_Menu data) {
        initComponents();
        setOpaque(false);
        setupRippleEffect(); // Khởi tạo hiệu ứng ripple
        setupAnimator(); // Khởi tạo hiệu ứng phóng to

        if (data.getType() == Model_Menu.MenuType.MENU) {
            lbIcon.setIcon(data.toIcon());
            lbName.setText(data.getName());
        } else if (data.getType() == Model_Menu.MenuType.TITLE) {
            lbIcon.setText(data.getName());
            lbName.setVisible(false);
        } else {
            lbName.setText(" ");
        }

    }

    private void setupRippleEffect() {
        rippleTimer = new Timer(16, e -> { // Cập nhật hiệu ứng ripple mỗi 16ms
            rippleRadius += 10; // Tăng bán kính ripple
            if (rippleRadius > Math.max(getWidth(), getHeight())) { // Dừng hiệu ứng khi bán kính vượt quá kích thước panel
                rippleRadius = 0;
                rippleTimer.stop();
            }
            repaint();
        });
    }

    private void setupAnimator() {
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                animatSize = 1 + (fraction * targetSize); // Tăng kích thước khi nhấn
                repaint();
            }

            @Override
            public void end() {
                // Reset lại kích thước khi hiệu ứng kết thúc
                animatSize = 1f;
            }
        };
        animator = new Animator(200, target); // Animator với thời gian 200ms
        animator.setResolution(0);
    }

    public void startRipple(int x, int y) {
        clickX = x; // Lưu tọa độ click
        clickY = y;
        rippleRadius = 0; // Reset bán kính ripple
        rippleTimer.start(); // Bắt đầu hiệu ứng
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        targetSize = 10; // Phóng to khi nhấn
        if (animator.isRunning()) {
            animator.stop();
        }
        animator.start(); // Bắt đầu hiệu ứng phóng to
        repaint(); // Làm mới giao diện khi trạng thái thay đổi
    }

    public void setHover(boolean hover) {
        this.hover = hover;
        repaint(); // Làm mới giao diện khi di chuột
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        lbIcon.setBackground(new java.awt.Color(255, 255, 255));
        lbIcon.setForeground(new java.awt.Color(255, 255, 255));

        lbName.setForeground(new java.awt.Color(255, 255, 255));
        lbName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbIcon)
                .addGap(18, 18, 18)
                .addComponent(lbName)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ ripple effect
        if (rippleRadius > 0) {
            g2.setColor(new Color(0, 180, 219)); // Màu ripple
            g2.fillOval(clickX - rippleRadius / 2, clickY - rippleRadius / 2, rippleRadius, rippleRadius);
        }

        // Hiệu ứng khi được chọn
        if (selected) {
            g2.setColor(new Color(28, 239, 255));
            g2.fillRoundRect(10, 0, (int) ((getWidth() - 20) * animatSize), getHeight(), 10, 10);
        } else if (hover) {
            // Hiệu ứng khi hover
            g2.setColor(new Color(109, 213, 250));
            g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 10, 10);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
