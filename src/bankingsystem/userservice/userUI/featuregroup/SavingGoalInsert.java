
package bankingsystem.userservice.userUI.featuregroup;

import bankingsystem.database.userDB.DBConnection;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import bankingsystem.userservice.userController.ShowSavingAccount;

public class SavingGoalInsert extends javax.swing.JFrame {
private String account_id;
private ShowSavingGoals savinggoal;
private javax.swing.JFrame parent;
private ShowSavingAccount showSavingAccount;
    public SavingGoalInsert(String account_id, ShowSavingGoals savinggoal, javax.swing.JFrame parent) {
        this.account_id= account_id;
        this.savinggoal = savinggoal;
        this.parent = parent;
        this.showSavingAccount = new ShowSavingAccount();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setLocationRelativeTo(null);
        //jAccountLabel.setText("account id: "+this.account_id);
        
      
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTitleTextField = new javax.swing.JTextField();
        jDescriptionTextField = new javax.swing.JTextField();
        jTargetTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jend_dateTextField = new javax.swing.JTextField();
        jOKButton = new javax.swing.JButton();
        jResetButton = new javax.swing.JButton();
        jBackButton = new javax.swing.JButton();
        panel11 = new bankingsystem.userservice.userUI.featuregroup.panel1();
        jAccountLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(jTable1);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        jTitleTextField.setBackground(new java.awt.Color(121, 207, 255));
        jTitleTextField.setForeground(new java.awt.Color(255, 255, 255));
        jTitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTitleTextFieldActionPerformed(evt);
            }
        });

        jDescriptionTextField.setBackground(new java.awt.Color(121, 207, 255));
        jDescriptionTextField.setForeground(new java.awt.Color(255, 255, 255));
        jDescriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDescriptionTextFieldActionPerformed(evt);
            }
        });

        jTargetTextField.setBackground(new java.awt.Color(121, 207, 255));
        jTargetTextField.setForeground(new java.awt.Color(255, 255, 255));
        jTargetTextField.setToolTipText("");
        jTargetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTargetTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Title");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Description");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Target number");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("End date (Y/M/D)");

        jend_dateTextField.setBackground(new java.awt.Color(121, 207, 255));
        jend_dateTextField.setForeground(new java.awt.Color(255, 255, 255));

        jOKButton.setBackground(new java.awt.Color(59, 156, 253));
        jOKButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jOKButton.setForeground(new java.awt.Color(255, 255, 255));
        jOKButton.setText("ADD");
        jOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOKButtonActionPerformed(evt);
            }
        });

        jResetButton.setBackground(new java.awt.Color(59, 156, 253));
        jResetButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jResetButton.setForeground(new java.awt.Color(255, 255, 255));
        jResetButton.setText("RESET");
        jResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jResetButtonActionPerformed(evt);
            }
        });

        jBackButton.setBackground(new java.awt.Color(59, 156, 253));
        jBackButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBackButton.setForeground(new java.awt.Color(255, 255, 255));
        jBackButton.setText("BACK");
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        jAccountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jAccountLabel.setForeground(new java.awt.Color(255, 255, 255));
        jAccountLabel.setText("XXX");
        jAccountLabel.setToolTipText("");
        jAccountLabel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jAccountLabelComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INSERT ACCOUNT");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankingsystem/userservice/userUI/image/left (4).png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankingsystem/userservice/userUI/image/more_1.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Account id: ");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankingsystem/userservice/userUI/image/add-user.png"))); // NOI18N

        javax.swing.GroupLayout panel11Layout = new javax.swing.GroupLayout(panel11);
        panel11.setLayout(panel11Layout);
        panel11Layout.setHorizontalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panel11Layout.setVerticalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAccountLabel)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jend_dateTextField)
                            .addComponent(jTargetTextField)
                            .addComponent(jDescriptionTextField)
                            .addComponent(jTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jOKButton)
                        .addGap(34, 34, 34)
                        .addComponent(jResetButton)
                        .addGap(37, 37, 37)
                        .addComponent(jBackButton)
                        .addGap(72, 72, 72))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTargetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jend_dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jOKButton)
                    .addComponent(jResetButton)
                    .addComponent(jBackButton))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTitleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTitleTextFieldActionPerformed

    private boolean isValidDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try{
            sdf.parse(date);
            return true;
        }
        catch(ParseException e){
             return false;
        }
    }
    
    private void isNotEmpty(){
        if(jTitleTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "title không được rỗng");
            jTitleTextField.requestFocus();
            return;
        }
        else if(jDescriptionTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "description không được rỗng");
            jDescriptionTextField.requestFocus();
            return;
        }
      
        else if(jTargetTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "target không được rỗng");
            jTargetTextField.requestFocus();
            return;
        }
        else if(jend_dateTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "end date không được rỗng");
            jend_dateTextField.requestFocus();
            return;
        }
    }
    private void isValidFormat(){
        String end_date = jend_dateTextField.getText();
   
        if(!jTargetTextField.getText().matches("-?\\d*(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null, "Target number chỉ được nhập dạng số thực");
            jTargetTextField.requestFocus();
            return;
        }
        
        // check định dạng ngày tháng năm
        else if(!isValidDate(end_date)){
            JOptionPane.showMessageDialog(null,"Ngày tháng năm nhập sai định dạng ");
            jend_dateTextField.requestFocus();
            return;
        }
    }
    private void jOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOKButtonActionPerformed

          isNotEmpty();
          isValidFormat();
            try{
                Connection conn = DBConnection.getConnection();
                String sql =" INSERT INTO saving_goals (title,description,account_id,target_amount,end_date)"+
                        "VALUES (?,?,?,?,?)";
                PreparedStatement pstm = conn.prepareStatement(sql);
                
                pstm.setString(1,jTitleTextField.getText());
                pstm.setString(2, jDescriptionTextField.getText());
                pstm.setString(3,account_id);
                pstm.setBigDecimal(4,new BigDecimal(jTargetTextField.getText()));
                pstm.setDate(5, java.sql.Date.valueOf(jend_dateTextField.getText()));
                pstm.executeUpdate();
                JOptionPane.showMessageDialog(null,"đã thêm");
                
                savinggoal.setVisible(true);
                DefaultTableModel model = showSavingAccount.showGoal(savinggoal);
                this.dispose();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"lỗi");
                Logger.getLogger(SavingGoalInsert.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
        Logger.getLogger(SavingGoalInsert.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }//GEN-LAST:event_jOKButtonActionPerformed

    private void jResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jResetButtonActionPerformed

        jTitleTextField.setText("");
        jDescriptionTextField.setText("");
        jTargetTextField.setText("");
        jend_dateTextField.setText("");
        
    }//GEN-LAST:event_jResetButtonActionPerformed

    private void jAccountLabelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jAccountLabelComponentShown
         
        
    }//GEN-LAST:event_jAccountLabelComponentShown

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown

    }//GEN-LAST:event_jPanel1ComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    
         jAccountLabel.setText(" " + this.account_id);
    }//GEN-LAST:event_formComponentShown

    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        
        if(parent != null){
            parent.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jBackButtonActionPerformed

    private void jTargetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTargetTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTargetTextFieldActionPerformed

    private void jDescriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDescriptionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDescriptionTextFieldActionPerformed

    
    public static void main(String args[]) {
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SavingGoalInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SavingGoalInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SavingGoalInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SavingGoalInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//               new SavingGoalInsert().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAccountLabel;
    private javax.swing.JButton jBackButton;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JTextField jDescriptionTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jOKButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jResetButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTargetTextField;
    private javax.swing.JTextField jTitleTextField;
    private javax.swing.JTextField jend_dateTextField;
    private bankingsystem.userservice.userUI.featuregroup.panel1 panel11;
    // End of variables declaration//GEN-END:variables
}
