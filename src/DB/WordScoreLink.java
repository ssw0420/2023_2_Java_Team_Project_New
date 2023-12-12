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
		int highestscore = 0;
		pstmt.setString(1, user);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int highscore = rs.getInt(1);
			highestscore = score > highscore? score : highscore;
		}
		pstmt1.setInt(1, highestscore);
		pstmt1.setString(2, user);
		pstmt1.executeUpdate();
		pstmt.close(); pstmt1.close();
		}
		catch (SQLException e){ e.printStackTrace();
		} finally { con.close(); }
		}
}
