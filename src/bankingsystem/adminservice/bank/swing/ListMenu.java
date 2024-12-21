package bankingsystem.adminservice.bank.swing;

import bankingsystem.adminservice.bank.event.EventMenuSelected;
import bankingsystem.adminservice.bank.model.Model_Menu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListMenu<E extends Object> extends JList<E> {

    private final DefaultListModel<E> model; // Sửa generic cho DefaultListModel
    private int selectedIndex = -1;
    private int hoveredIndex = -1; // Lưu chỉ số mục được hover

    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
    }
    
    public ListMenu() {
        model = new DefaultListModel<>();
        setModel(model);
        
        // Xử lý sự kiện click chuột
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    if (index >= 0 && index < model.getSize()) { // Tránh ngoại lệ ngoài chỉ số
                        Object o = model.getElementAt(index);
                        if (o instanceof Model_Menu) {
                            Model_Menu menu = (Model_Menu) o;
                            if (menu.getType() == Model_Menu.MenuType.MENU) {
                                selectedIndex = index;
                                if (event != null ){
                                    event.selected(index);
                                }
                            }
                        } else {
                            selectedIndex = index;
                        }
                        repaint();
                    }
                }
            }
        });

        // Xử lý sự kiện di chuyển chuột để cập nhật hover
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                int index = locationToIndex(me.getPoint());
                if (index != hoveredIndex) {
                    if (index >= 0 && index < model.getSize()) { // Kiểm tra trong phạm vi hợp lệ
                        hoveredIndex = index;
                    } else {
                        hoveredIndex = -1; // Nếu chuột không nằm trên mục nào
                    }
                    repaint();
                }
            }
        });

        // Reset hover khi chuột rời khỏi danh sách
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                hoveredIndex = -1;
                repaint();
            }
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object o, int index, boolean isSelected, boolean cellHasFocus) {
                Model_Menu data;
                if (o instanceof Model_Menu) {
                    data = (Model_Menu) o;
                } else {
                    data = new Model_Menu("", o + "", Model_Menu.MenuType.EMPTY);
                }

                // Tạo giao diện cho mỗi mục
                MenuiItem item = new MenuiItem(data);
                item.setSelected(selectedIndex == index);
                item.setHover(hoveredIndex == index); // Đặt trạng thái hover cho mục hiện tại
                return item;
            }
        };
    }

    // Thêm item vào danh sách
    public void addItem(Model_Menu data) {
        model.addElement((E) data);
    }

    // Xóa item theo chỉ số
    public void removeItem(int index) {
        if (index >= 0 && index < model.getSize()) {
            model.removeElementAt(index);
        }
    }

    // Xóa toàn bộ danh sách
    public void clearItems() {
        model.clear();
        selectedIndex = -1;
        hoveredIndex = -1;
        repaint();
    }
}
