package DB;

import java.sql.*;
import java.util.ArrayList;
// import java.util.Vector;

public class UserDBConnection extends DBConnection{
	public String[] BringUser() throws SQLException{ // 유저 정보 불러오기 메소드
		String query = "select * from USERINFO order by USERNUMBER ASC";
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
	
	public void DeleteUser(String username) throws SQLException{ // 유저 삭제 메소드
		String query = "delete from USERINFO where USERNAME = ?";
		try { DB_Connect();
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, username);
		pstmt.executeUpdate();
		pstmt.close();
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
	
	// 선택한 유저의 정보를 가져오는 메소드
	public String[] BringUserInfo(String name) throws SQLException{ 
		String query = "select * from USERINFO where USERNAME = ?";
		ArrayList<String> userinfo = new ArrayList<>();
		try { DB_Connect();
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
            String username = rs.getString("USERNAME");
            userinfo.add(username);
            String userlevel = rs.getString("USERLEVEL");
            userinfo.add(userlevel);
            String userhighscore = rs.getString("USERHIGHSCORE");
            userinfo.add(userhighscore);
            String userlastword = rs.getString("USERLASTWORD");
            userinfo.add(userlastword);
		}
		pstmt.close(); rs.close();
		}
		catch (SQLException e){ e.printStackTrace();
		} finally { con.close(); }
        //return dataVector;
		String[] userArray = userinfo.toArray(new String[0]);
        return userArray;
		}
	public void EditUser(String name, String editname, String diff) throws SQLException {
		String query = "select USERNUMBER from USERINFO where USERNAME = ?";
		String query1 = "update USERINFO set USERNAME = ?, USERLEVEL = ?, USERHIGHSCORE = 0, USERLASTWORD = 0 where USERNUMBER = ?";
		
		int usernum = 0;
		
		try { DB_Connect();
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			usernum = rs.getInt(1);
		}
		PreparedStatement pstmt1 = con.prepareStatement(query1);
		pstmt1.setString(1, editname);
		pstmt1.setString(2, diff);
		pstmt1.setInt(3, usernum);
		pstmt1.executeUpdate();
		pstmt.close(); pstmt1.close();
		} catch(SQLException e) { e.printStackTrace();
		} finally { con.close(); }
	}
}

