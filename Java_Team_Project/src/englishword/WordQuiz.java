package englishword;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class WordQuiz extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public WordQuiz(MainUI MainFrame) {
		setBackground(new Color(176, 196, 222));
		setBounds(140, 120, 1000, 550);
		setSize(1280, 800); // 화면 크기 설정
		setLayout(null);
		
		UserDetailHead userDetailHead = new UserDetailHead("신승우", "고급", 2100);
		userDetailHead.setBackground(new Color(230, 230, 250));
		userDetailHead.setLocation(250, 25);
		userDetailHead.setSize(800, 70);
		add(userDetailHead, "userDetailHead");
		
		JButton btnNewButton = new JButton("나가기");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				wordMenuPage.setVisible(true);
				MainFrame.showPanel("wordMenuPage");
			}
		});
		btnNewButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		btnNewButton.setBounds(1000, 664, 180, 60);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(102, 158, 358, 159);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(543, 158, 358, 159);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(102, 412, 358, 159);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(543, 412, 358, 159);
		add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("남은 시간 :");
		lblNewLabel.setBounds(1000, 158, 209, 70);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("현재 점수 :");
		lblNewLabel_1.setBounds(1000, 267, 209, 70);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("라이프 :");
		lblNewLabel_1_1.setBounds(1000, 371, 209, 70);
		add(lblNewLabel_1_1);
	}
}
