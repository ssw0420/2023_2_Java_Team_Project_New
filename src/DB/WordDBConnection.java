package DB;

import java.sql.*;
import java.util.ArrayList;

public class WordDBConnection extends DBConnection{
	
	// 단어 영어표기 불러오기
	public String[] BringWordEng(String name) throws SQLException{
		String query = "select * from EASYLEVELWORD";
		String query1 = "select USERLEVEL from USERINFO where USERNAME = ?";
		ArrayList<String> wordEng = new ArrayList<>();
		String difficulty = null;
		// 단어 선택지에 따라 다르게 넣어야 함
		try { DB_Connect();
		PreparedStatement pstmt = con.prepareStatement(query1);
		pstmt.setString(1, name);
		ResultSet diff = pstmt.executeQuery();
		while(diff.next()) {
			difficulty = diff.getString(1);
		}
		if(difficulty.equals("초등")) query = "select * from EASYLEVELWORD";
		else if(difficulty.equals("중등/고등")) query = "select * from MEDIUMLEVELWORD";
		else if(difficulty.equals("대학")) query = "select * from EXPERTLEVELWORD";
		Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String we = rs.getString("WORDENG");
			wordEng.add(we);
		}
		pstmt.close(); diff.close(); stmt.close(); rs.close();
		}
		catch (SQLException e){ e.printStackTrace();
		} finally { con.close(); }
		String[] WordEnglish = wordEng.toArray(new String[0]);
		return WordEnglish;
		}
	
	// 단어 뜻 불러오기
	public String[] BringWordKor(String name) throws SQLException{
		String query = "select * from EASYLEVELWORD";
		String query1 = "select USERLEVEL from USERINFO where USERNAME = ?";
		ArrayList<String> wordKor = new ArrayList<>();
		String difficulty = null;
		// 단어 선택지에 따라 다르게 넣어야 함
		try { DB_Connect();
		PreparedStatement pstmt = con.prepareStatement(query1);
		pstmt.setString(1, name);
		ResultSet diff = pstmt.executeQuery();
		while(diff.next()) {
			difficulty = diff.getString(1);
		}
		if(difficulty.equals("초등")) query = "select * from EASYLEVELWORD";
		else if(difficulty.equals("중등/고등")) query = "select * from MEDIUMLEVELWORD";
		else if(difficulty.equals("대학")) query = "select * from EXPERTLEVELWORD";
		Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String wk = rs.getString("WORDKOR");
			wordKor.add(wk);
		}
		pstmt.close(); diff.close(); stmt.close(); rs.close();
		}
		catch (SQLException e){ e.printStackTrace();
		} finally { con.close(); }
		String[] WordKorean = wordKor.toArray(new String[0]);
		return WordKorean;
		}
	
	// 단어 발음기호 불러오기
	public String[] BringWordPronunciation(String name) throws SQLException{
		String query = "select * from EASYLEVELWORD";
		String query1 = "select USERLEVEL from USERINFO where USERNAME = ?";
		ArrayList<String> wordPro = new ArrayList<>();
		String difficulty = null;
		// 단어 선택지에 따라 다르게 넣어야 함
		try { DB_Connect();
		PreparedStatement pstmt = con.prepareStatement(query1);
		pstmt.setString(1, name);
		ResultSet diff = pstmt.executeQuery();
		while(diff.next()) {
			difficulty = diff.getString(1);
		}
		if(difficulty.equals("초등")) query = "select * from EASYLEVELWORD";
		else if(difficulty.equals("중등/고등")) query = "select * from MEDIUMLEVELWORD";
		else if(difficulty.equals("대학")) query = "select * from EXPERTLEVELWORD";
		Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String we = rs.getString("WORDENG");
			wordPro.add(we);
		}
		pstmt.close(); diff.close(); stmt.close(); rs.close();
		}
		catch (SQLException e){ e.printStackTrace();
		} finally { con.close(); }
		String[] WordPronunciation = wordPro.toArray(new String[0]);
		return WordPronunciation;
		}
	
	// 단어 뜻 찾기 - 영어
	public ArrayList<String> SearchWordEng(String name, String searchword) throws SQLException{
		String query = "select * from EASYLEVELWORD";;
		String query1 = "select USERLEVEL from USERINFO where USERNAME = ?";
		ArrayList<String> SearchWordEnglish = new ArrayList<>();
		String difficulty = null;
		// 단어 선택지에 따라 다르게 넣어야 함
		try { DB_Connect();
		PreparedStatement pstmt = con.prepareStatement(query1);
		pstmt.setString(1, name);
		ResultSet diff = pstmt.executeQuery();
		while(diff.next()) {
			difficulty = diff.getString(1);
		}
		if(difficulty.equals("초등")) query = "select * from EASYLEVELWORD where WORDENG Like ?";
		else if(difficulty.equals("중등/고등")) query = "select * from MEDIUMLEVELWORD where WORDENG Like ?";
		else if(difficulty.equals("대학")) query = "select * from EXPERTLEVELWORD where WORDENG Like ?";
		PreparedStatement pstmt2 = con.prepareStatement(query);
		pstmt2.setString(1, difficulty);
		ResultSet rs = pstmt2.executeQuery();
		while (rs.next()) {
			String swe = rs.getString("WORDENG");
			SearchWordEnglish.add(swe);
		}
		pstmt.close(); pstmt2.close(); diff.close(); rs.close();
		}
		catch (SQLException e){ e.printStackTrace();
		} finally { con.close(); }
		return SearchWordEnglish;
		}
	// 단어 뜻 찾기 - 한글
		public ArrayList<String> SearchWordKor(String name, String searchword) throws SQLException{
			String query = "select * from EASYLEVELWORD";;
			String query1 = "select USERLEVEL from USERINFO where USERNAME = ?";
			ArrayList<String> SearchWordKorean = new ArrayList<>();
			String difficulty = null;
			// 단어 선택지에 따라 다르게 넣어야 함
			try { DB_Connect();
			PreparedStatement pstmt = con.prepareStatement(query1);
			pstmt.setString(1, name);
			ResultSet diff = pstmt.executeQuery();
			while(diff.next()) {
				difficulty = diff.getString(1);
			}
			if(difficulty.equals("초등")) query = "select * from EASYLEVELWORD where WORDENG Like ?";
			else if(difficulty.equals("중등/고등")) query = "select * from MEDIUMLEVELWORD where WORDENG Like ?";
			else if(difficulty.equals("대학")) query = "select * from EXPERTLEVELWORD where WORDENG Like ?";
			PreparedStatement pstmt2 = con.prepareStatement(query);
			pstmt2.setString(1, difficulty);
			ResultSet rs = pstmt2.executeQuery();
			while (rs.next()) {
				String swk = rs.getString("WORDKOR");
				SearchWordKorean.add(swk);
			}
			pstmt.close(); pstmt2.close(); diff.close(); rs.close();
			}
			catch (SQLException e){ e.printStackTrace();
			} finally { con.close(); }
			return SearchWordKorean;
			}
		
		// 단어 뜻 찾기 - 발음
				public ArrayList<String> SearchWordPro(String name, String searchword) throws SQLException{
					String query = "select * from EASYLEVELWORD";;
					String query1 = "select USERLEVEL from USERINFO where USERNAME = ?";
					ArrayList<String> SearchWordPronunciation = new ArrayList<>();
					String difficulty = null;
					// 단어 선택지에 따라 다르게 넣어야 함
					try { DB_Connect();
					PreparedStatement pstmt = con.prepareStatement(query1);
					pstmt.setString(1, name);
					ResultSet diff = pstmt.executeQuery();
					while(diff.next()) {
						difficulty = diff.getString(1);
					}
					if(difficulty.equals("초등")) query = "select * from EASYLEVELWORD where WORDENG Like ?";
					else if(difficulty.equals("중등/고등")) query = "select * from MEDIUMLEVELWORD where WORDENG Like ?";
					else if(difficulty.equals("대학")) query = "select * from EXPERTLEVELWORD where WORDENG Like ?";
					PreparedStatement pstmt2 = con.prepareStatement(query);
					pstmt2.setString(1, difficulty);
					ResultSet rs = pstmt2.executeQuery();
					while (rs.next()) {
						String swp = rs.getString("WORDPRONUNCIATION");
						SearchWordPronunciation.add(swp);
					}
					pstmt.close(); pstmt2.close(); diff.close(); rs.close();
					}
					catch (SQLException e){ e.printStackTrace();
					} finally { con.close(); }
					return SearchWordPronunciation;
					}
				
				// 단어 뜻 찾기 - 영어
				public ArrayList<String> SearchMeanEng(String name, String searchword) throws SQLException{
					String query = "select * from EASYLEVELWORD";
					String query1 = "select USERLEVEL from USERINFO where USERNAME = ?";
					ArrayList<String> SearchWordEnglish = new ArrayList<>();
					String difficulty = null;
					// 단어 선택지에 따라 다르게 넣어야 함
					try { DB_Connect();
					PreparedStatement pstmt = con.prepareStatement(query1);
					pstmt.setString(1, name);
					ResultSet diff = pstmt.executeQuery();
					while(diff.next()) {
						difficulty = diff.getString(1);
					}
					if(difficulty.equals("초등")) query = "select * from EASYLEVELWORD where WORDKOR Like ?";
					else if(difficulty.equals("중등/고등")) query = "select * from MEDIUMLEVELWORD where WORDKOR Like ?";
					else if(difficulty.equals("대학")) query = "select * from EXPERTLEVELWORD where WORDKOR Like ?";
					PreparedStatement pstmt2 = con.prepareStatement(query);
					pstmt2.setString(1, difficulty);
					ResultSet rs = pstmt2.executeQuery();
					while (rs.next()) {
						String swe = rs.getString("WORDENG");
						SearchWordEnglish.add(swe);
					}
					pstmt.close(); pstmt2.close(); diff.close(); rs.close();
					}
					catch (SQLException e){ e.printStackTrace();
					} finally { con.close(); }
					return SearchWordEnglish;
					}
				// 단어 뜻 찾기 - 한글
				public ArrayList<String> SearchMeanKor(String name, String searchword) throws SQLException{
					String query = "select * from EASYLEVELWORD";
					String query1 = "select USERLEVEL from USERINFO where USERNAME = ?";
					ArrayList<String> SearchWordEnglish = new ArrayList<>();
					String difficulty = null;
					// 단어 선택지에 따라 다르게 넣어야 함
					try { DB_Connect();
					PreparedStatement pstmt = con.prepareStatement(query1);
					pstmt.setString(1, name);
					ResultSet diff = pstmt.executeQuery();
					while(diff.next()) {
						difficulty = diff.getString(1);
					}
					if(difficulty.equals("초등")) query = "select * from EASYLEVELWORD where WORDKOR Like ?";
					else if(difficulty.equals("중등/고등")) query = "select * from MEDIUMLEVELWORD where WORDKOR Like ?";
					else if(difficulty.equals("대학")) query = "select * from EXPERTLEVELWORD where WORDKOR Like ?";
					PreparedStatement pstmt2 = con.prepareStatement(query);
					pstmt2.setString(1, difficulty);
					ResultSet rs = pstmt2.executeQuery();
					while (rs.next()) {
						String swk = rs.getString("WORDKOR");
						SearchWordEnglish.add(swk);
					}
					pstmt.close(); pstmt2.close(); diff.close(); rs.close();
					}
					catch (SQLException e){ e.printStackTrace();
					} finally { con.close(); }
					return SearchWordEnglish;
					}
					// 단어 뜻 찾기 - 발음
				public ArrayList<String> SearchMeanPro(String name, String searchword) throws SQLException{
					String query = "select * from EASYLEVELWORD";
					String query1 = "select USERLEVEL from USERINFO where USERNAME = ?";
					ArrayList<String> SearchWordEnglish = new ArrayList<>();
					String difficulty = null;
					// 단어 선택지에 따라 다르게 넣어야 함
					try { DB_Connect();
					PreparedStatement pstmt = con.prepareStatement(query1);
					pstmt.setString(1, name);
					ResultSet diff = pstmt.executeQuery();
					while(diff.next()) {
						difficulty = diff.getString(1);
					}
					if(difficulty.equals("초등")) query = "select * from EASYLEVELWORD where WORDKOR Like ?";
					else if(difficulty.equals("중등/고등")) query = "select * from MEDIUMLEVELWORD where WORDKOR Like ?";
					else if(difficulty.equals("대학")) query = "select * from EXPERTLEVELWORD where WORDKOR Like ?";
					PreparedStatement pstmt2 = con.prepareStatement(query);
					pstmt2.setString(1, difficulty);
					ResultSet rs = pstmt2.executeQuery();
					while (rs.next()) {
						String swp = rs.getString("WORDPRONUNCIATION");
						SearchWordEnglish.add(swp);
					}
					pstmt.close(); pstmt2.close(); diff.close(); rs.close();
					}
					catch (SQLException e){ e.printStackTrace();
					} finally { con.close(); }
					return SearchWordEnglish;
					}
				
		// 단어 추가
		public void InsertWord(String user, String word, String mean, String pronunciation) throws SQLException {
			String query = "insert into EASYLEVELWORD values (?,?,?,?)";
			String query1 = "select USERLEVEL from USERINFO where USERNAME = ?";
			String query2 = "select WORDNUMBER from EASYLEVELWORD";
			String difficulty = null;
			int i=0;
			try { DB_Connect();
			PreparedStatement pstmt = con.prepareStatement(query1);
			pstmt.setString(1, user);
			ResultSet diff = pstmt.executeQuery();
			while(diff.next()) {
				difficulty = diff.getString(1);
			}
			if(difficulty.equals("초등")) {
				query = "insert into EASYLEVELWORD values (?,?,?,?)";
				query2 = "select WORDNUMBER from EASYLEVELWORD";
			}
			else if(difficulty.equals("중등/고등")) {
				query = "insert into MEDIUMLEVELWORD values (?,?,?,?)";
				query2 = "select WORDNUMBER from MEDIUMLEVELWORD";
			}
			else if(difficulty.equals("대학")) {
				query = "insert into EXPERTLEVELWORD values (?,?,?,?)";
				query2 = "select WORDNUMBER from EXPERTLEVELWORD";
			}
			PreparedStatement pstmt2 = con.prepareStatement(query);
			Statement stmt = con.createStatement();
			ResultSet wordnum = stmt.executeQuery(query2);
			while(wordnum.next()) {
				int num = wordnum.getInt(1);
				i = i > num? i : num;
			}
			++i;
			pstmt2.setInt(1,i);
			pstmt2.setString(2, word);
			pstmt2.setString(3, mean);
			pstmt2.setString(4, pronunciation);
			pstmt2.executeUpdate();
			pstmt.close(); pstmt2.close(); stmt.close(); diff.close(); wordnum.close();
			} catch(SQLException e) {e.printStackTrace();
			} finally { con.close();
			}
		}
	}
