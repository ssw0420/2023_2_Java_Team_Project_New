package englishword;

import java.awt.*; // 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // AWT 이벤트 사용을 위한 경로명
import javax.swing.*; // 스윙 컴포넌트 클래스들의 경로명
import javax.swing.event.*; // 스윙 이벤트를 위한 경로명

public class SettingInit extends JFrame {

	public SettingInit() {
		setTitle("영단어 학습"); // 프로그램 이름
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X 클릭시 프로그램 종료
		setSize(1280, 800); // 화면 크기 설정
		setLocationRelativeTo(null); // 화면을 중앙에 표시
		setResizable(false); // 화면 크기 설정 불가
		getContentPane().setBackground(new Color(99, 173, 235)); // 색상 설정
		setVisible(true); // 화면 출력
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SettingInit EnglishWord = new SettingInit();
	}

}
