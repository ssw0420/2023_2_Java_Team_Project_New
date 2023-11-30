package englishword;

import DB.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Timer;


public class WordQuiz extends JPanel {

	String[] none = null;
	UserDBConnection DBConn = new UserDBConnection();
	private static final long serialVersionUID = 1L;
	private JLabel wordLabel;
	private int nowScore;
	private int userLife = 5;
	private Timer timer;
    private JLabel timeLabel; // 시간을 표시하는 레이블
    private JLabel UserLifeLabel;
    private JLabel NowScoreLabel;
    private Thread timerThread; // 시간을 측정하는 스레드
    private int remainingTime; // 남은 시간 (초)
    private JDialog resultDialog; // JDialog 추가
	private String nowWord;
	private JButton choiceButton_1;
	private JButton choiceButton_2;
	private JButton choiceButton_3;
	private JButton choiceButton_4;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public WordQuiz(ActionListener actionListener, String username) throws SQLException {
		String[] signedinuser = DBConn.BringUserInfo(username);
		setBackground(new Color(176, 196, 222));
		setBounds(140, 120, 1000, 550);
		setSize(1280, 800); // 화면 크기 설정
		setLayout(null);
		
		UserDetailHead userDetailHead = new UserDetailHead(signedinuser[0], signedinuser[1], Integer.parseInt(signedinuser[2]));
		userDetailHead.setBackground(new Color(230, 230, 250));
		userDetailHead.setLocation(250, 25);
		userDetailHead.setSize(800, 70);
		add(userDetailHead, "userDetailHead");
		
		JButton exitButton = new JButton("나가기");
		exitButton.setBackground(new Color(255, 255, 255));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				wordMenuPage.setVisible(true);
				((MainUI) actionListener).showPanel("wordMenuPage", none);
			}
		});
		exitButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		exitButton.setBounds(1000, 676, 180, 60);
		add(exitButton);
		
		// 문제로 표시될 영어 단어
        wordLabel = new JLabel("1번 답"); // 임의의 영어 단어로 초기화
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wordLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 24));
        wordLabel.setBounds(100, 110, 800, 70);
        add(wordLabel);
		
		// 선택 버튼
		choiceButton_1 = new JButton("1번 답");
		choiceButton_1.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowWord = choiceButton_1.getText(); // 현재 표시된 영어 단어
				checkAnswer(nowWord, actionListener);
			}
		});
		choiceButton_1.setBackground(new Color(255, 255, 255));
		choiceButton_1.setBounds(100, 222, 358, 159);
		add(choiceButton_1);
		
		choiceButton_2 = new JButton("2번 답");
		choiceButton_2.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowWord = choiceButton_2.getText(); // 현재 표시된 영어 단어
				checkAnswer(nowWord, actionListener);
			}
		});
		choiceButton_2.setBackground(new Color(255, 255, 255));
		choiceButton_2.setBounds(541, 222, 358, 159);
		add(choiceButton_2);
		
		choiceButton_3 = new JButton("3번 답");
		choiceButton_3.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowWord = choiceButton_3.getText(); // 현재 표시된 영어 단어
				checkAnswer(nowWord, actionListener);
			}
		});
		choiceButton_3.setBackground(new Color(255, 255, 255));
		choiceButton_3.setBounds(100, 476, 358, 159);
		add(choiceButton_3);
		
		choiceButton_4 = new JButton("4번 답");
		choiceButton_4.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowWord = choiceButton_4.getText(); // 현재 표시된 영어 단어
				checkAnswer(nowWord, actionListener);
			}
		});
		choiceButton_4.setBackground(new Color(255, 255, 255));
		choiceButton_4.setBounds(541, 476, 358, 159);
		add(choiceButton_4);
		
        timer = new Timer(7000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTimeoutMessage();
            }
        });
        timer.setRepeats(false); // 한 번만 실행되도록 설정
		
	
        timeLabel = new JLabel("남은 시간: 7초"); // 남은 시간 표시 레이블
        timeLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
        timeLabel.setBounds(1000, 158, 209, 70);
        add(timeLabel);
		
        
        // 스레드를 활용하여 시간 측정
        timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (remainingTime = 7; remainingTime >= 0; remainingTime--) {
                        updateTimerLabel();
                        Thread.sleep(1000); // 1초 대기
                    }
                    showTimeoutMessage();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                	Thread.currentThread().interrupt(); // 인터럽트 상태를 다시 설정
                }
            }
        });
        timerThread.start();
        
		NowScoreLabel = new JLabel("현재 점수 :");
		NowScoreLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		NowScoreLabel.setBounds(1000, 267, 209, 70);
		add(NowScoreLabel);
		
		UserLifeLabel = new JLabel("라이프 : " + userLife);
		UserLifeLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		UserLifeLabel.setBounds(1000, 371, 209, 70);
		add(UserLifeLabel);
		
		
	}
	
    private void showResultDialog(String message, boolean isCorrect) {
        if (resultDialog != null && resultDialog.isShowing()) {
            resultDialog.dispose(); // 이미 다이얼로그가 열려있으면 닫기
        }

        resultDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "결과", true); // 부모 프레임을 설정
        JLabel resultLabel = new JLabel(message);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
        resultDialog.getContentPane().add(resultLabel);

        int closeDelay = isCorrect ? 1000 : 2000;
        Timer closeTimer = new Timer(closeDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultDialog.dispose();
            }
        });
        closeTimer.setRepeats(false);
        closeTimer.start();

        resultDialog.setSize(500, 300);
        resultDialog.setLocationRelativeTo((Frame) SwingUtilities.getWindowAncestor(this)); // 부모 프레임 중앙에 표시
        resultDialog.setVisible(true);
    }
	
    /**
     * 정답 체크 및 팝업창 표시 메서드
     */
    private void checkAnswer(String selectedMeaning, ActionListener actionListener) {
        timerThread.interrupt(); // 정답을 선택하면 스레드를 중지
        String correctWord = wordLabel.getText(); // 현재 표시된 영어 단어
        if (selectedMeaning.equals(correctWord)) {
            showResultDialog("정답!", true);
            nowScore += 10;
        } else {
            showResultDialog("오답...", false);
            userLife--;
            if (userLife <= 0) {
                showResultDialog("게임 종료. 라이프가 모두 소진되었습니다.", false);
                ((MainUI) actionListener).showPanel("WordMenu", none);
            }
        }
        wordLabel.setText("2번 답");
        choiceButton_1.setText("1..");
        choiceButton_2.setText("2번 답");
        choiceButton_3.setText("3..");
        choiceButton_4.setText("4..");
        updateScoreAndLifeLabels();

        // 시간 초기화 및 스레드 재시작 (새로운 문제 시작)
        remainingTime = 7;
        timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (; remainingTime >= 0; remainingTime--) {
                        updateTimerLabel();
                        Thread.sleep(1000); // 1초 대기
                    }
                    showTimeoutMessage();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    Thread.currentThread().interrupt(); // 인터럽트 상태를 다시 설정
                }
            }
        });
        timerThread.start();
    }

    /**
     * 시간 초과 메시지 표시 메서드
     */
    private void showTimeoutMessage() {
        JOptionPane.showMessageDialog(this, "시간 초과!", "시간 초과", JOptionPane.WARNING_MESSAGE);

        
        //새로운 랜덤 단어 표시
        wordLabel.setText("2번 답");
        choiceButton_1.setText("1..");
        choiceButton_2.setText("2번 답");
        choiceButton_3.setText("3..");
        choiceButton_4.setText("4..");
        updateScoreAndLifeLabels();
        // 시간 초기화 및 스레드 재시작 (새로운 문제 시작)
        remainingTime = 7;
        timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (; remainingTime >= 0; remainingTime--) {
                        updateTimerLabel();
                        Thread.sleep(1000); // 1초 대기
                    }
                    showTimeoutMessage();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.start();
    }

    /**
     * 남은 시간을 표시하는 레이블 갱신 메서드
     */
    private void updateTimerLabel() {
        timeLabel.setText("남은 시간: " + remainingTime + "초");
	}
    
    private void updateScoreAndLifeLabels() {
        // 현재 점수 표시
        NowScoreLabel.setText("현재 점수: " + nowScore);
        // 라이프 표시
        UserLifeLabel.setText("라이프: " + userLife);
    }
}