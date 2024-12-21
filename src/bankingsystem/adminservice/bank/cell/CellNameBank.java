package bankingsystem.adminservice.bank.bank.cell;

import bankingsystem.adminservice.bank.model.ModelNameStaff;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellNameBank extends TableCustomCell {

    public CellNameBank() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cmdSave = new javax.swing.JButton();

        jLabel1.setText("Name");

        cmdSave.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdSave)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addEventSave(TableCustom table) {
        cmdSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                table.stopCellEditing();
                int row = getRow();
                String ID = table.getValueAt(row, 0).toString();
                String name = table.getValueAt(row, 1).toString();
                String branch = table.getValueAt(row, 2).toString();
                String hotline = table.getValueAt(row, 3).toString();
                ModelNameStaff staff = (ModelNameStaff) table.getModelData(row);
                ModelNameStaff data = new ModelNameStaff(ID, name, branch, hotline);
                try {
                    if (ID.equals("0")) {
                        //insert
                        table.updateModelData(row, data);
                    } else {
                        // Logic cập nhật dữ liệu nếu ID != "0"
                        table.updateModelData(row, data);
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        });
    }

    @Override
    public void setData(Object o) {
        txtName.setText(o.toString());
    }

    @Override
    public Object getData() {
        String Name = txtName.getText().trim();
        return Name;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellNameBank cell = new CellNameBank();
        cell.setData(o);
        cell.addEventSave(tc);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
