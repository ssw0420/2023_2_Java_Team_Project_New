package englishword;

import java.awt.*; // 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // AWT 이벤트 사용을 위한 경로명
import javax.swing.*; // 스윙 컴포넌트 클래스들의 경로명
import javax.swing.event.*; // 스윙 이벤트를 위한 경로명

public class LoginUI extends JFrame {

	public void ShowUser() {
		
	}
	
	public void CreateUser() {
		
	}
	
	public void EditUser() {
		
	}
	
	public void DeleteUser(JList SelectedUser) {
		
	}
	
	public void Enter(JList SelectedUser) {
		
	}
	
	public LoginUI() {
		setTitle("영단어 학습"); // 프로그램 이름
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X 클릭시 프로그램 종료
		setSize(1280, 800); // 화면 크기 설정
		setLocationRelativeTo(null); // 화면을 중앙에 표시
		setResizable(false); // 화면 크기 설정 불가
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(new CenterPanel(), BorderLayout.CENTER);
		contentPane.add(new NorthPanel(), BorderLayout.NORTH);
		contentPane.add(new WestPanel(), BorderLayout.WEST);
		contentPane.add(new EastPanel(), BorderLayout.EAST);
		contentPane.add(new SouthPanel(), BorderLayout.SOUTH);
//	    JPanel buttonPanel = new JPanel(); // 버튼들을 담을 패널 생성
//	    buttonPanel.add(new JButton("생성"));
//	    buttonPanel.add(new JButton("수정"));
//	    buttonPanel.add(new JButton("삭제"));
//	    contentPane.add(buttonPanel, BorderLayout.EAST); // 버튼 패널을 동쪽에 추가
	    
//		contentPane.setBackground(new Color(99, 173, 235)); // 색상 설정
		
		
		
		setVisible(true); // 화면 출력
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginUI EnglishWord = new LoginUI();
	}

}
