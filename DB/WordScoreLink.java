package DB;

import java.sql.*;

public class WordScoreLink extends DBConnection{
	
	// 사용자 최고점수랑 현재 점수 비교하여 저장
	public void UpdateScore(String user, int score) throws SQLException{
		String query = "update USERINFO set USERHIGHSCORE = ? where USERNAME = ?";
		String scorequery = "select USERHIGHSCORE from USERINFO where USERNAME = ?";
		// 최고 점수를 현재 유저의 정보에 갱신
		try { DB_Connect();
		PreparedStatement pstmt = con.prepareStatement(scorequery);
		PreparedStatement pstmt1 = con.prepareStatement(query);
		pstmt.setString(1, user);
		int userhighscore = pstmt.executeUpdate();
		int highscore = score > userhighscore? score : userhighscore;
		pstmt1.setInt(1, highscore);
		pstmt1.setString(2, user);
		pstmt1.executeUpdate();
		pstmt.close(); pstmt1.close();
		}
		catch (SQLException e){ e.printStackTrace();
		} finally { con.close(); }
		}
}
