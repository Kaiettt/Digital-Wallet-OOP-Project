package bankingsystem.userservice.userUI.featuregroup;

import bankingsystem.database.userDB.DBConnection;
import bankingsystem.model.SavingAccount;
import bankingsystem.userservice.userController.ShowSavingAccount;

import javax.swing.JOptionPane;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ShowSavingGoals extends javax.swing.JFrame {

    private SavingAccount saving_account;
    private javax.swing.JFrame parent;
    private ShowSavingAccount showSavingAccount;
    private ShowSavingGoals showSavingGoal;

    public ShowSavingGoals(javax.swing.JFrame parent, SavingAccount saving_account) {
        this.parent = parent;
        this.saving_account = saving_account;
        this.showSavingAccount = new ShowSavingAccount();
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBackButton = new javax.swing.JButton();
        jSUAButton = new javax.swing.JButton();
        jthemButton = new javax.swing.JButton();
        jXOAButton = new javax.swing.JButton();
        panel11 = new bankingsystem.userservice.userUI.featuregroup.panel1();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMain = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        panel21 = new bankingsystem.userservice.userUI.featuregroup.panel2();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jaccount_idLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbalanceLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jBackButton.setBackground(new java.awt.Color(37, 193, 245));
        jBackButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBackButton.setForeground(new java.awt.Color(255, 255, 255));
        jBackButton.setText("BACK");
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        jSUAButton.setBackground(new java.awt.Color(37, 193, 245));
        jSUAButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSUAButton.setForeground(new java.awt.Color(255, 255, 255));
        jSUAButton.setText("SỬA");
        jSUAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSUAButtonActionPerformed(evt);
            }
        });

        jthemButton.setBackground(new java.awt.Color(37, 193, 245));
        jthemButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jthemButton.setForeground(new java.awt.Color(255, 255, 255));
        jthemButton.setText("THÊM");
        jthemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jthemButtonActionPerformed(evt);
            }
        });

        jXOAButton.setBackground(new java.awt.Color(37, 193, 245));
        jXOAButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jXOAButton.setForeground(new java.awt.Color(255, 255, 255));
        jXOAButton.setText("XÓA");
        jXOAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXOAButtonActionPerformed(evt);
            }
        });

        jTableMain.setBackground(new java.awt.Color(102, 204, 255));
        jTableMain.setForeground(new java.awt.Color(255, 255, 255));
        jTableMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Title", "Description", "Target amount", "End date"
            }
        ));
        jScrollPane1.setViewportView(jTableMain);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Your Savings Goals");

        javax.swing.GroupLayout panel11Layout = new javax.swing.GroupLayout(panel11);
        panel11.setLayout(panel11Layout);
        panel11Layout.setHorizontalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
            .addGroup(panel11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel11Layout.setVerticalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SAVING GOAL");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:/Users/ANH KIET/Documents/NetBeansProjects/BankingSystem/src/bankingsystem/userservice/userUI/image/more_1.png")); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon("C:/Users/ANH KIET/Documents/NetBeansProjects/BankingSystem/src/bankingsystem/userservice/userUI/image/left (4).png")); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon("C:/Users/ANH KIET/Documents/NetBeansProjects/BankingSystem/src/bankingsystem/userservice/userUI/image/savings (2).png")); // NOI18N

        jaccount_idLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jaccount_idLabel.setForeground(new java.awt.Color(255, 255, 255));
        jaccount_idLabel.setText("xxx");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Account Id: ");

        jbalanceLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jbalanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        jbalanceLabel.setText("xx");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Balance");
        jLabel7.setToolTipText("");

        javax.swing.GroupLayout panel21Layout = new javax.swing.GroupLayout(panel21);
        panel21.setLayout(panel21Layout);
        panel21Layout.setHorizontalGroup(
            panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel21Layout.createSequentialGroup()
                .addGroup(panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel21Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel21Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbalanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel21Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jaccount_idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35))
                    .addGroup(panel21Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        panel21Layout.setVerticalGroup(
            panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel21Layout.createSequentialGroup()
                .addGroup(panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel21Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel3))
                        .addGroup(panel21Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel2))))
                .addGap(21, 21, 21)
                .addGroup(panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel21Layout.createSequentialGroup()
                        .addGroup(panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jaccount_idLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbalanceLabel)))
                    .addComponent(jLabel5))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jXOAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jthemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSUAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(panel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(panel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXOAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jthemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSUAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        if (parent != null) {
            parent.setVisible(true);
        }
        this.dispose();

    }//GEN-LAST:event_jBackButtonActionPerformed

    private void jSUAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSUAButtonActionPerformed

        int pos = jTableMain.getSelectedRow();
        if (pos == -1) {
            JOptionPane.showConfirmDialog(null, "vui lòng chọn một dòng");
            return;
        }
        Object value = jTableMain.getModel().getValueAt(pos, 0);
        int data = (int) value;

        SavingGoalUpdate SU = new SavingGoalUpdate(data, saving_account, this, this);
        SU.setVisible(true);

    }//GEN-LAST:event_jSUAButtonActionPerformed

    private void jthemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jthemButtonActionPerformed

        SavingGoalInsert sg = new SavingGoalInsert(saving_account.getAccountId(), this, this);

        sg.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jthemButtonActionPerformed

    private void jXOAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXOAButtonActionPerformed

        int res = JOptionPane.showConfirmDialog(null, "bạn có chắc muốn xóa quỹ tiết kiệm này không");
        if (res == 0) {
            int pos = jTableMain.getSelectedRow();
            if (pos == -1) {
                JOptionPane.showMessageDialog(null, "vui lòng chọn một dòng để xoá");
                return;
            }
            Object value = jTableMain.getModel().getValueAt(pos, 0);
            int data = (int) value;
            try {
                showSavingAccount.EraseGoal(data);
                
                DefaultTableModel model = showSavingAccount.showGoal(showSavingGoal);
                jTableMain.setModel(model);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ShowSavingGoals.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
       
    }//GEN-LAST:event_jXOAButtonActionPerformed

    
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            DefaultTableModel model = showSavingAccount.showGoal(showSavingGoal);
            jTableMain.setModel(model);
            jaccount_idLabel.setText(String.valueOf(saving_account.getAccountId()));
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")); // Vietnamese locale
            String formattedBalance = currencyFormatter.format(saving_account.getBalance());
            jbalanceLabel.setText(formattedBalance);
        } catch (SQLException ex) {
            Logger.getLogger(SavingGoalInsert.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "lỗi khi load dữ liệu ");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowSavingGoals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                SavingAccount sa = new SavingAccount("",0,0);
//            
//                new ShowSavingGoals(sa).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jSUAButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableMain;
    private javax.swing.JButton jXOAButton;
    private javax.swing.JLabel jaccount_idLabel;
    private javax.swing.JLabel jbalanceLabel;
    private javax.swing.JButton jthemButton;
    private bankingsystem.userservice.userUI.featuregroup.panel1 panel11;
    private bankingsystem.userservice.userUI.featuregroup.panel2 panel21;
    // End of variables declaration//GEN-END:variables
}
