package englishword;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import DB.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class EditUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField UserNameField;
	editUser eu = new editUser();
	UserDBConnection DBConn = new UserDBConnection();
	private ImageIcon background = new ImageIcon("resource/background/Main_Background.png");

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
}

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
//	public CreateUser(JPanel startPage) {
	public EditUser(MainUI MainFrame, String name) throws SQLException {
		String[] user = DBConn.BringUserInfo(name);
		eu.name = user[0];
		eu.diff = user[1];
		
		setBackground(new Color(176, 196, 222));
		setBounds(140, 120, 1000, 550);
		setSize(1280, 800); // 화면 크기 설정
		setLayout(null);
		
		JButton editUserButton = new JButton(new ImageIcon("resource/icons/green_check_100.png"));
		editUserButton.setBackground(new Color(255, 255, 255));
		editUserButton.setHorizontalAlignment(JButton.CENTER);
		editUserButton.setContentAreaFilled(false);
		editUserButton.setOpaque(false);
		editUserButton.setBorder(null);
//		createUserButton.setBackground(new Color(100, 149, 237));
//		createUserButton.setForeground(new Color(240, 255, 255));
		

		editUserButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		editUserButton.setBounds(955, 544, 100, 100);
		add(editUserButton);
		
		JButton EditUserCancelButton = new JButton(new ImageIcon("resource/icons/red_cancel_100.png"));
		EditUserCancelButton.setBackground(new Color(255, 255, 255));
		EditUserCancelButton.setHorizontalAlignment(JButton.CENTER);
		EditUserCancelButton.setContentAreaFilled(false);
		EditUserCancelButton.setOpaque(false);
		EditUserCancelButton.setBorder(null);
		EditUserCancelButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		EditUserCancelButton.setBounds(775, 544, 100, 100);
		add(EditUserCancelButton);
		
		JLabel EditUserTitle = new JLabel("사용자 수정");
		EditUserTitle.setHorizontalAlignment(SwingConstants.CENTER);
		EditUserTitle.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 32));
		EditUserTitle.setBounds(540, 60, 200, 50);
		add(EditUserTitle);
		
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
		UserNameField.setText(eu.name);
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
		if ("초등".equals(eu.diff)) {
		    UserLevelcomboBox.setSelectedIndex(0);
		} else if ("중등/고등".equals(eu.diff)) {
		    UserLevelcomboBox.setSelectedIndex(1);
		} else if ("대학".equals(eu.diff)) {
		    UserLevelcomboBox.setSelectedIndex(2);
		}

		add(UserLevelcomboBox);
		
		
		JLabel selectMenuLabel = new JLabel("사용자 정보를 입력하세요");
		selectMenuLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
		selectMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectMenuLabel.setForeground(new Color(0, 0, 128));
		selectMenuLabel.setBackground(new Color(0, 0, 0));
		selectMenuLabel.setBounds(679, 144, 470, 365);
		add(selectMenuLabel);
		
		JLabel CancelLabel = new JLabel("취소");
		CancelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CancelLabel.setForeground(new Color(255, 0, 0));
		CancelLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		CancelLabel.setBounds(775, 649, 100, 35);
		add(CancelLabel);
		
		JLabel AcceptLabel = new JLabel("확인");
		AcceptLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AcceptLabel.setForeground(new Color(46, 139, 87));
		AcceptLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		AcceptLabel.setBounds(955, 649, 100, 35);
		add(AcceptLabel);
		
		editUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					eu.name = UserNameField.getText();
					eu.diff = UserLevelcomboBox.getSelectedItem().toString();
					if ((eu.name != null && !eu.name.trim().isEmpty())&&(eu.diff != null && !eu.diff.trim().isEmpty())) {
						DBConn.EditUser(name, eu.name, eu.diff);
						String[] list = DBConn.BringUser();
						JOptionPane.showMessageDialog(null, "유저가 수정되었습니다.", "유저 수정", JOptionPane.WARNING_MESSAGE);
						MainFrame.showPanel("startPage", list);
					} else {
					    // 사용자에게 유효한 값을 입력하라는 메시지를 표시하거나 다른 처리 수행
					    JOptionPane.showMessageDialog(null, "Please enter a valid value.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		EditUserCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				startPage.setVisible(true);
				String[] list;
				try {
					list = DBConn.BringUser();
					MainFrame.showPanel("startPage", list);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
	public class editUser {
		public String name;
		public String diff;
	}
}
