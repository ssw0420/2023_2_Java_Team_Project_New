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
	
	public void NewUser(String name, String diff) throws SQLException{ // 유저 생성 메소드
		String query = "INSERT INTO USERINFO(USERNUMBER, USERNAME, USERLEVEL, USERHIGHSCORE, USERLASTWORD) values (?,?,?,?,?)";
		String idquery = "select * from USERINFO";
		int id = 0;
		int idmax = 0;
		try { DB_Connect();
		Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(idquery);
		PreparedStatement pstmt = con.prepareStatement(query);
		while (rs.next()) {
		id = rs.getInt("USERNUMBER");
		idmax = idmax > id? idmax:id;
		}
		++idmax;
		pstmt.setInt(1, idmax);
		pstmt.setString(2, name);
		pstmt.setString(3, diff);
		pstmt.setInt(4, 0);
		pstmt.setInt(5, 0);
		pstmt.executeUpdate();
		stmt.close(); pstmt.close(); con.close();
		}
		catch (SQLException e){ e.printStackTrace();
		} finally { con.close(); }
		}

}
