package englishword;

import DB.*;
import java.util.Random;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordQuiz extends JPanel {

	private static final long serialVersionUID = 1L;
	
	UserInformation cu = new UserInformation();
	UserDBConnection DBConn = new UserDBConnection();
	WordDBConnection WDBConn = new WordDBConnection();
	WordScoreLink Scorelink = new WordScoreLink();
	String[] usinfo = DBConn.BringUserInfo(MainUI.username);
	
	Random r = new Random();
	public int ansnum = r.nextInt(13);
	public int anstype = r.nextInt(3);
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
    private JDialog exitDialog;
	private String choiceAnswer;
	private String CorrectAnswer;
	private String wordAnswer;
	private JButton choiceButton_1;
	private JButton choiceButton_2;
	private JButton choiceButton_3;
	private JButton choiceButton_4;
	private boolean timerRunning;
	private int delay = 1000;
	public boolean answerChecked; // 사용자가 정답 확인을 완료했는지 여부
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public WordQuiz(MainUI MainFrame, String name) throws SQLException {
		
		String[] wordeng = WDBConn.BringWordEng(name);
		String[] wordkor = WDBConn.BringWordKor(name);
		
		cu.username = usinfo[0];
		cu.userlevel = usinfo[1];
		cu.userhighscore = Integer.parseInt(usinfo[2]);
		cu.userlastword = Integer.parseInt(usinfo[3]);
		
		setBackground(new Color(176, 196, 222));
		setBounds(140, 120, 1000, 550);
		setSize(1280, 800); // 화면 크기 설정
		setLayout(null);
		
		UserDetailHead userDetailHead = new UserDetailHead(cu.username, cu.userlevel, cu.userhighscore);
		userDetailHead.setBackground(new Color(230, 230, 230));
		userDetailHead.setLocation(250, 25);
		userDetailHead.setSize(800, 70);
		add(userDetailHead, "userDetailHead");
		
		JButton exitButton = new JButton(new ImageIcon("resource/icons/exit_100.png"));
		exitButton.setBackground(new Color(255, 255, 255));
		exitButton.setForeground(new Color(0, 0, 0));
		exitButton.setHorizontalAlignment(SwingConstants.LEFT);
		exitButton.setContentAreaFilled(false);
		exitButton.setOpaque(false);
		exitButton.setBorder(null);
		exitButton.setText("  나가기");
		// .setBorderPainted(false);
		exitButton.setVerticalAlignment(JButton.CENTER);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				wordMenuPage.setVisible(true);
				timerThread.interrupt();
				try {
					quizExit(MainFrame);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		exitButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
		exitButton.setBounds(950, 602, 400, 100);
		add(exitButton);
		
		// 문제로 표시될 영어 단어
        wordLabel = new JLabel(wordeng[ansnum]); // 임의의 영어 단어로 초기화
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wordLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 24));
        wordLabel.setBounds(103, 133, 800, 70);
        add(wordLabel);
		
		// 선택 버튼
		choiceButton_1 = new JButton(wordkor[ansnum]);
		choiceButton_1.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceAnswer = choiceButton_1.getText(); // 현재 표시된 영어 단어
				try {
					checkAnswer(choiceAnswer, MainFrame);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		choiceButton_1.setBackground(new Color(255, 255, 255));
		choiceButton_1.setBounds(104, 249, 358, 159);
		add(choiceButton_1);
		
		choiceButton_2 = new JButton(wordkor[ansnum+1]);
		choiceButton_2.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceAnswer = choiceButton_2.getText(); // 현재 표시된 영어 단어
				try {
					checkAnswer(choiceAnswer, MainFrame);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		choiceButton_2.setBackground(new Color(255, 255, 255));
		choiceButton_2.setBounds(545, 249, 358, 159);
		add(choiceButton_2);
		
		choiceButton_3 = new JButton(wordkor[ansnum+2]);
		choiceButton_3.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceAnswer = choiceButton_3.getText(); // 현재 표시된 영어 단어
				try {
					checkAnswer(choiceAnswer, MainFrame);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		choiceButton_3.setBackground(new Color(255, 255, 255));
		choiceButton_3.setBounds(104, 503, 358, 159);
		add(choiceButton_3);
		
		choiceButton_4 = new JButton(wordkor[ansnum+3]);
		choiceButton_4.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
		choiceButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceAnswer = choiceButton_4.getText(); // 현재 표시된 영어 단어
				try {
					checkAnswer(choiceAnswer, MainFrame);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		choiceButton_4.setBackground(new Color(255, 255, 255));
		choiceButton_4.setBounds(545, 503, 358, 159);
		add(choiceButton_4);
		

	    timeLabel = new JLabel("남은 시간 : " + 7 + " 초"); // 남은 시간 표시 레이블
	    timeLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 25));
	    timeLabel.setBounds(968, 177, 209, 70);
	    add(timeLabel);


        
	       timer = new Timer(delay, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // 타이머 이벤트 발생 시 처리할 내용
	            }
	        });
        
        // 점수 및 라이프 구현
        
		NowScoreLabel = new JLabel("현재 점수 : " + nowScore);
		NowScoreLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 25));
		NowScoreLabel.setBounds(968, 297, 300, 70);
		add(NowScoreLabel);
		
		UserLifeLabel = new JLabel("라이프 : " + userLife);
		UserLifeLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 25));
		UserLifeLabel.setBounds(968, 417, 300, 70);
		add(UserLifeLabel);
		
	}
	
	
	// 함수 구현
	
	// 나가기 버튼 클릭 시 팝업창
	public void quizExit(MainUI MainFrame) throws SQLException {
		Scorelink.UpdateScore(cu.username, nowScore);
        if (exitDialog != null && exitDialog.isShowing()) {
            exitDialog.dispose(); // 이미 다이얼로그가 열려있으면 닫기
        }
        Thread currentTimerThread = timerThread;
        exitDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "돌아가기", true);
        exitDialog.getContentPane().setLayout(null);
        JLabel exitLabel = new JLabel("정말로 퀴즈를 종료하시겠습니까?");
		exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exitLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 20));
		exitLabel.setBounds(42, 56, 300, 30);
        exitDialog.getContentPane().add(exitLabel);
        exitDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
		JButton exitButton = new JButton("예 (Y)");
		exitButton.setForeground(new Color(255, 0, 0));
		exitButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 18));
		exitButton.setBackground(new Color(255, 255, 255));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.showPanel("wordMenuPage", null);
				exitDialog.dispose();
			}
		});
		exitButton.setBounds(42, 133, 120, 40);
		exitDialog.getContentPane().add(exitButton);
		
		JButton resumeButton = new JButton("아니오 (N)");
		resumeButton.setForeground(new Color(192, 192, 192));
		resumeButton.setBackground(new Color(255, 255, 255));
		resumeButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 18));
		resumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startTimer(MainFrame, remainingTime);
				exitDialog.dispose();
			}
		});
		resumeButton.setBounds(210, 133, 120, 40);
		exitDialog.getContentPane().add(resumeButton);

        exitDialog.setSize(400, 250);
        exitDialog.setLocationRelativeTo((Frame) SwingUtilities.getWindowAncestor(this)); // 부모 프레임 중앙에 표시
        exitDialog.setVisible(true);
	}
	
	
	
	// 정답, 오답, 시간 초과 시 사용자에게 표시되는 팝업창
    public void showResultDialog(String message, boolean isCorrect) {
        if (resultDialog != null && resultDialog.isShowing()) {
            resultDialog.dispose(); // 이미 다이얼로그가 열려있으면 닫기
        }
//        timerThread.interrupt();
        resultDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "진행 중", true); // 부모 프레임을 설정
        JLabel resultLabel = new JLabel(message);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 25));
        resultLabel.setBounds(155, 150, 300, 100);
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

        int closeDelay = 2000;

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
	

    /**
     * 시간 초과 메시지 표시 메서드
     * @throws SQLException 
     */
    private void showTimeoutMessage(MainUI MainFrame) throws SQLException {
    	// timerThread.interrupt(); // 스레드를 중지
    	
    	String[] wordeng = WDBConn.BringWordEng(MainUI.username);
    	String[] wordkor = WDBConn.BringWordKor(MainUI.username);
    	wordAnswer = wordkor[ansnum];
    	
    	timerRunning = false;
    	String correctWord = wordAnswer;
    	showResultDialog("시간 초과! 정답은 " + correctWord, false);
        userLife--;
        

        if(userLife <= 0) {
        	showResultDialog("퀴즈 종료. 라이프가 모두 소진되었습니다.", false);
        	answerChecked = false;
        	MainFrame.showPanel("wordMenuPage", null);
        }
        else {
        	r.setSeed(System.currentTimeMillis());
        	ansnum = r.nextInt(13);
        	anstype = r.nextInt(3);
        	if(ansnum>10) ansnum = 10;
        	switch(anstype) {
        	case 0:
        		wordLabel.setText(wordeng[ansnum]);
                // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                   choiceButton_1.setText(wordkor[ansnum]);
                   choiceButton_2.setText(wordkor[ansnum+1]);
                   choiceButton_3.setText(wordkor[ansnum+2]);
                   choiceButton_4.setText(wordkor[ansnum+3]);
                   updateLabels();
        	case 1:
        		wordLabel.setText(wordeng[ansnum]);
                // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                   choiceButton_1.setText(wordkor[ansnum+1]);
                   choiceButton_2.setText(wordkor[ansnum]);
                   choiceButton_3.setText(wordkor[ansnum+3]);
                   choiceButton_4.setText(wordkor[ansnum+2]);
                   updateLabels();
        	case 2:
        		wordLabel.setText(wordeng[ansnum]);
                // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                   choiceButton_1.setText(wordkor[ansnum+2]);
                   choiceButton_2.setText(wordkor[ansnum+1]);
                   choiceButton_3.setText(wordkor[ansnum]);
                   choiceButton_4.setText(wordkor[ansnum+3]);
                   updateLabels();
        	case 3:
        		wordLabel.setText(wordeng[ansnum]);
                // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                   choiceButton_1.setText(wordkor[ansnum+1]);
                   choiceButton_2.setText(wordkor[ansnum+2]);
                   choiceButton_3.setText(wordkor[ansnum+3]);
                   choiceButton_4.setText(wordkor[ansnum]);
                   updateLabels();
        	}
            
            // 시간 초기화 및 스레드 재시작 (새로운 문제 시작)
            remainingTime = 7;
            startTimer(MainFrame);
        }
        // startTimer(MainFrame);
    }
    
    private void checkAnswer(String selectedMeaning, MainUI MainFrame) throws SQLException {
    	  	
    	String[] wordeng = WDBConn.BringWordEng(MainUI.username);
    	String[] wordkor = WDBConn.BringWordKor(MainUI.username);
    	wordAnswer = wordkor[ansnum];
    	
    	if(answerChecked) {
    		return;
    	}
    	
        timerThread.interrupt(); // 정답을 선택하면 스레드를 중지
        String correctWord = wordAnswer; // 현재 표시된 영어 단어

        if (selectedMeaning.equals(correctWord)) {
            // 정답 처리
            nowScore += (remainingTime * 10);

            // 버튼 색상 변경
            getSelectedButton(selectedMeaning).setBackground(new Color(0, 255, 127));

            // 대기 스레드 시작
            Thread waitThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000); // 2초 대기
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        // 정답 표시 이후 2초 대기 후에 실행되는 부분
                        // 버튼 색상 리셋
                        resetButtonColors();
                        
                        r.setSeed(System.currentTimeMillis());
                    	ansnum = r.nextInt(13);
                    	anstype = r.nextInt(3);
                    	if(ansnum>10) ansnum = 10;
                    	switch(anstype) {
                    	case 0:
                    		wordLabel.setText(wordeng[ansnum]);
                            // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                               choiceButton_1.setText(wordkor[ansnum]);
                               choiceButton_2.setText(wordkor[ansnum+1]);
                               choiceButton_3.setText(wordkor[ansnum+2]);
                               choiceButton_4.setText(wordkor[ansnum+3]);
                               updateLabels();
                    	case 1:
                    		wordLabel.setText(wordeng[ansnum]);
                            // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                               choiceButton_1.setText(wordkor[ansnum+1]);
                               choiceButton_2.setText(wordkor[ansnum]);
                               choiceButton_3.setText(wordkor[ansnum+3]);
                               choiceButton_4.setText(wordkor[ansnum+2]);
                               updateLabels();
                    	case 2:
                    		wordLabel.setText(wordeng[ansnum]);
                            // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                               choiceButton_1.setText(wordkor[ansnum+2]);
                               choiceButton_2.setText(wordkor[ansnum+1]);
                               choiceButton_3.setText(wordkor[ansnum]);
                               choiceButton_4.setText(wordkor[ansnum+3]);
                               updateLabels();
                    	case 3:
                    		wordLabel.setText(wordeng[ansnum]);
                            // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                               choiceButton_1.setText(wordkor[ansnum+1]);
                               choiceButton_2.setText(wordkor[ansnum+2]);
                               choiceButton_3.setText(wordkor[ansnum+3]);
                               choiceButton_4.setText(wordkor[ansnum]);
                               updateLabels();
                    	}

                        // 시간 초기화 및 스레드 재시작 (새로운 문제 시작)
                        remainingTime = 7;
                        startTimer(MainFrame);
                        
                        // 중복으로 점수를 획득하는 것을 막기 위함
                        answerChecked = false;
                    }
                }
            });
            waitThread.start();
        } else {
            // 오답 처리
            userLife--;

            if (userLife <= 0) {
                showResultDialog("게임 종료. 라이프가 모두 소진되었습니다.", false);
                answerChecked = false;
                MainFrame.showPanel("wordMenuPage", null);
            } else {
                // 오답인 버튼 색상 변경
                getSelectedButton(selectedMeaning).setBackground(new Color(220, 20, 60));
                getCorrectButton(correctWord).setBackground(Color.GREEN);
                // 대기 스레드 시작
                Thread waitThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000); // 2초 대기
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        } finally {
                            // 오답 표시 이후 2초 대기 후에 실행되는 부분
                            // 버튼 색상 리셋
                            resetButtonColors();

                            r.setSeed(System.currentTimeMillis());
                        	ansnum = r.nextInt(13);
                        	anstype = r.nextInt(3);
                        	if(ansnum>10) ansnum = 10;
                        	switch(anstype) {
                        	case 0:
                        		wordLabel.setText(wordeng[ansnum]);
                                // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                                   choiceButton_1.setText(wordkor[ansnum]);
                                   choiceButton_2.setText(wordkor[ansnum+1]);
                                   choiceButton_3.setText(wordkor[ansnum+2]);
                                   choiceButton_4.setText(wordkor[ansnum+3]);
                                   updateLabels();
                        	case 1:
                        		wordLabel.setText(wordeng[ansnum]);
                                // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                                   choiceButton_1.setText(wordkor[ansnum+1]);
                                   choiceButton_2.setText(wordkor[ansnum]);
                                   choiceButton_3.setText(wordkor[ansnum+3]);
                                   choiceButton_4.setText(wordkor[ansnum+2]);
                                   updateLabels();
                        	case 2:
                        		wordLabel.setText(wordeng[ansnum]);
                                // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                                   choiceButton_1.setText(wordkor[ansnum+2]);
                                   choiceButton_2.setText(wordkor[ansnum+1]);
                                   choiceButton_3.setText(wordkor[ansnum]);
                                   choiceButton_4.setText(wordkor[ansnum+3]);
                                   updateLabels();
                        	case 3:
                        		wordLabel.setText(wordeng[ansnum]);
                                // 여기에 답 부분 세팅 추가해야 합니다.. DB 연결 후 확인 부탁드려요 String으로 값 계속 변경하는건 불가능하네요
                                   choiceButton_1.setText(wordkor[ansnum+1]);
                                   choiceButton_2.setText(wordkor[ansnum+2]);
                                   choiceButton_3.setText(wordkor[ansnum+3]);
                                   choiceButton_4.setText(wordkor[ansnum]);
                                   updateLabels();
                        	}
                            resetButtonColors();

                            // 시간 초기화 및 스레드 재시작 (새로운 문제 시작)
                            remainingTime = 7;
                            startTimer(MainFrame);
                            
                            // 중복으로 라이프가 깎이는 것을 막기 위함
                            answerChecked = false;
                        }
                    }
                });
                waitThread.start();
            }
        }
        answerChecked = true;
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
            choiceButton_2.setBackground(new Color(220, 20, 60));
            choiceButton_3.setBackground(new Color(220, 20, 60));
            choiceButton_4.setBackground(new Color(220, 20, 60));
            return choiceButton_1;
        } else if (selectedMeaning.equals(choiceButton_2.getText())) {
            choiceButton_1.setBackground(new Color(220, 20, 60));
            choiceButton_3.setBackground(new Color(220, 20, 60));
            choiceButton_4.setBackground(new Color(220, 20, 60));
            return choiceButton_2;
        } else if (selectedMeaning.equals(choiceButton_3.getText())) {
            choiceButton_1.setBackground(new Color(220, 20, 60));
            choiceButton_2.setBackground(new Color(220, 20, 60));
            choiceButton_4.setBackground(new Color(220, 20, 60));
            return choiceButton_3;
        } else if (selectedMeaning.equals(choiceButton_4.getText())) {
            choiceButton_1.setBackground(new Color(220, 20, 60));
            choiceButton_2.setBackground(new Color(220, 20, 60));
            choiceButton_3.setBackground(new Color(220, 20, 60));
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
                        try {
							showTimeoutMessage(MainFrame);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
    
    public void startTimer(MainUI MainFrame, int initialTime) {
        // 시작 전에 이전 타이머를 중지
        stopTimer();

        timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    timerRunning = true; // 타이머 동작 플래그 설정
                    for (remainingTime = initialTime; remainingTime >= 0 && timerRunning; remainingTime--) {
                        updateRemainingTime();
                        Thread.sleep(1000); // 1초 대기
                    }
                    if (timerRunning) {
                        try {
							showTimeoutMessage(MainFrame);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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

    // 시간 대기
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
    
    // 시간 라벨 업데이트
    public void updateRemainingTime(){
    	timeLabel.setText("남은 시간 : " + remainingTime + "초");
    }
    
    // 퀴즈 시작 ( 초기화 )
    public void initQuiz() {
    	remainingTime = 7;
    	nowScore = 0;
    	userLife = 5;
    	timeLabel.setText("남은 시간 : " + remainingTime + "초");
    	NowScoreLabel.setText("현재 점수 : " + nowScore + " 점");
    	UserLifeLabel.setText("라이프 : " + userLife);
    }
    
    public class UserInformation {
		public String username;
		public String userlevel;
		public int userhighscore;
		public int userlastword;
	}
}
