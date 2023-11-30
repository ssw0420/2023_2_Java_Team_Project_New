package englishword;

import java.awt.Color;
import englishword.MainUI;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class WordMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private int selectNumber = 0;

	/**
	 * Create the panel.
	 */
//	public WordMenu(JPanel startPage, JPanel mainPanel) {
	public WordMenu(MainUI MainFrame, WordQuiz wordQuizPage) {
		setBackground(new Color(176, 196, 222));
		setBounds(140, 120, 1000, 550);
		setSize(1280, 800); // 화면 크기 설정
		setLayout(null);
		
		UserDetailHead userDetailHead = new UserDetailHead("신승우", "고급", 2100);
		userDetailHead.setBackground(new Color(230, 230, 230));
		userDetailHead.setLocation(250, 25);
		userDetailHead.setSize(800, 70);
		add(userDetailHead, "userDetailHead");
		
		// swing에서 html 적용 가능
		JLabel selectMenuLabel = new JLabel("좌측의 메뉴를 선택하세요");
		selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
		selectMenuLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectMenuLabel.setForeground(new Color(0, 0, 0));
		selectMenuLabel.setBackground(new Color(0, 0, 0));
		selectMenuLabel.setBounds(600, 175, 470, 365);
		add(selectMenuLabel);
		
		
		JButton wordMemorizeButton = new JButton(new ImageIcon("resource/icons/vocabulary_100.png"));
		JButton wordQuizButton = new JButton(new ImageIcon("resource/icons/quiz_100.png"));
		wordMemorizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordMemorizeButton.setBackground(new Color(100, 100, 100));
				wordMemorizeButton.setForeground(new Color(100, 100, 100));
				wordQuizButton.setForeground(new Color(0, 0, 0));
				wordQuizButton.setBackground(new Color(0, 0, 0));
				selectNumber = 1;
				selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
				selectMenuLabel.setText("<html><body>영단어 3000 모음<br><br>사용자가 선택한 단계에 맞는 영어 단어 모음집을 제공합니다.<br><br>초등(초급)<br>중/고등(중급)<br>대학 이상(고급)<br><br>알파벳 순으로 정렬되어 있으며, 마지막에 확인한 단어부터 실행됩니다.<br>");
			}
		});
		wordMemorizeButton.setHorizontalAlignment(SwingConstants.LEFT);
		wordMemorizeButton.setVerticalAlignment(JButton.CENTER);
		wordMemorizeButton.setContentAreaFilled(false);
		wordMemorizeButton.setOpaque(false);
		wordMemorizeButton.setBorder(null);
		wordMemorizeButton.setText("  영단어 3000");
		wordMemorizeButton.setForeground(new Color(0, 0, 0));
		wordMemorizeButton.setBackground(new Color(0, 0, 0));
		wordMemorizeButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		wordMemorizeButton.setBounds(70, 175, 400, 100);
		
		wordQuizButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectNumber = 2;
				wordMemorizeButton.setBackground(new Color(0, 0, 0));
				wordQuizButton.setBackground(new Color(100, 100, 100));
				wordQuizButton.setForeground(new Color(100, 100, 100));
				wordMemorizeButton.setForeground(new Color(0, 0, 0));
				selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
				selectMenuLabel.setText("<html><body>영단어 퀴즈<br><br>사용자가 선택한 단계에 맞는 영어 단어 퀴즈를 제공합니다.<br><br>영어 단어를 보고 화면 상에 띄워진 4개의 뜻 중에서 올바른 것을 선택하세요.<br>문제를 더 빠른 시간에 연속으로 맞출수록 많은 점수가 부여됩니다.<br><br>5회 오답 시 퀴즈가 종료됩니다.<br>");
			}
		});
		wordQuizButton.setHorizontalAlignment(SwingConstants.LEFT);
		wordQuizButton.setVerticalAlignment(JButton.CENTER);
		wordQuizButton.setContentAreaFilled(false);
		wordQuizButton.setOpaque(false);
		wordQuizButton.setBorder(null);
		wordQuizButton.setText("   영단어 퀴즈");
		wordQuizButton.setForeground(new Color(0, 0, 0));
		wordQuizButton.setBackground(new Color(0, 0, 0));
		wordQuizButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		wordQuizButton.setBounds(70, 415, 400, 100);
		
		
		add(wordMemorizeButton);
		add(wordQuizButton);
		
		JButton MenuStartButton = new JButton(new ImageIcon("resource/icons/start_200.png"));
		MenuStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectNumber == 1)
				{
//					setVisible(false);
//					wordQuizPage.setVisible(true);
					MainFrame.showPanel("startPage");
				}
				else if (selectNumber == 2)
				{
//					setVisible(false);
//					wordQuizPage.setVisible(true);
					wordQuizPage.showResultDialog("퀴즈 시작 !", true);
					wordQuizPage.initQuiz();
					wordQuizPage.answerChecked = false;
					MainFrame.showPanel("wordQuizPage");
					wordQuizPage.startTimer(MainFrame);
				}
			}
		});
		MenuStartButton.setBackground(new Color(255, 255, 255));
		MenuStartButton.setHorizontalAlignment(JButton.CENTER);
		MenuStartButton.setVerticalAlignment(JButton.CENTER);
		MenuStartButton.setContentAreaFilled(false);
		MenuStartButton.setOpaque(false);
		MenuStartButton.setBorder(null);
		MenuStartButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		MenuStartButton.setBounds(700, 550, 200, 150);
		add(MenuStartButton);
		
		JButton UserHomeButton = new JButton(new ImageIcon("resource/icons/home_100.png"));
		UserHomeButton.setBounds(1065, 25, 100, 100);
		UserHomeButton.setHorizontalAlignment(JButton.CENTER);
		UserHomeButton.setVerticalAlignment(JButton.CENTER);
		UserHomeButton.setContentAreaFilled(false);
		UserHomeButton.setOpaque(false);
		UserHomeButton.setBorder(null);
		add(UserHomeButton);
		UserHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectNumber = 0;
				wordMemorizeButton.setBackground(new Color(255, 255, 255));
				wordQuizButton.setBackground(new Color(255, 255, 255));
				wordMemorizeButton.setForeground(new Color(0, 0, 0));
				wordQuizButton.setForeground(new Color(0, 0, 0));
				selectMenuLabel.setText("좌측의 메뉴를 선택하세요");
				selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
				selectMenuLabel.setHorizontalAlignment(SwingConstants.LEFT);
				selectMenuLabel.setForeground(new Color(0, 0, 0));
				selectMenuLabel.setBackground(new Color(0, 0, 0));
				selectMenuLabel.setBounds(600, 175, 470, 365);
				MainFrame.showPanel("startPage");
			}
		});
		UserHomeButton.setBackground(new Color(255, 255, 255));
		UserHomeButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		
	}
}
