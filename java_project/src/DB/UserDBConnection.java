package DB;

import java.sql.*;
import java.util.ArrayList;
// import java.util.Vector;

public class UserDBConnection extends DBConnection{
	public String[] BringUser() throws SQLException{ // 유저 정보 불러오기 메소드
		String query = "select * from USERINFO";
		ArrayList<String> nameList = new ArrayList<>();
		// Vector<String> dataVector = new Vector<>();
		try { DB_Connect();
		Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			//String columnName = "USERNAME";
            String name = rs.getString("USERNAME");
            nameList.add(name);
            //dataVector.add(data);
		}
		stmt.close(); rs.close();
		}
		catch (SQLException e){ e.printStackTrace();
		} finally { con.close(); }
        //return dataVector;
		String[] nameArray = nameList.toArray(new String[0]);
        return nameArray;
		}
	
	public void DeleteUser() throws SQLException{ // 유저 삭제 메소드
		String query = "delete from USERINFO where USERNAME IS ?";
		try { DB_Connect();
		Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
		// 명령 입력
		}
		stmt.close(); rs.close();
		}
		catch (SQLException e){ e.printStackTrace();
		} finally { con.close(); }
		}

}
