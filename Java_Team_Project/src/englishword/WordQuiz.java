package englishword;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnNewButton.setBounds(900, 600, 180, 60);
		add(btnNewButton);
	}
}
