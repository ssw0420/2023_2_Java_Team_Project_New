package englishword;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class UserDetailHead extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
//	public UserDetailHead(JPanel startPage, String userName, String userLevel, int userHighScore) {
	public UserDetailHead(String userName, String userLevel, int userHighScore) {
		setBackground(new Color(201, 171, 137));
		setBounds(140, 30, 1000, 50);
		setSize(1280, 800); // 화면 크기 설정
		setOpaque(false);
		setLayout(null);
		
		JLabel UserNameLabel = new JLabel("사용자 : " + userName);
		UserNameLabel.setForeground(new Color(150, 15, 15));
		UserNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		UserNameLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 28));
		UserNameLabel.setBounds(50, 12, 254, 40);
		add(UserNameLabel);
		
		JLabel UserLevelLabel = new JLabel("단계 : " + userLevel);
		UserLevelLabel.setHorizontalAlignment(SwingConstants.LEFT);
		UserLevelLabel.setForeground(new Color(150, 15, 15));
		UserLevelLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 28));
		UserLevelLabel.setBounds(330, 12, 254, 40);
		add(UserLevelLabel);
		
		JLabel UserLevelLabel_1 = new JLabel("최고 점수 : " + userHighScore);
		UserLevelLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		UserLevelLabel_1.setForeground(new Color(150, 15, 15));
		UserLevelLabel_1.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 28));
		UserLevelLabel_1.setBounds(580, 12, 254, 40);
		add(UserLevelLabel_1);
		
		

	}
}
