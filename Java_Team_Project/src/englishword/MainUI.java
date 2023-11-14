package englishword;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel startPage = new JPanel();
		startPage.setBackground(new Color(211, 211, 211));
		startPage.setBounds(140, 120, 1000, 550);
		contentPane.add(startPage);
		startPage.setLayout(null);
		
		JPanel createUserPage = new JPanel();
		createUserPage.setBackground(new Color(211, 211, 211));
		createUserPage.setBounds(140, 120, 1000, 550);
		
		contentPane.add(createUserPage);
		
		
		JButton createButton = new JButton("생 성");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUserPage.setVisible(true);
				startPage.setVisible(false);
			}
		});
		createButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		createButton.setBounds(800, 100, 130, 70);
		startPage.add(createButton);
		
		JButton updateButton = new JButton("수 정");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		updateButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		updateButton.setBounds(800, 250, 130, 70);
		startPage.add(updateButton);
		
		JButton deleteButton = new JButton("삭 제");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		deleteButton.setBounds(800, 400, 130, 70);
		startPage.add(deleteButton);
		
		JLabel mainName = new JLabel("영어 단어 학습");
		mainName.setHorizontalAlignment(SwingConstants.CENTER);
		mainName.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
		mainName.setBounds(450, 22, 393, 72);
		contentPane.add(mainName);
		
		
		createUserPage.setVisible(false);
//		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
