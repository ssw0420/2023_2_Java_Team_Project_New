package englishword;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordQuiz extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel wordLabel;
	private int nowScore;
	private int userLife;
	private Timer timer;
    private JLabel timeLabel; // 시간을 표시하는 레이블
    private JLabel UserLifeLabel;
    private JLabel NowScoreLabel;
    private Thread timerThread; // 시간을 측정하는 스레드
    private int remainingTime; // 남은 시간 (초)
    private JDialog resultDialog; // JDialog 추가
	private String choiceAnswer;
	private String CorrectAnswer = "2번 답";
	private String wordAnswer = "2번 답";
	private JButton choiceButton_1;
	private JButton choiceButton_2;
	private JButton choiceButton_3;
	private JButton choiceButton_4;
	private boolean timerRunning;
	private int delay = 1000;
	private boolean answerChecked; // 사용자가 정답 확인을 완료했는지 여부
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
		
		JButton exitButton = new JButton("나가기");
		exitButton.setBackground(new Color(255, 255, 255));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				wordMenuPage.setVisible(true);
				timerThread.interrupt();
				MainFrame.showPanel("wordMenuPage");
			}
		});
		exitButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		exitButton.setBounds(1000, 676, 180, 60);
		add(exitButton);
		
		// 문제로 표시될 영어 단어
        wordLabel = new JLabel("1번 문제"); // 임의의 영어 단어로 초기화
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wordLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 24));
        wordLabel.setBounds(100, 110, 800, 70);
        add(wordLabel);
		
		// 선택 버튼
		choiceButton_1 = new JButton("1번 답");
		choiceButton_1.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceAnswer = choiceButton_1.getText(); // 현재 표시된 영어 단어
				checkAnswer(choiceAnswer, MainFrame);
				
			}
		});
		choiceButton_1.setBackground(new Color(255, 255, 255));
		choiceButton_1.setBounds(100, 222, 358, 159);
		add(choiceButton_1);
		
		choiceButton_2 = new JButton("2번 답");
		choiceButton_2.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceAnswer = choiceButton_2.getText(); // 현재 표시된 영어 단어
				checkAnswer(choiceAnswer, MainFrame);
			}
		});
		choiceButton_2.setBackground(new Color(255, 255, 255));
		choiceButton_2.setBounds(541, 222, 358, 159);
		add(choiceButton_2);
		
		choiceButton_3 = new JButton("3번 답");
		choiceButton_3.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceAnswer = choiceButton_3.getText(); // 현재 표시된 영어 단어
				checkAnswer(choiceAnswer, MainFrame);
			}
		});
		choiceButton_3.setBackground(new Color(255, 255, 255));
		choiceButton_3.setBounds(100, 476, 358, 159);
		add(choiceButton_3);
		
		choiceButton_4 = new JButton("4번 답");
		choiceButton_4.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceAnswer = choiceButton_4.getText(); // 현재 표시된 영어 단어
				checkAnswer(choiceAnswer, MainFrame);
			}
		});
		choiceButton_4.setBackground(new Color(255, 255, 255));
		choiceButton_4.setBounds(541, 476, 358, 159);
		add(choiceButton_4);
		
		
//	    // 시간 구현
//	    timer = new Timer(7000, new ActionListener() {
//	        @Override
//	        public void actionPerformed(ActionEvent e) {
//	            showTimeoutMessage(MainFrame);
//	        }
//	    });
//	    timer.setRepeats(false); // 한 번만 실행되도록 설정
//
	    timeLabel = new JLabel("남은 시간 : " + 7 + " 초"); // 남은 시간 표시 레이블
	    timeLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 25));
	    timeLabel.setBounds(964, 150, 209, 70);
	    add(timeLabel);

//	    // 스레드를 활용하여 시간 측정
//	    timerThread = new Thread(new Runnable() {
//	        @Override
//	        public void run() {
//	            try {
//	                for (remainingTime = 7; remainingTime >= 0; remainingTime--) {
//	                    Thread.sleep(1000); // 1초 대기
//	                }
//	                showTimeoutMessage(MainFrame);
//	            } catch (InterruptedException e) {
//	                // e.printStackTrace();
//	                Thread.currentThread().interrupt(); // 인터럽트 상태를 다시 설정
//	            }
//	        }
//	    });
//	    timerThread.start();
//	    startTimer(MainFrame);
		
		
		
		
		// 시간 구현
		
		
