package englishword;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class UserDetailHead extends JPanel {

	private static final long serialVersionUID = 1L;

	private static JLabel userNameLabel;
    private static JLabel userLevelLabel;
    private static JLabel userHighScoreLabel;
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
		
		userNameLabel = new JLabel("사용자 : " + userName);
		userNameLabel.setForeground(new Color(150, 15, 15));
		userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userNameLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 28));
		userNameLabel.setBounds(50, 12, 254, 40);
		add(userNameLabel);
		
		userLevelLabel = new JLabel("단계 : " + userLevel);
		userLevelLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userLevelLabel.setForeground(new Color(150, 15, 15));
		userLevelLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 28));
		userLevelLabel.setBounds(330, 12, 254, 40);
		add(userLevelLabel);
		
		userHighScoreLabel = new JLabel("최고 점수 : " + userHighScore);
		userHighScoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userHighScoreLabel.setForeground(new Color(150, 15, 15));
		userHighScoreLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 28));
		userHighScoreLabel.setBounds(580, 12, 254, 40);
		add(userHighScoreLabel);
		
//		updateUserInfo(userName, userLevel, userHighScore);

	}
	public static void updateUserInfo(String userName, String userLevel, int userHighScore) {
		userNameLabel.setText("사용자 : " + userName);
		userLevelLabel.setText("단계 : " + userLevel);
		userHighScoreLabel.setText("최고 점수 : " + userHighScore);
		System.out.println("갱신완료");
    }
}
