package bankingsystem.adminservice.bank.swing;

import bankingsystem.adminservice.bank.swing.scrollbar.ScrollBar;
import com.raven.table.TableCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableCellRenderer;

public class TableForm2 extends TableCustom {

    public TableForm2() {

    }
    
    
    public void addTableStyle(JScrollPane scroll) {
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        setBorder(null);
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());
        JPanel panel = new JPanel();
        setForeground(new Color(50,50,50));
        setSelectionForeground(new Color(214, 214, 214));
        setSelectionBackground(new Color(200, 255, 255));
        getTableHeader().setDefaultRenderer(new TableForm2HeaderCustom()    );
        setRowHeight(40);
        setShowHorizontalLines(true);
        setGridColor(new Color(50, 50, 50));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
    }
    
    @Override
    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {
        Component com = super.prepareRenderer(tcr, i, i1);
        if (!isCellSelected(i, i1)) {
            com.setBackground(new Color(255, 255, 255));
        }
        return com;
    }
}
