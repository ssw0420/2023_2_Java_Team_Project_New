

package englishword;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class EngStudy extends JFrame{

	private JFrame frame;
	private JTextField WordEngTextField1;
	private JTextField WordKorTextField1;
	private JTextField WordPronunciation1;
	private JTextField DifficultyTextField1;
	private JTextField usernameTextField;
	private JTextField userlevelTextField;
	private JTextField userhighscoreTextField;
	private JTextField WordEngTextField2;
	private JTextField WordKorTextField2;
	private JTextField WordPronunciation2;
	private JTextField DifficultyTextField2;

	public EngStudy() {
		getContentPane().setFont(new Font("굴림", Font.BOLD, 20));
		getContentPane().setBackground(SystemColor.activeCaption);
		WordMemorizeUI();
	}
	UserInfo loadedUserInfo = UserInfo.loadFromFile("src\\englishword\\userlist.txt");
	ArrayList<String> names = loadedUserInfo.getNames();
	ArrayList<String> levels = loadedUserInfo.getLevels();
	ArrayList<String> highscores = loadedUserInfo.getHighscores();
	//ArrayList<String> progressNums = loadedUserInfo.getProgressNums();

	EngWord loadedEngWord = EngWord.loadFromFile("src\\englishword\\wordlist.txt");
	ArrayList<String> words = loadedEngWord.getWords();
	ArrayList<String> meanings = loadedEngWord.getMeanings();
	ArrayList<String> pronunciations = loadedEngWord.getPronunciations();
   // ArrayList<String> wordslevels = loadedEngWord.getWordlevels();   
	
	
	
	int user_id = 0;
	int i =0;
	int save = 0 ;
	private JTextField ProgressNum1;
	private JTextField ProgressNum2;
	private JTextField WordEngTextField3;
	private JTextField WordKorTextField3;
	private JTextField WordPronunciation3;
	private JTextField DifficultyTextField3;
	private JTextField WordEngTextField4;
	private JTextField WordKorTextField4;
	private JTextField DifficultyTextField4;
	private JTextField WordPronunciation4;
	private JTextField ProgressNum4;
	private JTextField ProgressNum3;
	private void updateTextFields() {
		
	    WordEngTextField1.setText(words.get(i));
	    WordKorTextField1.setText(meanings.get(i));
	    WordPronunciation1.setText(pronunciations.get(i));
	    WordEngTextField2.setText(words.get(i + 1));
	    WordKorTextField2.setText(meanings.get(i + 1));
	    WordPronunciation2.setText(pronunciations.get(i +1 ));
	    WordEngTextField3.setText(words.get(i+2));
	    WordKorTextField3.setText(meanings.get(i+2));
	    WordPronunciation3.setText(pronunciations.get(i+2));
	    WordEngTextField4.setText(words.get(i + 3));
	    WordKorTextField4.setText(meanings.get(i + 3));
	    WordPronunciation4.setText(pronunciations.get(i + 3));
	  
	    ProgressNum1.setText(Integer.toString(i+1));
	    ProgressNum2.setText(Integer.toString(i+2));
	    ProgressNum3.setText(Integer.toString(i+3));
	    ProgressNum4.setText(Integer.toString(i+4));

	    
	}

	private void WordMemorizeUI() {
		setTitle("영단어 학습 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	
		JButton ExitButton = new JButton("나가기");
		ExitButton.setBounds(0, 0, 91, 23);
		getContentPane().add(ExitButton);
		
		JButton nextButton = new JButton(">>>");
		nextButton.setFont(new Font("굴림", Font.BOLD, 20));
		nextButton.setBounds(883, 280, 120, 53);
		getContentPane().add(nextButton);
        nextButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (i < words.size() - 2) {
        			i = i + 4; // i를 증가시킴
        			updateTextFields(); // 텍스트 필드 업데이트
        		}
        	}
        });
        
        JButton prevButton = new JButton("<<<");
        prevButton.setFont(new Font("굴림", Font.BOLD, 20));
        prevButton.setBounds(12, 280, 120, 53);
        getContentPane().add(prevButton);
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                if (i > 0) {
                    i= i - 4; // i를 감소시킴
                    updateTextFields(); // 텍스트 필드 업데이트
                }
            }
        });
        
        
   	    JButton SaveProgress_ = new JButton("책갈피");
   	    SaveProgress_.setBounds(843, 10, 85, 47);
        getContentPane().add(SaveProgress_);
        SaveProgress_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	UserInfo userInfo = new UserInfo();
            	userInfo.updateUserInfo(names.get(user_id), levels.get(user_id), highscores.get(user_id), Integer.toString(i+1));
            	userInfo.saveToFile("src\\englishword\\userlist.txt");
            	save = i;
            }
        });
        
        
        JButton saveButton = new JButton("불러오기");
        saveButton.setBounds(940, 10, 84, 47);
        getContentPane().add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	WordEngTextField1.setText(words.get(save));
        	    WordKorTextField1.setText(meanings.get(save));
        	    WordPronunciation1.setText(pronunciations.get(save));
        	    WordEngTextField2.setText(words.get(save + 1));
        	    WordKorTextField2.setText(meanings.get(save + 1));
        	    WordPronunciation2.setText(pronunciations.get(save + 1));    
            	WordEngTextField3.setText(words.get(save));
        	    WordKorTextField3.setText(meanings.get(save));
        	    WordPronunciation3.setText(pronunciations.get(save));
        	    WordEngTextField4.setText(words.get(save + 1));
        	    WordKorTextField4.setText(meanings.get(save + 1));
        	    WordPronunciation4.setText(pronunciations.get(save + 1));  
        	    
        	    ProgressNum1.setText(Integer.toString(save+1));
        	    ProgressNum2.setText(Integer.toString(save+2));
        	    ProgressNum3.setText(Integer.toString(save+3));
        	    ProgressNum4.setText(Integer.toString(save+4));

        	    i =save;
            }
        });
        
        
        
        
