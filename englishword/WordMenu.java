package englishword;

import userinfoevent.*;
import DB.*;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;


public class WordMenu extends JPanel //implements UserInfoListener
{
//	UserInfoSubscriber subscriber = new UserInfoSubscriber();
//    UserInfoPublisher publisher = new UserInfoPublisher();
	private static final long serialVersionUID = 1L;
	private int selectNumber = 0;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
//	public WordMenu(JPanel startPage, JPanel mainPanel) {
	public WordMenu(MainUI mainUI, WordQuiz wordQuizPage) throws SQLException{
//		this.listModel = listModel;
//		publisher.addUserInfoListener(subscriber);
		UserDBConnection DBConn = new UserDBConnection();
		UserInformation cu = new UserInformation();
		WordListHandler us = new WordListHandler();
//		listModel = MainUI.getListModel();
//		String[] usinfo = new String[listModel.size()];
//      listModel.copyInto(usinfo);
		String[] usinfo = DBConn.BringUserInfo(us.getSelectedWord());
		cu.username = usinfo[0];
		cu.userlevel = usinfo[1];
		cu.userhighscore = Integer.parseInt(usinfo[2]);
		cu.userlastword = Integer.parseInt(usinfo[3]);
		String[] word = null;
		setBackground(new Color(176, 196, 222));
		setBounds(140, 120, 1000, 550);
		setSize(1280, 800); // 화면 크기 설정
		setLayout(null);
		
		UserDetailHead userDetailHead = new UserDetailHead(cu.username, cu.userlevel, cu.userhighscore);
		userDetailHead.setBackground(new Color(230, 230, 250));
		userDetailHead.setLocation(250, 25);
		userDetailHead.setSize(800, 70);
		add(userDetailHead, "userDetailHead");
		userDetailHead.updateUserInfo(cu.username, cu.userlevel, cu.userhighscore);
		
		// swing에서 html 적용 가능
		JLabel selectMenuLabel = new JLabel("좌측의 메뉴를 선택하세요");
		selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
		selectMenuLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectMenuLabel.setForeground(new Color(0, 0, 128));
		selectMenuLabel.setBackground(new Color(0, 0, 0));
		selectMenuLabel.setBounds(600, 175, 470, 365);
		add(selectMenuLabel);
		
		
		JButton wordMemorizeButton = new JButton("영단어 3000 모음");
		JButton wordQuizButton = new JButton("영단어 퀴즈");
		wordMemorizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordMemorizeButton.setBackground(new Color(130, 200, 200));
				wordQuizButton.setBackground(new Color(175, 238, 238));
				selectNumber = 1;
				selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
				selectMenuLabel.setText("<html><body>영단어 3000 모음<br><br>사용자가 선택한 단계에 맞는 영어 단어 모음집을 제공합니다.<br><br>초등(초급)<br>중/고등(중급)<br>대학 이상(고급)<br><br>알파벳 순으로 정렬되어 있으며, 마지막에 확인한 단어부터 실행됩니다.<br>");
			}
		});
		wordMemorizeButton.setForeground(new Color(0, 0, 128));
		wordMemorizeButton.setBackground(new Color(175, 238, 238));
		wordMemorizeButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		wordMemorizeButton.setBounds(70, 175, 320, 125);
		
		wordQuizButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectNumber = 2;
				wordMemorizeButton.setBackground(new Color(175, 238, 238));
				wordQuizButton.setBackground(new Color(130, 200, 200));
				selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
				selectMenuLabel.setText("<html><body>영단어 퀴즈<br><br>사용자가 선택한 단계에 맞는 영어 단어 퀴즈를 제공합니다.<br><br>영어 단어를 보고 화면 상에 띄워진 4개의 뜻 중에서 올바른 것을 선택하세요.<br>문제를 더 빠른 시간에 연속으로 맞출수록 많은 점수가 부여됩니다.<br>5회 오답 시 퀴즈가 종료됩니다.<br>");
			}
		});
		wordQuizButton.setForeground(new Color(0, 0, 128));
		wordQuizButton.setBackground(new Color(175, 238, 238));
		wordQuizButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		wordQuizButton.setBounds(70, 415, 320, 125);
		
		
		add(wordMemorizeButton);
		add(wordQuizButton);
		
		JButton MenuStartButton = new JButton("시 작");
		MenuStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectNumber == 1)
				{
//					setVisible(false);
//					wordQuizPage.setVisible(true);
//					MainFrame.showPanel("engStudyPage", word);
					mainUI.showPanel("startPage", word);
				}
				else if (selectNumber == 2)
				{
//					setVisible(false);
//					wordQuizPage.setVisible(true);
					wordQuizPage.showResultDialog("퀴즈 시작 !", true);
					wordQuizPage.initQuiz();
					wordQuizPage.answerChecked = false;
					String[] user;
					try {
						user = DBConn.BringUserInfo(cu.username);
						mainUI.showPanel("wordQuizPage", user);
						wordQuizPage.startTimer(mainUI);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		MenuStartButton.setForeground(new Color(0, 0, 128));
		MenuStartButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		MenuStartButton.setBackground(new Color(175, 238, 238));
		MenuStartButton.setBounds(700, 600, 225, 60);
		add(MenuStartButton);
		
		JButton btnNewButton = new JButton("사용자 변경");
		btnNewButton.setBounds(1065, 25, 119, 70);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectNumber = 0;
				wordMemorizeButton.setBackground(new Color(175, 238, 238));
				wordQuizButton.setBackground(new Color(175, 238, 238));
				selectMenuLabel.setText("좌측의 메뉴를 선택하세요");
				selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
				selectMenuLabel.setHorizontalAlignment(SwingConstants.LEFT);
				selectMenuLabel.setForeground(new Color(0, 0, 128));
				selectMenuLabel.setBackground(new Color(0, 0, 0));
				selectMenuLabel.setBounds(600, 175, 470, 365);
				String[] list;
				try {
					list = DBConn.BringUser();
					mainUI.showPanel("startPage", list);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		
	}
	public class UserInformation {
		public String username;
		public String userlevel;
		public int userhighscore;
		public int userlastword;
	}

}
