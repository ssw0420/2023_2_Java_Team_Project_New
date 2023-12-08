package DB;

import java.sql.*;


public class DBConnection {
	Connection con = null;
	String url = "jdbc:oracle:thin:@localhost:1521:XE"; String id = "VOCA"; String password = "1234";
	public DBConnection() {
		try { Class.forName("oracle.jdbc.driver.OracleDriver");
//		System.out.println("드라이버 적재 성공");
		} catch (ClassNotFoundException e) { System.out.println("No Driver."); }
		}
	public void DB_Connect() {
		try { con = DriverManager.getConnection(url, id, password);
//		System.out.println("DB 연결 성공");
		} catch (SQLException e) { System.out.println("Connection Fail"); }
		}
	public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}