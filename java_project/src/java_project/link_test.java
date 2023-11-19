package java_project;

import DB.*;
// import java.util.Vector;
import java.sql.SQLException;

public class link_test {

	public static void main(String[] args) {
		// Vector<String> dataVector = new Vector<>();
		String name[]=null;
		DBConnection dbconquery = new DBConnection();
		dbconquery.DB_Connect(); // DB 연결 테스트
		
		UserDBConnection UserConn = new UserDBConnection();
		try {
			name = UserConn.BringUser(); // 유저 정보 받아오기 테스트
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i=0;i<name.length;i++)
			System.out.println(name[i]);
	}

}
