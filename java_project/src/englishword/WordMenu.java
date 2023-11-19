package englishword;


import DB.*;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WordMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private int selectNumber = 0;

	/**
	 * Create the panel.
	 */
	public WordMenu(JPanel startPage) {
		setBackground(new Color(211, 211, 211));
		setBounds(140, 120, 1000, 550);
		setLayout(null);
		
		// swing에서 html 적용 가능
		JLabel selectMenuLabel = new JLabel("");
		selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		selectMenuLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectMenuLabel.setForeground(new Color(0, 0, 128));
		selectMenuLabel.setBackground(new Color(230, 230, 250));
		selectMenuLabel.setBounds(480, 50, 470, 415);
		add(selectMenuLabel);
		
		
		JButton wordMemorizeButton = new JButton("영단어 3000 모음");
		wordMemorizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectNumber = 1;
				selectMenuLabel.setText("<html><body>영단어 3000 모음<br><br>사용자가 선택한 단계에 맞는 영어 단어 모음집을 제공합니다.<br><br>초등(초급)<br>중/고등(중급)<br>대학 이상(고급)<br><br>알파벳 순으로 정렬되어 있으며, 마지막에 확인한 단어부터 실행됩니다.<br>");
			}
		});
		wordMemorizeButton.setForeground(new Color(0, 0, 128));
		wordMemorizeButton.setBackground(new Color(175, 238, 238));
		wordMemorizeButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		wordMemorizeButton.setBounds(60, 95, 320, 125);
		add(wordMemorizeButton);
		
		JButton wordQuizButton = new JButton("영단어 퀴즈");
		wordQuizButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectNumber = 2;
				selectMenuLabel.setText("<html><body>영단어 퀴즈<br><br>사용자가 선택한 단계에 맞는 영어 단어 퀴즈를 제공합니다.<br><br>영어 단어를 보고 화면 상에 띄워진 4개의 뜻 중에서 올바른 것을 선택하세요.<br>문제를 더 빠른 시간에 연속으로 맞출수록 많은 점수가 부여됩니다.<br>5회 오답 시 퀴즈가 종료됩니다.<br>");
			}
		});
		wordQuizButton.setForeground(new Color(0, 0, 128));
		wordQuizButton.setBackground(new Color(175, 238, 238));
		wordQuizButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		wordQuizButton.setBounds(60, 335, 320, 125);
		add(wordQuizButton);
		
		JButton MenuStartButton = new JButton("시 작");
		MenuStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectNumber == 1)
				{
					
				}
				else if (selectNumber == 2)
				{
					
				}
			}
		});
		MenuStartButton.setForeground(new Color(0, 0, 0));
		MenuStartButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		MenuStartButton.setBackground(new Color(175, 238, 238));
		MenuStartButton.setBounds(600, 475, 225, 60);
		add(MenuStartButton);
		
	}
}
