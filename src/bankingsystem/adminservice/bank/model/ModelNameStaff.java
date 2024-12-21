package bankingsystem.adminservice.bank.model;

import com.raven.table.model.TableRowData;

public class ModelNameStaff extends TableRowData {

    private String ID;
    private String Name;
    private String Branch;
    private String Hotline;

    public ModelNameStaff(String ID, String Name, String Branch, String Hotline) {
        this.ID = ID;
        this.Name = Name;
        this.Branch = Branch;
        this.Hotline = Hotline;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getBranch() {
        return Branch;
    }

    public String getHotline() {
        return Hotline;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setBranch(String Branch) {
        this.Branch = Branch;
    }

    public void setHotline(String Hotline) {
        this.Hotline = Hotline;
    }
    
    @Override
    public Object[] toTableRow() {
        return new Object[]{ID, Name, Branch, Hotline};
    }
}