//        timer = new Timer(7000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showTimeoutMessage(MainFrame);
//            }
//        });
//        timer.setRepeats(false); // 한 번만 실행되도록 설정
//		
//	
//        timeLabel = new JLabel("남은 시간 : " + remainingTime); // 남은 시간 표시 레이블
//        timeLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
//        timeLabel.setBounds(1000, 150, 209, 70);
//        add(timeLabel);
		
//        
//        // 스레드를 활용하여 시간 측정
//        timerThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    for (remainingTime = 7; remainingTime >= 0; remainingTime--) {
//                    	updateLabels();
//                        Thread.sleep(1000); // 1초 대기
//                    }
//                    showTimeoutMessage(MainFrame);
//                } catch (InterruptedException e) {
//                    //e.printStackTrace();
//                	Thread.currentThread().interrupt(); // 인터럽트 상태를 다시 설정
//                }
//            }
//        });
//        timerThread.start();
        
	       timer = new Timer(delay, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // 타이머 이벤트 발생 시 처리할 내용
	            }
	        });
        
        // 점수 및 라이프 구현
        
		NowScoreLabel = new JLabel("현재 점수 : " + nowScore);
		NowScoreLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 25));
		NowScoreLabel.setBounds(964, 270, 300, 70);
		add(NowScoreLabel);
		
		UserLifeLabel = new JLabel("라이프 : " + userLife);
		UserLifeLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 25));
		UserLifeLabel.setBounds(964, 390, 300, 70);
		add(UserLifeLabel);
		
	}
	
	
	// 함수 구현
	
	// 정답, 오답, 시간 초과 시 사용자에게 표시되는 팝업창
    private void showResultDialog(String message, boolean isCorrect) {
        if (resultDialog != null && resultDialog.isShowing()) {
            resultDialog.dispose(); // 이미 다이얼로그가 열려있으면 닫기
        }

        resultDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "결과", true); // 부모 프레임을 설정
        JLabel resultLabel = new JLabel(message);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 25));
        resultLabel.setBounds(150, 150, 300, 100);
        if(isCorrect) {
        	resultLabel.setForeground(new Color(0, 0, 255));
			resultLabel.setBackground(new Color(0, 0, 0));
        }
        else{
        	resultLabel.setForeground(new Color(255, 0, 0));
			resultLabel.setBackground(new Color(0, 0, 0));
        }
        resultDialog.getContentPane().add(resultLabel);
        resultDialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        int closeDelay = 3000;
//        int popuptime = 1;
//        JLabel timeLabel = new JLabel();
//        timeLabel.setText(popuptime + " 초 후 다음 문제 시작");
//        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        timeLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
//        timeLabel.setForeground(new Color(0, 0, 0));
//		timeLabel.setBackground(new Color(0, 0, 0));
//		timeLabel.setBounds(150, 300, 300, 100);
//		resultDialog.getContentPane().add(timeLabel);
//		resultDialog.getContentPane().setLayout(null);
        Timer closeTimer = new Timer(closeDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultDialog.dispose();
            }
        });
        closeTimer.setRepeats(false);
        closeTimer.start();

        resultDialog.setSize(600, 300);
        resultDialog.setLocationRelativeTo((Frame) SwingUtilities.getWindowAncestor(this)); // 부모 프레임 중앙에 표시
        resultDialog.setVisible(true);
    }
	
    
