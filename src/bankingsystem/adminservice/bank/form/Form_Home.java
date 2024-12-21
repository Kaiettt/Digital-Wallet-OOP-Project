package bankingsystem.adminservice.bank.form;

import bankingsystem.adminservice.adminController.AdminServiceHandle;
import bankingsystem.adminservice.bank.model.Model_Card;
import bankingsystem.adminservice.bank.model.StatusType;
import bankingsystem.adminservice.bank.swing.scrollbar.ScrollBar;
import bankingsystem.model.Transaction;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Home extends javax.swing.JPanel {
    private AdminServiceHandle adminServiceHandle;
    public Form_Home() {
        this.adminServiceHandle = new AdminServiceHandle();
        initComponents();
        card1.setData(new Model_Card(new ImageIcon("C:/Users/ANH KIET/Documents/NetBeansProjects/BankingSystem/src/bankingsystem/adminservice/bank/icon/emv_chip fake.png"), "Stock Total", "$200000", "Increased by 60%"));
        card2.setData(new Model_Card(new ImageIcon("C:/Users/ANH KIET/Documents/NetBeansProjects/BankingSystem/src/bankingsystem/adminservice/bank/icon/baseline_add_card_black_18dp.png"), "Total Profit", "$15000", "Increased by 25%"));
        card3.setData(new Model_Card(new ImageIcon("C:/Users/ANH KIET/Documents/NetBeansProjects/BankingSystem/src/bankingsystem/adminservice/bank/icon/baseline_card_giftcard_black_24dp.png"), "Unique Visitors", "$300000", "Increased by 70%"));
        // add cot table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        // Format the currency
        
        List<Transaction> transactions  = this.adminServiceHandle.getAllTransactions();
        for (Transaction transaction : transactions) {
                String formattedCurrency = currencyFormatter.format(transaction.getAmount());
             table.addRow(new Object[]{formattedCurrency, transaction.getFromAccount().getAccountId(), transaction.getToAccount().getAccountId(),transaction.getTime().toString(), StatusType.PENDING});
        }
       

    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        card1 = new bankingsystem.adminservice.bank.component.Card();
        card2 = new bankingsystem.adminservice.bank.component.Card();
        card3 = new bankingsystem.adminservice.bank.component.Card();
        panelBorder1 = new bankingsystem.adminservice.bank.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new bankingsystem.adminservice.bank.swing.Table();

        setBackground(new java.awt.Color(242, 240, 240));

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(21, 101, 192));
        card1.setColor2(new java.awt.Color(102, 204, 255));
        jLayeredPane1.add(card1);

        card2.setColor1(new java.awt.Color(142, 142, 250));
        card2.setColor2(new java.awt.Color(123, 123, 245));
        jLayeredPane1.add(card2);

        card3.setColor1(new java.awt.Color(186, 123, 247));
        card3.setColor2(new java.awt.Color(167, 94, 236));
        jLayeredPane1.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 124, 124));
        jLabel1.setText("Transactions");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Amount", "From Account", "To Account", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private bankingsystem.adminservice.bank.component.Card card1;
    private bankingsystem.adminservice.bank.component.Card card2;
    private bankingsystem.adminservice.bank.component.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private bankingsystem.adminservice.bank.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private bankingsystem.adminservice.bank.swing.Table table;
    // End of variables declaration//GEN-END:variables
}