//////////////////////////////////////////////////////////////////////////////////////////
        
        WordEngTextField1 = new JTextField();
        WordEngTextField1.setForeground(new Color(0, 0, 0));
        WordEngTextField1.setEditable(false);
        WordEngTextField1.setFont(new Font("Arial", Font.PLAIN, 20));
        WordEngTextField1.setText(words.get(i));
        WordEngTextField1.setBounds(161, 141, 230, 35);
        getContentPane().add(WordEngTextField1);
        WordEngTextField1.setColumns(10);
        
        WordEngTextField2 = new JTextField();
        WordEngTextField2.setEditable(false);
        WordEngTextField2.setFont(new Font("Arial", Font.PLAIN, 20));
        WordEngTextField2.setText(words.get(i+1));
        WordEngTextField2.setBounds(161, 320, 230, 35);
        getContentPane().add(WordEngTextField2);
        WordEngTextField2.setColumns(10);       
        
        WordEngTextField3 = new JTextField();
        WordEngTextField3.setFont(new Font("Arial", Font.PLAIN, 20));
        WordEngTextField3.setEditable(false);
        WordEngTextField3.setText(words.get(i+2));
        WordEngTextField3.setBounds(573, 141, 230, 35);
        getContentPane().add(WordEngTextField3);
        WordEngTextField3.setColumns(10);   
        
        WordEngTextField4 = new JTextField();
        WordEngTextField4.setFont(new Font("Arial", Font.PLAIN, 20));
        WordEngTextField4.setText(words.get(i+3));
        WordEngTextField4.setEditable(false);
        WordEngTextField4.setBounds(573, 320, 230, 35);
        getContentPane().add(WordEngTextField4);
        WordEngTextField4.setColumns(10);
        