//    // 정답 체크 및 팝업창 표시
//    private void checkAnswer(String selectedMeaning, MainUI MainFrame) {
//        timerThread.interrupt(); // 정답을 선택하면 스레드를 중지
//        String correctWord = wordAnswer; // 현재 표시된 영어 단어
//        
//        // 정답과 오답 판단
//        if (selectedMeaning.equals(correctWord)) {
//            showResultDialog("정답!", true);
//            nowScore += 10;
//            
//            wordLabel.setText("2번 문제");
//            // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
//            choiceButton_1.setText("1..");
//            choiceButton_2.setText("2번 답");
//            choiceButton_3.setText("3..");
//            choiceButton_4.setText("4..");
//            updateLabels();
//            
//            // 시간 초기화 및 스레드 재시작 (새로운 문제 시작)
//            remainingTime = 7;
//            timerThread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        for (; remainingTime >= 0; remainingTime--) {
//                        	updateLabels();
//                        	updateRemainingTime();
//                            Thread.sleep(1000); // 1초 대기
//                        }
//                        showTimeoutMessage(MainFrame);
//                    } catch (InterruptedException e) {
//                        //e.printStackTrace();
//                        Thread.currentThread().interrupt(); // 인터럽트 상태를 다시 설정
//                    }
//                }
//            });
//            startTimer(MainFrame);
//        } else {
//            showResultDialog("오답...", false);
//            userLife--;
//            if (userLife <= 0) {
//                showResultDialog("게임 종료. 라이프가 모두 소진되었습니다.", false);
//                MainFrame.showPanel("wordMenuPage");
//            }
//            else{
//                wordLabel.setText("2번 문제");
//             // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
//                choiceButton_1.setText("1..");
//                choiceButton_2.setText("2번 답");
//                choiceButton_3.setText("3..");
//                choiceButton_4.setText("4..");
//                updateLabels();
//                
//                // 시간 초기화 및 스레드 재시작 (새로운 문제 시작)
//                remainingTime = 7;
//                timerThread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            for (; remainingTime >= 0; remainingTime--) {
//                            	updateLabels();
//                            	updateRemainingTime();
//                                Thread.sleep(1000); // 1초 대기
//                            }
//                            showTimeoutMessage(MainFrame);
//                        } catch (InterruptedException e) {
//                            //e.printStackTrace();
//                            Thread.currentThread().interrupt(); // 인터럽트 상태를 다시 설정
//                        }
//                    }
//                });
//                startTimer(MainFrame);
//            }
//        }
//    }

    /**
     * 시간 초과 메시지 표시 메서드
     */
    private void showTimeoutMessage(MainUI MainFrame) {
    	timerThread.interrupt(); // 스레드를 중지
    	String correctWord = wordAnswer;
    	showResultDialog("시간 초과! 정답은 " + correctWord, false);
        userLife--;
        

        if(userLife <= 0) {
        	showResultDialog("게임 종료. 라이프가 모두 소진되었습니다.", false);
        	MainFrame.showPanel("wordMenuPage");
        }
        else {
            //새로운 랜덤 단어 표시
            wordLabel.setText("2번 문제");
         // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
            choiceButton_1.setText("1..");
            choiceButton_2.setText("2번 답");
            choiceButton_3.setText("3..");
            choiceButton_4.setText("4..");
            updateLabels();
            
            // 시간 초기화 및 스레드 재시작 (새로운 문제 시작)
            remainingTime = 7;
            timerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (; remainingTime >= 0; remainingTime--) {
                        	updateLabels();
                        	updateRemainingTime();
                            Thread.sleep(1000); // 1초 대기
                        }
                        showTimeoutMessage(MainFrame);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        startTimer(MainFrame);
    }
    
    
    private void checkAnswer(String selectedMeaning, MainUI MainFrame) {
//    	
//    	if (answerChecked) {
//    		return;
//    	}
//    	
//    	answerChecked = true;
        timerThread.interrupt(); // 정답을 선택하면 스레드를 중지
        String correctWord = wordAnswer; // 현재 표시된 영어 단어

//        // 버튼 색상 초기화
//        resetButtonColors();

        // 정답과 오답 판단
        if (selectedMeaning.equals(correctWord)) {
            // showResultDialog("정답!", true);
            nowScore += 10;

            // 버튼 색상 변경
            getSelectedButton(selectedMeaning).setBackground(Color.GREEN);

            // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
            choiceButton_1.setText("1..");
            choiceButton_2.setText("2번 답");
            choiceButton_3.setText("3..");
            choiceButton_4.setText("4..");
            updateLabels();

            // 시간 초기화 및 스레드 재시작 (새로운 문제 시작)
            remainingTime = 7;
            timerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (; remainingTime >= 0; remainingTime--) {
                            updateLabels();
                            updateRemainingTime();
                            Thread.sleep(1000); // 1초 대기
                        }
                        showTimeoutMessage(MainFrame);
                    } catch (InterruptedException e) {
                        // e.printStackTrace();
                        Thread.currentThread().interrupt(); // 인터럽트 상태를 다시 설정
                    }
                }
            });
            startTimer(MainFrame);
        } else {
            // showResultDialog("오답...", false);
            userLife--;

            if (userLife <= 0) {
                showResultDialog("게임 종료. 라이프가 모두 소진되었습니다.", false);
                MainFrame.showPanel("wordMenuPage");
            } else {
                // 오답인 버튼 색상 변경
                getSelectedButton(selectedMeaning).setBackground(Color.RED);
             // 정답인 버튼 색상 변경
                getCorrectButton(correctWord).setBackground(Color.GREEN);

                wordLabel.setText("2번 문제");
                // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                choiceButton_1.setText("1..");
                choiceButton_2.setText("2번 답");
                choiceButton_3.setText("3..");
                choiceButton_4.setText("4..");
                updateLabels();
                
//             // 대기 시간 추가 (2초)
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }

                // 시간 초기화 및 스레드 재시작 (새로운 문제 시작)
                remainingTime = 7;
                timerThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (; remainingTime >= 0; remainingTime--) {
                                updateLabels();
                                updateRemainingTime();
                                Thread.sleep(1000); // 1초 대기
                            }
                            showTimeoutMessage(MainFrame);
                        } catch (InterruptedException e) {
                            // e.printStackTrace();
                            Thread.currentThread().interrupt(); // 인터럽트 상태를 다시 설정
                        } finally {
                        	// answerChecked = false;
                        }
                    }
                });
                startTimer(MainFrame);
            }
            resetButtonColors();
        }
    }

    // 버튼 색상 초기화 메서드
    private void resetButtonColors() {
        choiceButton_1.setBackground(new Color(255, 255, 255));
        choiceButton_2.setBackground(new Color(255, 255, 255));
        choiceButton_3.setBackground(new Color(255, 255, 255));
        choiceButton_4.setBackground(new Color(255, 255, 255));
    }

    // 선택된 버튼 가져오기
    private JButton getSelectedButton(String selectedMeaning) {
        if (selectedMeaning.equals(choiceButton_1.getText())) {
            choiceButton_2.setBackground(Color.RED);
            choiceButton_3.setBackground(Color.RED);
            choiceButton_4.setBackground(Color.RED);
            return choiceButton_1;
        } else if (selectedMeaning.equals(choiceButton_2.getText())) {
            choiceButton_1.setBackground(Color.RED);
            choiceButton_3.setBackground(Color.RED);
            choiceButton_4.setBackground(Color.RED);
            return choiceButton_2;
        } else if (selectedMeaning.equals(choiceButton_3.getText())) {
            choiceButton_1.setBackground(Color.RED);
            choiceButton_2.setBackground(Color.RED);
            choiceButton_4.setBackground(Color.RED);
            return choiceButton_3;
        } else if (selectedMeaning.equals(choiceButton_4.getText())) {
            choiceButton_1.setBackground(Color.RED);
            choiceButton_2.setBackground(Color.RED);
            choiceButton_3.setBackground(Color.RED);
            return choiceButton_4;
        }
        return null;
    }

    
    // 정답인 버튼 가져오기
    private JButton getCorrectButton(String correctWord) {
        if (correctWord.equals(choiceButton_1.getText())) {
            return choiceButton_1;
        } else if (correctWord.equals(choiceButton_2.getText())) {
            return choiceButton_2;
        } else if (correctWord.equals(choiceButton_3.getText())) {
            return choiceButton_3;
        } else if (correctWord.equals(choiceButton_4.getText())) {
            return choiceButton_4;
        }
        return null;
    }
    
    
    // 남은 시간 갱신
    public void updateLabels() {
        NowScoreLabel.setText("현재 점수 : " + nowScore + " 점");
        UserLifeLabel.setText("라이프 : " + userLife);
	}
    
    public void startTimer(MainUI MainFrame) {
        // 시작 전에 이전 타이머를 중지
        stopTimer();

        timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    timerRunning = true; // 타이머 동작 플래그 설정
                    for (remainingTime = 7; remainingTime >= 0 && timerRunning; remainingTime--) {
                    	updateRemainingTime();
                        Thread.sleep(1000); // 1초 대기
                    }
                    if (timerRunning) {
                        showTimeoutMessage(MainFrame);
                    }
                } catch (InterruptedException e) {
                    // 타이머 중단 시 발생하는 예외 처리
                    Thread.currentThread().interrupt(); // 인터럽트 상태를 다시 설정
                } finally {
                    timerRunning = false; // 타이머 종료 시 플래그 설정
                }
            }
        });
        timerThread.start();
        timer.start();
    }

    // 추가된 메서드
    public void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        if (timerThread != null && timerThread.isAlive()) {
            timerThread.interrupt(); // 타이머 스레드 인터럽트
            try {
                timerThread.join(); // 타이머 스레드 종료 대기
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        timerRunning = false; // 타이머 동작 플래그 초기화
    }
    
    public void updateRemainingTime(){
    	timeLabel.setText("남은 시간 : " + remainingTime + "초");
    }
    
    public void initQuiz() {
    	remainingTime = 7;
    	nowScore = 0;
    	userLife = 5;
    	timeLabel.setText("남은 시간 : " + remainingTime + "초");
    	NowScoreLabel.setText("현재 점수 : " + nowScore + " 점");
    	UserLifeLabel.setText("라이프 : " + userLife);
    }
}
