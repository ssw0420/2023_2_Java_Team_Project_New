package englishword;

import DB.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Window.Type;
import java.sql.SQLException;
import java.util.Vector;


public class MainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;

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
	 * @throws SQLException 
	 */
	public MainUI() throws SQLException {
		UserDBConnection DBConn = new UserDBConnection();
		DBConn.DB_Connect();
		Vector<String> dataVector = new Vector<>();
		DefaultListModel model = new DefaultListModel();
		setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 15));
		setTitle("영단어 학습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 800); // 화면 크기 설정
		setLocationRelativeTo(null); // 화면을 중앙에 표시
		setResizable(false); // 화면 크기 설정 불가
		mainPanel = new JPanel();
		mainPanel.setForeground(new Color(0, 0, 0));
		mainPanel.setBackground(new Color(230, 230, 250));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		// 시작 페이지 화면
		JPanel startPage = new JPanel();
		startPage.setBackground(new Color(211, 211, 211));
		startPage.setBounds(140, 120, 1000, 550);
		mainPanel.add(startPage);
		startPage.setLayout(null);
		
		// 유저 생성 화면
		CreateUser createUserPage = new CreateUser(startPage);
		mainPanel.add(createUserPage);
		createUserPage.setVisible(false);
		
		// 메인 화면
		WordMenu wordMenuPage = new WordMenu(startPage);
		mainPanel.add(wordMenuPage);
		wordMenuPage.setVisible(false);
		
		// 메인 화면 상단 유저 정보
		UserDetailHead userDetailHead = new UserDetailHead(startPage, "신승우", "고급", 2100);
		userDetailHead.setLocation(250, 25);
		userDetailHead.setSize(800, 70);
		mainPanel.add(userDetailHead);
		userDetailHead.setVisible(false);
		
		// 시작 페이지 상단 제목
		JLabel mainName = new JLabel("영어 단어 학습");
		mainName.setHorizontalAlignment(SwingConstants.CENTER);
		mainName.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
		mainName.setBounds(450, 22, 393, 72);
		mainPanel.add(mainName);
		
		// 유저 생성 버튼
		JButton createButton = new JButton("생 성");
		createButton.setBackground(new Color(245, 245, 245));
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUserPage.setVisible(true);
				startPage.setVisible(false);
			}
		});
		createButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		createButton.setBounds(800, 100, 130, 70);
		startPage.add(createButton);
		
		// 유저 수정 버튼
		JButton updateButton = new JButton("수 정");
		updateButton.setBackground(new Color(245, 245, 245));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		updateButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		updateButton.setBounds(800, 250, 130, 70);
		startPage.add(updateButton);
		
		// 유저 삭제 버튼
		JButton deleteButton = new JButton("삭 제");
		deleteButton.setBackground(new Color(245, 245, 245));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		deleteButton.setBounds(800, 400, 130, 70);
		startPage.add(deleteButton);
		
		// 미구현 - 유저 목록
		JPanel UserListPanel = new JPanel();
		UserListPanel.setBounds(75, 100, 614, 338);
		startPage.add(UserListPanel);
		UserListPanel.setLayout(null);
		
		DBConn.BringUser();
		model.addElement(dataVector);
		JList list = new JList(model);
		list.setBounds(307, 5, 0, 0);
		UserListPanel.add(list);
		
		// 메인 화면 버튼
		JButton startButton = new JButton("시 작");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userDetailHead.setVisible(true);
				wordMenuPage.setVisible(true);
				mainName.setVisible(false);
				startPage.setVisible(false);
			}
		});
		startButton.setForeground(new Color(255, 255, 255));
		startButton.setBackground(new Color(173, 216, 230));
		startButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		startButton.setBounds(450, 459, 130, 70);
		startPage.add(startButton);
		
	}
}