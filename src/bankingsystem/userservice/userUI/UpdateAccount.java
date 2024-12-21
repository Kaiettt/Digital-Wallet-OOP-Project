/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.userservice.userUI;

/**
 *
 * @author ANH KIET
 */
import bankingsystem.model.Bank;
import bankingsystem.model.CheckingAccount;
import bankingsystem.model.User;
import bankingsystem.userservice.userController.UserServiceHandle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UpdateAccount {
    private List<Bank> bank_list;
    private User main_user;
    private UserServiceHandle userServiceHandle;
    public UpdateAccount(List<Bank> bank_list,User main_user,JFrame main_frame,CheckingAccount main_account) throws SQLException, ClassNotFoundException {
        this.bank_list = bank_list;
        this.main_user  = main_user;
        this.userServiceHandle = new UserServiceHandle();
        // Create the main frame
       
        JFrame frame = new JFrame("Cập nhập tài khoản");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 400); // Updated dimensions
        frame.setLayout(null); // Using absolute positioning for customization
        frame.setLocationRelativeTo(null);
        // Set a background color
        frame.getContentPane().setBackground(new Color(240, 248, 255));

        // Header label
        JLabel lblHeader = new JLabel("Cập nhập tài khoản");
        lblHeader.setBounds(80, 20, 250, 40);
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblHeader.setForeground(new Color(25, 42, 86));
        frame.add(lblHeader);

        // Account ID label and text field
        JLabel lblAccountId = new JLabel("Account ID:");
        lblAccountId.setBounds(50, 80, 100, 30);
        lblAccountId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        frame.add(lblAccountId);

        JTextField txtAccountId = new JTextField();
        txtAccountId.setText(main_account.getAccountId());
        txtAccountId.setBounds(160, 80, 180, 30);
        txtAccountId.setBorder(new LineBorder(new Color(176, 196, 222), 2, true));
        txtAccountId.setToolTipText("Enter a unique account ID.");
        frame.add(txtAccountId);

        // Bank selection label and combo box
        JLabel lblBank = new JLabel("Bank:");
        lblBank.setBounds(50, 130, 100, 30);
        lblBank.setFont(new Font("SansSerif", Font.PLAIN, 14));
        frame.add(lblBank);
        
        int index = 0;
  
        String[] banks = new String[bank_list.size()];
        for (int i = 0;i<bank_list.size();i++) {
            banks[i] = bank_list.get(i).getName();
            if(banks[i].equals(main_account.getBank().getName())){
                index = i;
            }
        }
        JComboBox<String> cmbBank = new JComboBox<>(banks);
        cmbBank.setBounds(160, 130, 180, 30);
        cmbBank.setBorder(new LineBorder(new Color(176, 196, 222), 2, true));
        cmbBank.setToolTipText("Select a bank from the dropdown.");
        cmbBank.setSelectedIndex(index);
        frame.add(cmbBank);
        


        // Submit button
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(125, 260, 150, 40);
        btnSubmit.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnSubmit.setBackground(new Color(0x608BC1));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFocusPainted(false);
        btnSubmit.setBorder(BorderFactory.createEmptyBorder());
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSubmit.setToolTipText("Click to submit your details.");
        frame.add(btnSubmit);

        // Action listener for submit button
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBank = (String) cmbBank.getSelectedItem();
                

                if (selectedBank.equals("Select a Bank")) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        handleupdateAccount(main_account,selectedBank);
                    } catch (SQLException ex) {
                        Logger.getLogger(UpdateAccount.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UpdateAccount.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame.dispose();
                    main_frame.dispose();
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
    public void handleupdateAccount(CheckingAccount account,String bank_name) throws SQLException, ClassNotFoundException{
        for (Bank bank : this.bank_list) {
            if(bank.getName().equals(bank_name)){
                account.setBank(bank);
                break;
            }
        }
        userServiceHandle.handleUpdateAccount(account);
        
        ChooseAccountUI chooseAccountUI = new ChooseAccountUI(this.main_user);
    }
 
}

