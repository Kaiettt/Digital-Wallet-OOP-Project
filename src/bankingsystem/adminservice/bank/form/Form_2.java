package bankingsystem.adminservice.bank.form;

import bankingsystem.adminservice.adminController.AdminServiceHandle;
import bankingsystem.adminservice.bank.bank.cell.CellAction;
import bankingsystem.adminservice.bank.bank.cell.CellAge;
import bankingsystem.adminservice.bank.bank.cell.CellEmail;
import bankingsystem.adminservice.bank.bank.cell.CellGender;
import bankingsystem.adminservice.bank.bank.cell.CellName;
import bankingsystem.adminservice.bank.bank.cell.CellTel;
import bankingsystem.adminservice.bank.model.ModelName;
import bankingsystem.adminservice.bank.model.ModelStaff;
import bankingsystem.model.Role;
import bankingsystem.model.User;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;

public class Form_2 extends javax.swing.JPanel {
    private AdminServiceHandle adminServiceHandle;
    public Form_2() {
        this.adminServiceHandle = new AdminServiceHandle();
        initComponents();
        setOpaque(false);
        table1.addTableStyle(jScrollPane1);
        init();
        initDataTable();
        
    }

    private void init() {
        // Điều chỉnh màu sao cho phù hợp với nền RoundPanel
        chart.addLegend("TRUNG", new Color(102, 153, 204), new Color(134, 168, 231)); // Màu xanh nhạt
        chart.addLegend("NAM", new Color(178, 102, 204), new Color(204, 153, 230)); // Màu tím nhẹ
        chart.addLegend("BAC", new Color(102, 204, 153), new Color(134, 219, 174)); // Màu xanh lá nhạt

        // Thêm dữ liệu biểu đồ (các số liệu giữ nguyên)
        chart.addData(new ModelChart("BIDV", new double[]{500, 200, 80, 89}));
        chart.addData(new ModelChart("Vietcom", new double[]{1000, 750, 90, 150}));
        chart.addData(new ModelChart("Agri", new double[]{200, 350, 460, 900}));
        chart.addData(new ModelChart("APT", new double[]{480, 150, 750, 700}));
        chart.addData(new ModelChart("MB", new double[]{350, 540, 300, 150}));

        // Bắt đầu hiển thị biểu đồ
        chart.start();
    }

    private void initDataTable() {
        List<User> users = this.adminServiceHandle.getAllUsers();

        table1.addTableCell(new CellName(), 0);
        table1.addTableCell(new CellGender(), 1);
        table1.addTableCell(new CellAge(), 2);
        table1.addTableCell(new CellEmail(), 3);
        table1.addTableCell(new CellTel(), 4);
        table1.addTableCell(new CellAction(), 5);
        int i = 1;
        for (User user : users) {
            table1.addRow(new ModelStaff(i, new ModelName(user.getName(), "", new ImageIcon("C:/Users/ANH KIET/Documents/NetBeansProjects/BankingSystem/src/bankingsystem/adminservice/bank/icon/p1.jpg"), ""), user.getGender(), user.getAddress(), user.getEmail(), user.getPhoneNumber()), false);  //  ture is animate row
            i +=1;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollBar1 = new javax.swing.JScrollBar();
        panelShadow1 = new bankingsystem.adminservice.bank.swing.PanelShadow();
        chart = new com.raven.chart.CurveChart();
        panelShadow2 = new bankingsystem.adminservice.bank.swing.PanelShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new bankingsystem.adminservice.bank.swing.TableForm2();
        cmdAddNew = new bankingsystem.adminservice.bank.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "Add", "Email", "Tel", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(180);
            table1.getColumnModel().getColumn(1).setPreferredWidth(95);
            table1.getColumnModel().getColumn(2).setPreferredWidth(70);
            table1.getColumnModel().getColumn(3).setPreferredWidth(110);
            table1.getColumnModel().getColumn(4).setPreferredWidth(70);
            table1.getColumnModel().getColumn(5).setMinWidth(75);
            table1.getColumnModel().getColumn(5).setPreferredWidth(75);
            table1.getColumnModel().getColumn(5).setMaxWidth(75);
        }

        cmdAddNew.setText("+ Add New");
        cmdAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(cmdAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(13, 13, 13))))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cmdAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddNewActionPerformed
        table1.insertRowWithEdit(new ModelStaff(0, new ModelName("", "", null, ""), "Male", "asds", "", ""), 0, true);
    }//GEN-LAST:event_cmdAddNewActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.chart.CurveChart chart;
    private bankingsystem.adminservice.bank.swing.Button cmdAddNew;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private bankingsystem.adminservice.bank.swing.PanelShadow panelShadow1;
    private bankingsystem.adminservice.bank.swing.PanelShadow panelShadow2;
    private bankingsystem.adminservice.bank.swing.TableForm2 table1;
    // End of variables declaration//GEN-END:variables
}
