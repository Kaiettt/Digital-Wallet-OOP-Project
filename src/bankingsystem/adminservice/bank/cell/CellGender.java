package bankingsystem.adminservice.bank.bank.cell;

import bankingsystem.adminservice.bank.model.ModelName;
import bankingsystem.adminservice.bank.model.ModelStaff;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Component;

public class CellGender extends TableCustomCell {
   
    public CellGender() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jrMale = new javax.swing.JRadioButton();
        jrFemale = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(241, 150));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Gender");

        group.add(jrMale);
        jrMale.setForeground(new java.awt.Color(204, 204, 204));
        jrMale.setSelected(true);
        jrMale.setText("Male");

        group.add(jrFemale);
        jrFemale.setForeground(new java.awt.Color(204, 204, 204));
        jrFemale.setText("Female");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jrMale)
                .addGap(0, 0, 0)
                .addComponent(jrFemale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrMale)
                    .addComponent(jrFemale))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {
        if (o.toString().equals("Male")) {
            jrMale.setSelected(true);
        } else {
            jrFemale.setSelected(true);
        }
    }

    @Override
    public Object getData() {
        return jrMale.isSelected() ? "Male" : "Female";
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellGender cell = new CellGender();
        cell.setData(o);
        return cell;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jrFemale;
    private javax.swing.JRadioButton jrMale;
    // End of variables declaration//GEN-END:variables
}
