package bankingsystem.userservice.userUI.featuregroup;

import bankingsystem.database.userDB.DBConnection;
import bankingsystem.model.SavingAccount;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import bankingsystem.userservice.userController.ShowSavingAccount;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTable;

public class SavingGoalUpdate extends javax.swing.JFrame {

    private SavingAccount saving_account;
    private javax.swing.JFrame parent;
    private int id;
    private ShowSavingGoals saving_goal;
    private ShowSavingAccount showSavingAccount;

    public SavingGoalUpdate(int id, SavingAccount saving_account, javax.swing.JFrame parent, ShowSavingGoals saving_goal) {
        this.id = id;
        this.saving_account = saving_account;
        this.parent = parent;
        this.saving_goal = saving_goal;
        this.showSavingAccount = new ShowSavingAccount();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jend_dateTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDescriptionTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTarget_amountTargetTextField = new javax.swing.JTextField();
        jTitleTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jresetButton = new javax.swing.JButton();
        jUPDATEButton = new javax.swing.JButton();
        panel11 = new bankingsystem.userservice.userUI.featuregroup.panel1();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jaccount_idLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jBackButton = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jend_dateTextField.setBackground(new java.awt.Color(121, 207, 255));
        jend_dateTextField.setForeground(new java.awt.Color(255, 255, 255));
        jend_dateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jend_dateTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Title");

        jDescriptionTextField.setBackground(new java.awt.Color(121, 207, 255));
        jDescriptionTextField.setForeground(new java.awt.Color(255, 255, 255));
        jDescriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDescriptionTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Description");

        jTarget_amountTargetTextField.setBackground(new java.awt.Color(121, 207, 255));
        jTarget_amountTargetTextField.setForeground(new java.awt.Color(255, 255, 255));
        jTarget_amountTargetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTarget_amountTargetTextFieldActionPerformed(evt);
            }
        });

        jTitleTextField.setBackground(new java.awt.Color(121, 207, 255));
        jTitleTextField.setForeground(new java.awt.Color(255, 255, 255));
        jTitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTitleTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Target Amount");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("End Date (Y/M/D) ");

        jresetButton.setBackground(new java.awt.Color(59, 156, 253));
        jresetButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jresetButton.setForeground(new java.awt.Color(255, 255, 255));
        jresetButton.setText("Reset");
        jresetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jresetButtonActionPerformed(evt);
            }
        });

        jUPDATEButton.setBackground(new java.awt.Color(59, 156, 253));
        jUPDATEButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jUPDATEButton.setForeground(new java.awt.Color(255, 255, 255));
        jUPDATEButton.setText("Update");
        jUPDATEButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUPDATEButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SAVING UPDATE");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankingsystem/userservice/userUI/image/more_1.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankingsystem/userservice/userUI/image/left (4).png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankingsystem/userservice/userUI/image/sync.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Account Id: ");

        jaccount_idLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jaccount_idLabel.setForeground(new java.awt.Color(255, 255, 255));
        jaccount_idLabel.setText("xxx");

        javax.swing.GroupLayout panel11Layout = new javax.swing.GroupLayout(panel11);
        panel11.setLayout(panel11Layout);
        panel11Layout.setHorizontalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(panel11Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jaccount_idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel11Layout.setVerticalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(panel11Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jaccount_idLabel))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankingsystem/userservice/userUI/image/real-time.png"))); // NOI18N

        jBackButton.setBackground(new java.awt.Color(59, 156, 253));
        jBackButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBackButton.setForeground(new java.awt.Color(255, 255, 255));
        jBackButton.setText("Back");
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTitleTextField)
                            .addComponent(jTarget_amountTargetTextField)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jend_dateTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDescriptionTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jUPDATEButton)
                        .addGap(18, 18, 18)
                        .addComponent(jresetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBackButton)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTarget_amountTargetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jend_dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jresetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUPDATEButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private void isNotEmpty() {
        if (jTitleTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "title không được rỗng");
            jTitleTextField.requestFocus();
            return;
        } else if (jDescriptionTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "description không được rỗng");
            jDescriptionTextField.requestFocus();
            return;
        } else if (jTarget_amountTargetTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "target không được rỗng");
            jTarget_amountTargetTextField.requestFocus();
            return;
        } else if (jend_dateTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "end date không được rỗng");
            jend_dateTextField.requestFocus();
            return;
        }
    }

    private void isValidFormat() {
        String end_date = jend_dateTextField.getText();
         if (!jTarget_amountTargetTextField.getText().matches("-?\\d*(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(null, "Target number chỉ được nhập dạng số thực");
            jTarget_amountTargetTextField.requestFocus();
            return;
        } // check định dạng ngày tháng năm
        else if (!isValidDate(end_date)) {
            JOptionPane.showMessageDialog(null, "Ngày tháng năm nhập sai định dạng ");
            jend_dateTextField.requestFocus();
            return;
        }
    }

    private void jUPDATEButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUPDATEButtonActionPerformed

        isNotEmpty();
        isValidFormat();

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE saving_goals SET title = ?, description = ?, target_amount =?,end_date =? where id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, jTitleTextField.getText());
            pstm.setString(2, jDescriptionTextField.getText());
            pstm.setBigDecimal(3, new BigDecimal(jTarget_amountTargetTextField.getText()));
            pstm.setDate(4, java.sql.Date.valueOf(jend_dateTextField.getText()));
            pstm.setInt(5, id);
            pstm.executeUpdate();
            int resupdate = JOptionPane.showConfirmDialog(null, "xác nhận update");
            if (resupdate == JOptionPane.NO_OPTION || resupdate == JOptionPane.CANCEL_OPTION) {
                return;
            }
            JOptionPane.showMessageDialog(null, "đã update");

            saving_goal = new ShowSavingGoals(parent, saving_account);
            DefaultTableModel model = showSavingAccount.showGoal(saving_goal);
            saving_goal.setVisible(true);
            this.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(SavingGoalInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SavingGoalUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        // showSavingAccount.EraseGoal();

    }//GEN-LAST:event_jUPDATEButtonActionPerformed

    private void jresetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jresetButtonActionPerformed

        jTitleTextField.setText("");
        jDescriptionTextField.setText("");
        jTarget_amountTargetTextField.setText("");
        jend_dateTextField.setText("");
    }//GEN-LAST:event_jresetButtonActionPerformed

    private void jDescriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDescriptionTextFieldActionPerformed

    }//GEN-LAST:event_jDescriptionTextFieldActionPerformed

    private void jTarget_amountTargetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTarget_amountTargetTextFieldActionPerformed

    }//GEN-LAST:event_jTarget_amountTargetTextFieldActionPerformed

    private void jend_dateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jend_dateTextFieldActionPerformed

    }//GEN-LAST:event_jend_dateTextFieldActionPerformed

    private void jTitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTitleTextFieldActionPerformed

    }//GEN-LAST:event_jTitleTextFieldActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jaccount_idLabel.setText(saving_account.getAccountId());
    }//GEN-LAST:event_formComponentShown

    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        if (parent != null) {
            parent.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jBackButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new SavingGoalUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBackButton;
    private javax.swing.JTextField jDescriptionTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTarget_amountTargetTextField;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTitleTextField;
    private javax.swing.JButton jUPDATEButton;
    private javax.swing.JLabel jaccount_idLabel;
    private javax.swing.JTextField jend_dateTextField;
    private javax.swing.JButton jresetButton;
    private bankingsystem.userservice.userUI.featuregroup.panel1 panel11;
    // End of variables declaration//GEN-END:variables
}
