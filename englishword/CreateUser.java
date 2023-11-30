package englishword;

import DB.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CreateUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField UserNameField;

	/**
	 * Create the panel.
	 */
//	public CreateUser(JPanel startPage) {
	public CreateUser(ActionListener actionListener) {
		UserDBConnection DBConn = new UserDBConnection();
		DBConn.DB_Connect();
		makeUser mu = new makeUser();
		setBackground(new Color(176, 196, 222));
		setBounds(140, 120, 1000, 550);
		setSize(1280, 800); // 화면 크기 설정
		setLayout(null);
		
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
		
		JComboBox<String> UserLevelcomboBox = new JComboBox<>();
		UserLevelcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"초등", "중등/고등", "대학"}));
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
		
		
		JButton createUserButton = new JButton("등 록");
		createUserButton.setBackground(new Color(100, 149, 237));
		createUserButton.setForeground(new Color(240, 255, 255));
		createUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mu.name = UserNameField.getText();
					mu.diff = UserLevelcomboBox.getSelectedItem().toString();
					if ((mu.name != null && !mu.name.trim().isEmpty())&&(mu.diff != null && !mu.diff.trim().isEmpty())) {
						DBConn.NewUser(mu.name, mu.diff);
						String[] list = DBConn.BringUser();
						JOptionPane.showMessageDialog(null, "유저가 생성되었습니다.", "유저 생성", JOptionPane.WARNING_MESSAGE);
//						((MainUI).actionListener).showPanel("startPage", list);
					} else {
					    // 사용자에게 유효한 값을 입력하라는 메시지를 표시하거나 다른 처리 수행
					    JOptionPane.showMessageDialog(null, "Please enter a valid value.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
				String[] list;
				try {
					list = DBConn.BringUser();
//					actionListener.showPanel("startPage", list);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		CreateUserCancelButton.setForeground(new Color(0, 0, 0));
		CreateUserCancelButton.setBackground(new Color(255, 255, 255));
		CreateUserCancelButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		CreateUserCancelButton.setBounds(775, 600, 130, 50);
		add(CreateUserCancelButton);
	}
	public class makeUser {
		public String name;
		public String diff;
	}
}
