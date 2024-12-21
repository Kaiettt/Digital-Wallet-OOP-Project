
package bankingsystem.userservice.userController;

import bankingsystem.database.userDB.DBConnection;
import bankingsystem.model.Loan;
import bankingsystem.model.SavingAccount;
import bankingsystem.userservice.userUI.featuregroup.Wallet;
import bankingsystem.userservice.userUI.featuregroup.SavingGoalInsert;
import bankingsystem.userservice.userUI.featuregroup.SavingGoalUpdate;
import bankingsystem.userservice.userUI.featuregroup.ShowSavingGoals;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
public class ShowSavingAccount {
    private Wallet saving;
    private ShowSavingGoals show_shaving_goal;
    private SavingGoalInsert savingGoalInsert;
    private SavingGoalUpdate savingGoalUpdate;
    public ShowSavingAccount(){
 
    }
    
    public  DefaultTableModel showGoal(ShowSavingGoals showSavingGoal) throws SQLException, ClassNotFoundException{
         DefaultTableModel model = null;
    try {
        String[] arr = {"id", "title", "description", "target amount", "end date"};
        model = new DefaultTableModel(arr, 0);

        Connection conn = DBConnection.getConnection();
        String sql = "SELECT id, title, description, target_amount, end_date FROM saving_goals";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            vector.add(rs.getInt("id"));
            vector.add(rs.getString("title"));
            vector.add(rs.getString("description"));
            vector.add(rs.getBigDecimal("target_amount"));
            vector.add(rs.getDate("end_date"));
            model.addRow(vector);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; 
    }
    return model;
    }
    
    
    public void EraseGoal(int data ) throws ClassNotFoundException{

            try {
                Connection conn = DBConnection.getConnection();

                String sql = " DELETE FROM saving_goals where id = ?";
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setInt(1, data);
                pstm.executeUpdate();

                JOptionPane.showMessageDialog(null, "đã xóa thành công");
                
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

