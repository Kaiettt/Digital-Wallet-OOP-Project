
package bankingsystem.adminservice.bank.form;

import bankingsystem.adminservice.adminController.AdminServiceHandle;
import bankingsystem.adminservice.bank.bank.cell.CellAction;
import bankingsystem.adminservice.bank.bank.cell.CellBranch;
import bankingsystem.adminservice.bank.bank.cell.CellHotline;
import bankingsystem.adminservice.bank.bank.cell.CellID;
import bankingsystem.adminservice.bank.bank.cell.CellNameBank;
import bankingsystem.adminservice.bank.model.ModelNameStaff;
import com.raven.chart.ModelChartLine;
import com.raven.chart.ModelChartPie;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import bankingsystem.model.Bank;
public class Form_3 extends javax.swing.JPanel {

    private AdminServiceHandle adminServiceHandle;
    public Form_3() {
        this.adminServiceHandle = new AdminServiceHandle();
        initComponents();
        initComponents();
        table1.addTableStyle(jScrollPane1);
        init();
        initDataTable();
    }

    private void init() {
        List<ModelChartPie> list1 = new ArrayList<>();
        list1.add(new ModelChartPie("Monday", 10, new Color(4, 174, 243)));
        list1.add(new ModelChartPie("Tuesday", 150, new Color(215, 39, 250)));
        list1.add(new ModelChartPie("Wednesday", 80, new Color(44, 88, 236)));
        list1.add(new ModelChartPie("Thursday", 100, new Color(21, 202, 87)));
        list1.add(new ModelChartPie("Friday", 125, new Color(127, 63, 255)));
        list1.add(new ModelChartPie("Saturday", 80, new Color(238, 167, 35)));
        list1.add(new ModelChartPie("Sunday", 200, new Color(245, 79, 99)));
        chartPie.setModel(list1);
        
        List<ModelChartLine> list = new ArrayList<>();
        list.add(new ModelChartLine("Monday", 10));
        list.add(new ModelChartLine("Tuesday", 150));
        list.add(new ModelChartLine("Wednesday", 80));
        list.add(new ModelChartLine("Thursday", 100));
        list.add(new ModelChartLine("Friday", 125));
        list.add(new ModelChartLine("Saturday", 80));
        list.add(new ModelChartLine("Sunday", 200));
        chartLine1.setModel(list);
    }
    
    private void initDataTable(){
        List<Bank> banks = this.adminServiceHandle.getAllBanks();
        table1.addTableCell(new CellID(), 0);
        table1.addTableCell(new CellNameBank(), 1);
        table1.addTableCell(new CellBranch(), 2);
        table1.addTableCell(new CellHotline(), 3);
        table1.addTableCell(new CellAction(), 4);
        for (Bank bank : banks) {
            table1.addRow(new ModelNameStaff(String.valueOf(bank.getId()),bank.getName(),bank.getBranch(),"64324726"), false);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow2 = new bankingsystem.adminservice.bank.swing.PanelShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new bankingsystem.adminservice.bank.swing.TableForm2();
        cmdAdd = new bankingsystem.adminservice.bank.swing.Button();
        chartLine1 = new com.raven.chart.ChartLine();
        chartPie = new com.raven.chart.ChartPie();

        setBackground(new java.awt.Color(255, 255, 255));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Branch", "Hotline", "Action"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(80);
            table1.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        cmdAdd.setText("+ Add");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chartLine1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        table1.insertRowWithEdit(new ModelNameStaff("","","",""),0, true);
    }//GEN-LAST:event_cmdAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.chart.ChartLine chartLine1;
    private com.raven.chart.ChartPie chartPie;
    private bankingsystem.adminservice.bank.swing.Button cmdAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private bankingsystem.adminservice.bank.swing.PanelShadow panelShadow2;
    private bankingsystem.adminservice.bank.swing.TableForm2 table1;
    // End of variables declaration//GEN-END:variables
}
