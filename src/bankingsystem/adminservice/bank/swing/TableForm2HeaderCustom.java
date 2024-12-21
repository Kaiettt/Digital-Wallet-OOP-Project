
package bankingsystem.adminservice.bank.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.table.DefaultTableCellRenderer;


public class TableForm2HeaderCustom extends DefaultTableCellRenderer {
    public TableForm2HeaderCustom(){
        setPreferredSize(new Dimension(0,35));
        setBackground(new Color(109, 213, 250));
        setForeground(new Color(60,60,60));
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); 
        grphcs.setColor(new Color(100, 100, 100));
        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
    
    
}
