package englishword;

import java.awt.EventQueue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.tools.javac.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class MainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private CardLayout cardLayout;
	
	/**
	 * Launch the application.
	 */

	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// 생성자에는 모든 값을 0이나 공백으로 주고 보여줄때 setVisible 직전에 값을 받아오는 함수를 써서 다시 전달하면 된다고 생각함

	/**
	 * Create the frame.
	 */

	public MainUI() {	
		setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 15));
		setTitle("영단어 학습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 800); // 화면 크기 설정
		setLocationRelativeTo(null); // 화면을 중앙에 표시
		setResizable(false); // 화면 크기 설정 불가
		
		// 화면 이동을 위한 설정
		cardLayout = new CardLayout();
		
		mainPanel = new JPanel(cardLayout);
		mainPanel.setForeground(new Color(0, 0, 0));
		mainPanel.setBackground(new Color(230, 230, 250));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
//		mainPanel.setLayout(null);
		
		ImageIcon background;
		background = new ImageIcon("resource/background/Main_Background.png");
		
		// 시작 페이지 화면
		JPanel startPage = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
//		startPage.setBackground(new Color(176, 196, 222));
//		startPage.setBounds(140, 120, 1000, 550);
		mainPanel.add(startPage, "startPage");
		startPage.setLayout(null);
		
		// 유저 생성 화면
//		CreateUser createUserPage = new CreateUser(startPage);
		CreateUser createUserPage = new CreateUser(this);
		mainPanel.add(createUserPage, "createUserPage");
		createUserPage.setVisible(false);
		
		// 단어 퀴즈 화면
		WordQuiz wordQuizPage = new WordQuiz(this);
		mainPanel.add(wordQuizPage, "wordQuizPage");
		wordQuizPage.setVisible(false);
		
		// 메인 화면
		WordMenu wordMenuPage = new WordMenu(this, wordQuizPage);
		mainPanel.add(wordMenuPage, "wordMenuPage");
		wordMenuPage.setVisible(false);	
		

	
		
		// 메인 화면 상단 유저 정보
//		UserDetailHead userDetailHead = new UserDetailHead("신승우", "고급", 2100);
//		userDetailHead.setLocation(250, 25);
//		userDetailHead.setSize(800, 70);
//		mainPanel.add(userDetailHead, "userDetailHead");
//		userDetailHead.setVisible(false);
		
		// 시작 페이지 상단 제목
		JLabel mainName = new JLabel("영어 단어 학습");
		mainName.setHorizontalAlignment(SwingConstants.CENTER);
		mainName.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
		mainName.setBounds(500, 51, 300, 72);
		startPage.add(mainName);

		
		
		// 유저 생성 버튼
		JButton createButton = new JButton(new ImageIcon("resource/icons/add_100.png"));
		createButton.setBackground(new Color(255, 255, 255));
		createButton.setHorizontalAlignment(JButton.CENTER);
		createButton.setVerticalAlignment(JButton.CENTER);
		createButton.setContentAreaFilled(false);
		createButton.setOpaque(false);
		createButton.setBorder(null);
		// createButton.setBorderPainted(false);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				createUserPage.setVisible(true);
//				startPage.setVisible(false);
				showPanel("createUserPage");
			}
		});
		createButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		createButton.setBounds(1057, 112, 100, 100);
		startPage.add(createButton);

		// 유저 수정 버튼
		JButton updateButton = new JButton(new ImageIcon("resource/icons/edit_100.png"));
		updateButton.setBackground(new Color(255, 255, 255));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		updateButton.setHorizontalAlignment(JButton.CENTER);
		updateButton.setVerticalAlignment(JButton.CENTER);
		updateButton.setContentAreaFilled(false);
		updateButton.setOpaque(false);
		updateButton.setBorder(null);
		// updateButton.setBorderPainted(false);
		updateButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		updateButton.setBounds(1057, 324, 100, 100);
		startPage.add(updateButton);
		
		// 유저 삭제 버튼
		JButton deleteButton = new JButton(new ImageIcon("resource/icons/delete_100.png"));
		deleteButton.setBackground(new Color(255, 255, 255));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteButton.setHorizontalAlignment(JButton.CENTER);
		deleteButton.setVerticalAlignment(JButton.CENTER);
		deleteButton.setContentAreaFilled(false);
		deleteButton.setOpaque(false);
		deleteButton.setBorder(null);
		// deleteButton.setBorderPainted(false);
		deleteButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		deleteButton.setBounds(1057, 536, 100, 100);
		startPage.add(deleteButton);
		
		// 미구현 - 유저 목록
		JPanel UserListPanel = new JPanel();
		// 색 변경
		UserListPanel.setBackground(new Color(250, 220, 180));
		UserListPanel.setBounds(259, 145, 741, 420);
		startPage.add(UserListPanel);
		UserListPanel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(307, 5, 0, 0);
		UserListPanel.add(list);
		
		// 메인 화면 버튼
		JButton startButton = new JButton(new ImageIcon("resource/icons/start_200.png"));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				userDetailHead.setVisible(true);
//				wordMenuPage.setVisible(true);
//				mainName.setVisible(false);
////				startPage.setVisible(false);
//				userDetailHead.setVisible(true);
				showPanel("wordMenuPage");
//				userDetailHead.setVisible(true);
			}
		});
		startButton.setHorizontalAlignment(JButton.CENTER);
		startButton.setVerticalAlignment(JButton.CENTER);
		startButton.setContentAreaFilled(false);
		startButton.setOpaque(false);
		startButton.setBorder(null);
		// startButton.setBorderPainted(false);
		startButton.setBackground(new Color(255, 255, 255));
		startButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		startButton.setBounds(540, 575, 200, 150);
		startPage.add(startButton);
		
		JLabel addLabel = new JLabel("추가");
		addLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		addLabel.setBounds(1057, 212, 100, 30);
		startPage.add(addLabel);
		
		JLabel editLabel = new JLabel("수정");
		editLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		editLabel.setBounds(1057, 424, 100, 30);
		startPage.add(editLabel);
		
		JLabel deleteLabel = new JLabel("삭제");
		deleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deleteLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		deleteLabel.setBounds(1057, 636, 100, 30);
		startPage.add(deleteLabel);
		
		
	}
	
	public void showPanel(String panelName) {
		cardLayout.show(mainPanel, panelName);
	}
}
