package DB;

import java.sql.*;

public class WordScoreLink extends DBConnection{
	private void UpdateScore() throws SQLException{
		String query = "update USERINFO set USERHIGHSCORE = ? where USERNAME is ?";
		// 최고 점수를 현재 유저의 정보에 갱신
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
