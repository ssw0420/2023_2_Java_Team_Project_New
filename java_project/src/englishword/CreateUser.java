package englishword;

import DB.*;

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
	public CreateUser(JPanel startPage) {
		setBackground(new Color(211, 211, 211));
		setBounds(140, 120, 1000, 550);
		setLayout(null);
		
		JButton createUserButton = new JButton("등 록");
		createUserButton.setBackground(new Color(100, 149, 237));
		createUserButton.setForeground(new Color(240, 255, 255));
		createUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createUserButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		createUserButton.setBounds(832, 400, 130, 50);
		add(createUserButton);
		
		JButton CreateUserCancelButton = new JButton("취 소");
		CreateUserCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				startPage.setVisible(true);
			}
		});
		CreateUserCancelButton.setForeground(new Color(0, 0, 0));
		CreateUserCancelButton.setBackground(new Color(255, 255, 255));
		CreateUserCancelButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		CreateUserCancelButton.setBounds(665, 400, 130, 50);
		add(CreateUserCancelButton);
		
		JLabel CreateUserTitle = new JLabel("사용자 등록");
		CreateUserTitle.setHorizontalAlignment(SwingConstants.CENTER);
		CreateUserTitle.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 32));
		CreateUserTitle.setBounds(400, 25, 200, 50);
		add(CreateUserTitle);
		
		JLabel UserNameLabel = new JLabel("이        름  :");
		UserNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UserNameLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		UserNameLabel.setBounds(100, 120, 100, 50);
		add(UserNameLabel);
		
		JLabel UserLevelLabel = new JLabel("목표  수준  :");
		UserLevelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UserLevelLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		UserLevelLabel.setBounds(100, 220, 100, 50);
		add(UserLevelLabel);
		
		UserNameField = new JTextField();
		UserNameField.setForeground(new Color(0, 0, 0));
		UserNameField.setHorizontalAlignment(SwingConstants.CENTER);
		UserNameField.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		UserNameField.setBackground(new Color(255, 255, 255));
		UserNameField.setBounds(215, 120, 220, 50);
		add(UserNameField);
		UserNameField.setColumns(10);
		
		JComboBox UserLevelcomboBox = new JComboBox();
		UserLevelcomboBox.setModel(new DefaultComboBoxModel(new String[] {"초등", "중등/고등", "대학"}));
		UserLevelcomboBox.setForeground(new Color(0, 0, 0));
		UserLevelcomboBox.setBackground(new Color(255, 255, 255));
		UserLevelcomboBox.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		UserLevelcomboBox.setBounds(215, 220, 220, 50);
		add(UserLevelcomboBox);
	}
}
