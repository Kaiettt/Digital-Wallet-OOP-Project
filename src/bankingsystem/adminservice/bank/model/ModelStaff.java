
package bankingsystem.adminservice.bank.model;

import com.raven.table.model.TableRowData;

public class ModelStaff extends TableRowData {
    
    
    public int getStaffID() {
        return staffID;
    }

    public ModelName getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setName(ModelName name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ModelStaff(int staffID, ModelName name, String gender, String age, String email, String phoneNumber) {
        this.staffID = staffID;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    
    private int staffID;
    private ModelName name;
    private String gender;
    private String age;
    private String email;
    private String phoneNumber;
    
    @Override
    public Object[] toTableRow() {
        return new Object[]{name, gender, age, email, phoneNumber};
    }
}