//////////////////////////////////////////////////////////////////////////////////////////
        
        WordKorTextField1 = new JTextField();
        WordKorTextField1.setEditable(false);
        WordKorTextField1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        WordKorTextField1.setText(meanings.get(i));
        WordKorTextField1.setBounds(161, 180, 230, 35);
        getContentPane().add(WordKorTextField1);
        WordKorTextField1.setColumns(10);
        
        WordKorTextField2 = new JTextField();
        WordKorTextField2.setEditable(false);
        WordKorTextField2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        WordKorTextField2.setText(meanings.get(i+1));
        WordKorTextField2.setBounds(161, 358, 230, 35);
        getContentPane().add(WordKorTextField2);
        WordKorTextField2.setColumns(10);
        
        WordKorTextField3 = new JTextField();
        WordKorTextField3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        WordKorTextField3.setText(meanings.get(i+2));
        WordKorTextField3.setEditable(false);
        WordKorTextField3.setBounds(573, 180, 230, 35);
        getContentPane().add(WordKorTextField3);
        WordKorTextField3.setColumns(10);
        
        WordKorTextField4 = new JTextField();
        WordKorTextField4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        WordKorTextField4.setText(meanings.get(i+4));
        WordKorTextField4.setEditable(false);
        WordKorTextField4.setBounds(573, 358, 230, 35);
        getContentPane().add(WordKorTextField4);
        WordKorTextField4.setColumns(10);
        
//////////////////////////////////////////////////////////////////////////////////////////
        
        
        WordPronunciation1 = new JTextField();
        WordPronunciation1.setEditable(false);
        WordPronunciation1.setFont(new Font("Arial", Font.PLAIN, 20));
        WordPronunciation1.setText(pronunciations.get(i));
        WordPronunciation1.setBounds(161, 220, 230, 35);
        getContentPane().add(WordPronunciation1);
        WordPronunciation1.setColumns(10);
        
        WordPronunciation2 = new JTextField();
        WordPronunciation2.setEditable(false);
        WordPronunciation2.setFont(new Font("Arial", Font.PLAIN, 20));
        WordPronunciation2.setText(pronunciations.get(i+1));
        WordPronunciation2.setBounds(161, 395, 230, 35);
        getContentPane().add(WordPronunciation2);
        WordPronunciation2.setColumns(10);
        
        WordPronunciation3 = new JTextField();
        WordPronunciation3.setFont(new Font("Arial", Font.PLAIN, 20));
        WordPronunciation3.setEditable(false);
        WordPronunciation3.setText(pronunciations.get(i+2));
        WordPronunciation3.setBounds(573, 220, 230, 35);
        getContentPane().add(WordPronunciation3);
        WordPronunciation3.setColumns(10);
        
        WordPronunciation4 = new JTextField();
        WordPronunciation4.setFont(new Font("Arial", Font.PLAIN, 20));
        WordPronunciation4.setText(pronunciations.get(i+3));
        WordPronunciation4.setEditable(false);
        WordPronunciation4.setBounds(573, 395, 230, 35);
        getContentPane().add(WordPronunciation4);
        WordPronunciation4.setColumns(10);
        
//////////////////////////////////////////////////////////////////////////////////////////
        
        
        DifficultyTextField1 = new JTextField();
        DifficultyTextField1.setEditable(false);
        DifficultyTextField1.setFont(new Font("굴림", Font.PLAIN, 20));
        DifficultyTextField1.setText(/*wordslevels.get(i)*/"초급");
        DifficultyTextField1.setBounds(161, 260, 230, 35);
        getContentPane().add(DifficultyTextField1);
        DifficultyTextField1.setColumns(10);
        
        DifficultyTextField2 = new JTextField();
        DifficultyTextField2.setEditable(false);
        DifficultyTextField2.setFont(new Font("굴림", Font.PLAIN, 20));
        DifficultyTextField2.setText(/*wordslevels.get(i+1)*/"초급");
        DifficultyTextField2.setBounds(161, 435, 230, 35);
        getContentPane().add(DifficultyTextField2);
        DifficultyTextField2.setColumns(10);
        
        DifficultyTextField3 = new JTextField();
        DifficultyTextField3.setFont(new Font("굴림", Font.PLAIN, 20));
        DifficultyTextField3.setText(/*wordslevels.get(i+1)*/"초급");
        DifficultyTextField3.setEditable(false);
        DifficultyTextField3.setBounds(573, 260, 230, 35);
        getContentPane().add(DifficultyTextField3);
        DifficultyTextField3.setColumns(10);
        
        DifficultyTextField4 = new JTextField();
        DifficultyTextField4.setFont(new Font("굴림", Font.PLAIN, 20));
        DifficultyTextField4.setText(/*wordslevels.get(i+1)*/"초급");
        DifficultyTextField4.setEditable(false);
        DifficultyTextField4.setBounds(573, 435, 230, 35);
        getContentPane().add(DifficultyTextField4);
        DifficultyTextField4.setColumns(10);
        
