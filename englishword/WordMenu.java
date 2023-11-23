package englishword;

import java.awt.Color;
import englishword.MainUI;
import javax.swing.JPanel;
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
	public WordMenu(MainUI MainFrame) {
		String[] none = null;
		setBackground(new Color(176, 196, 222));
		setBounds(140, 120, 1000, 550);
		setSize(1280, 800); // 화면 크기 설정
		setLayout(null);
		
		UserDetailHead userDetailHead = new UserDetailHead("신승우", "고급", 2100);
		userDetailHead.setBackground(new Color(230, 230, 250));
		userDetailHead.setLocation(250, 25);
		userDetailHead.setSize(800, 70);
		add(userDetailHead, "userDetailHead");
		
		// swing에서 html 적용 가능
		JLabel selectMenuLabel = new JLabel("좌측의 메뉴를 선택하세요");
		selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
		selectMenuLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectMenuLabel.setForeground(new Color(0, 0, 128));
		selectMenuLabel.setBackground(new Color(0, 0, 0));
		selectMenuLabel.setBounds(600, 175, 470, 365);
		add(selectMenuLabel);
		
		
		JButton wordMemorizeButton = new JButton("영단어 3000 모음");
		wordMemorizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectNumber = 1;
				selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
				selectMenuLabel.setText("<html><body>영단어 3000 모음<br><br>사용자가 선택한 단계에 맞는 영어 단어 모음집을 제공합니다.<br><br>초등(초급)<br>중/고등(중급)<br>대학 이상(고급)<br><br>알파벳 순으로 정렬되어 있으며, 마지막에 확인한 단어부터 실행됩니다.<br>");
			}
		});
		wordMemorizeButton.setForeground(new Color(0, 0, 128));
		wordMemorizeButton.setBackground(new Color(175, 238, 238));
		wordMemorizeButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		wordMemorizeButton.setBounds(70, 175, 320, 125);
		add(wordMemorizeButton);
		
		JButton wordQuizButton = new JButton("영단어 퀴즈");
		wordQuizButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectNumber = 2;
				selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
				selectMenuLabel.setText("<html><body>영단어 퀴즈<br><br>사용자가 선택한 단계에 맞는 영어 단어 퀴즈를 제공합니다.<br><br>영어 단어를 보고 화면 상에 띄워진 4개의 뜻 중에서 올바른 것을 선택하세요.<br>문제를 더 빠른 시간에 연속으로 맞출수록 많은 점수가 부여됩니다.<br>5회 오답 시 퀴즈가 종료됩니다.<br>");
			}
		});
		wordQuizButton.setForeground(new Color(0, 0, 128));
		wordQuizButton.setBackground(new Color(175, 238, 238));
		wordQuizButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		wordQuizButton.setBounds(70, 415, 320, 125);
		add(wordQuizButton);
		
		JButton MenuStartButton = new JButton("시 작");
		MenuStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectNumber == 1)
				{
//					setVisible(false);
//					wordQuizPage.setVisible(true);
					MainFrame.showPanel("startPage", null);
				}
				else if (selectNumber == 2)
				{
//					setVisible(false);
//					wordQuizPage.setVisible(true);
					MainFrame.showPanel("wordQuizPage", null);
				}
			}
		});
		MenuStartButton.setForeground(new Color(0, 0, 0));
		MenuStartButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		MenuStartButton.setBackground(new Color(175, 238, 238));
		MenuStartButton.setBounds(725, 600, 225, 60);
		add(MenuStartButton);
		
	}
}
