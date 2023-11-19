package DB;

import java.sql.*;

public class WordDBConnection extends DBConnection{
	private void BringWord() throws SQLException{
		String query = "select WORDNUMBER, WORDENG, WORDKOR, WORDPRONUNCIATION from ?";
		// 단어 선택지에 따라 다르게 넣어야 함
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