//////////////////////////////////////////////////////////////////////////////////////////           
        usernameTextField = new JTextField();
        usernameTextField.setEditable(false);
        usernameTextField.setBackground(new Color(192, 192, 192));
        usernameTextField.setFont(new Font("굴림", Font.BOLD, 20));
        usernameTextField.setText(names.get(user_id));
        usernameTextField.setBounds(173, 33, 143, 47);
        getContentPane().add(usernameTextField);
        usernameTextField.setColumns(10);
                     
        userlevelTextField = new JTextField();
        userlevelTextField.setEditable(false);
        userlevelTextField.setBackground(new Color(192, 192, 192));
        userlevelTextField.setFont(new Font("굴림", Font.BOLD, 20));
        userlevelTextField.setText(levels.get(user_id));
        userlevelTextField.setBounds(420, 33, 120, 47);
        getContentPane().add(userlevelTextField);
        userlevelTextField.setColumns(10);
               
        userhighscoreTextField = new JTextField();
        userhighscoreTextField.setEditable(false);
        userhighscoreTextField.setBackground(new Color(192, 192, 192));
        userhighscoreTextField.setFont(new Font("굴림", Font.BOLD, 20));
        userhighscoreTextField.setText(highscores.get(user_id));
        userhighscoreTextField.setBounds(683, 33, 120, 47);
        getContentPane().add(userhighscoreTextField);
        userhighscoreTextField.setColumns(10);
 //////////////////////////////////////////////////////////////////////////////////////////       

        

        


        
        ProgressNum1 = new JTextField();
        ProgressNum1.setEditable(false);
        ProgressNum1.setText("1");
        ProgressNum1.setBounds(161, 118, 96, 21);
        getContentPane().add(ProgressNum1);
        ProgressNum1.setColumns(10);
      
        ProgressNum2 = new JTextField();
        ProgressNum2.setEditable(false);
        ProgressNum2.setText("2");
        ProgressNum2.setBounds(161, 298, 96, 21);
        getContentPane().add(ProgressNum2);
        ProgressNum2.setColumns(10);
        
        ProgressNum4 = new JTextField();
        ProgressNum4.setText("4");
        ProgressNum4.setEditable(false);
        ProgressNum4.setBounds(573, 298, 96, 21);
        getContentPane().add(ProgressNum4);
        ProgressNum4.setColumns(10);
        
        ProgressNum3 = new JTextField();
        ProgressNum3.setText("3");
        ProgressNum3.setEditable(false);
        ProgressNum3.setBounds(573, 118, 96, 21);
        getContentPane().add(ProgressNum3);
        ProgressNum3.setColumns(10);
    
        
//////////////////////////////////////////////////////////////////////////////////////////   
        
        JLabel UserLabel = new JLabel("사용자:");
        UserLabel.setFont(new Font("굴림", Font.BOLD, 20));
        UserLabel.setBounds(101, 33, 106, 47);
        getContentPane().add(UserLabel);
        
        JLabel levelLabel = new JLabel("단계:");
        levelLabel.setFont(new Font("굴림", Font.BOLD, 20));
        levelLabel.setBounds(371, 39, 129, 47);
        getContentPane().add(levelLabel);
        
        JLabel highscoreLabel = new JLabel("최고점수:");
        highscoreLabel.setFont(new Font("굴림", Font.BOLD, 20));
        highscoreLabel.setBounds(586, 39, 116, 47);
        getContentPane().add(highscoreLabel);
        
        JLabel lblNewLabel = new JLabel("|");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel.setBounds(317, 32, 50, 48);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("|");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel_1.setBounds(539, 39, 50, 45);
        getContentPane().add(lblNewLabel_1);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(94, 34, 733, 47);
        getContentPane().add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(84, 25, 750, 64);
        getContentPane().add(panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(3, 99, 1021, 394);
        getContentPane().add(panel_2);
        

        
        

        

        

        
        

        
        
        

        

        
		
		setResizable(false);/// 크기 고정
		setSize(1050, 600);
		setVisible(true);
	}
	
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EngStudy();
        });
    }
}
