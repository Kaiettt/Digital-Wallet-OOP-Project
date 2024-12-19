/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem.database.userDB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ANH KIET
 */
public class DatabaseConnection {
    public static Connection initializeDatabaze() {
		String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433";

		String dbName = "Banking";
		String dbUsername = "sa";
		String dbPassword = "YourStrongPassw0rd!";
		String connectionURL = dbURL + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";

		Connection conn = null;

		try {
//			Tải driver lên  ( driver được kết nối tới sql ) - Nạp driver JDBC cho SQL
			Class.forName(dbDriver);
//			Tạo kết nối
			conn = DriverManager.getConnection(connectionURL, dbUsername, dbPassword);
		} catch (Exception ex) {
			System.out.println("Connect failure: " + ex.getMessage());
			ex.printStackTrace();
		}
//		Sau khi khối try thành công thì conn sẽ được trả về thành một đối tượng liên kết đến sql, thao tác trên nó để thao tác với sql
//		Trả về đối tượng đã được lấy 
		return conn;
	}
    public static void main(String[] args) {
        DatabaseConnection test = new DatabaseConnection();
        test.initializeDatabaze();
    }
}
