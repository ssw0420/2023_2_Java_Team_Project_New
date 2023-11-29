package englishword;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreateUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField UserNameField;

	/**
	 * Create the panel.
	 */
//	public CreateUser(JPanel startPage) {
	public CreateUser(MainUI MainFrame) {
		setBackground(new Color(176, 196, 222));
		setBounds(140, 120, 1000, 550);
		setSize(1280, 800); // 화면 크기 설정
		setLayout(null);
		
		JButton createUserButton = new JButton("등 록");
		createUserButton.setBackground(new Color(100, 149, 237));
		createUserButton.setForeground(new Color(240, 255, 255));
		createUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createUserButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		createUserButton.setBounds(955, 600, 130, 50);
		add(createUserButton);
		
		JButton CreateUserCancelButton = new JButton("취 소");
		CreateUserCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				startPage.setVisible(true);
				MainFrame.showPanel("startPage");
			}
		});
		CreateUserCancelButton.setForeground(new Color(0, 0, 0));
		CreateUserCancelButton.setBackground(new Color(255, 255, 255));
		CreateUserCancelButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		CreateUserCancelButton.setBounds(775, 600, 130, 50);
		add(CreateUserCancelButton);
		
		JLabel CreateUserTitle = new JLabel("사용자 등록");
		CreateUserTitle.setHorizontalAlignment(SwingConstants.CENTER);
		CreateUserTitle.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 32));
		CreateUserTitle.setBounds(540, 25, 200, 50);
		add(CreateUserTitle);
		
		JLabel UserNameLabel = new JLabel("이        름  :");
		UserNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UserNameLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		UserNameLabel.setBounds(215, 244, 100, 50);
		add(UserNameLabel);
		
		JLabel UserLevelLabel = new JLabel("목표  수준  :");
		UserLevelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UserLevelLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		UserLevelLabel.setBounds(215, 356, 100, 50);
		add(UserLevelLabel);
		
		UserNameField = new JTextField();
		UserNameField.setForeground(new Color(0, 0, 0));
		UserNameField.setHorizontalAlignment(SwingConstants.CENTER);
		UserNameField.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		UserNameField.setBackground(new Color(255, 255, 255));
		UserNameField.setBounds(332, 244, 220, 50);
		add(UserNameField);
		UserNameField.setColumns(10);
		
		JComboBox UserLevelcomboBox = new JComboBox();
		UserLevelcomboBox.setModel(new DefaultComboBoxModel(new String[] {"초등", "중등/고등", "대학"}));
		UserLevelcomboBox.setForeground(new Color(0, 0, 0));
		UserLevelcomboBox.setBackground(new Color(255, 255, 255));
		UserLevelcomboBox.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		UserLevelcomboBox.setBounds(332, 356, 220, 50);
		add(UserLevelcomboBox);
		
		
		JLabel selectMenuLabel = new JLabel("사용자 정보를 입력하세요");
		selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
		selectMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectMenuLabel.setForeground(new Color(0, 0, 128));
		selectMenuLabel.setBackground(new Color(0, 0, 0));
		selectMenuLabel.setBounds(679, 144, 470, 365);
		add(selectMenuLabel);
	}
}