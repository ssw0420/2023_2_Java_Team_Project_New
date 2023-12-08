package englishword;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import DB.*;

import java.sql.SQLException;


public class WordStudy extends JPanel{
	ImageIcon icon;
	private static final long serialVersionUID = 2L;
	private JTextArea WordEngTextField1;
	private JTextField usernameTextField;
	private JTextField userlevelTextField;
	private JTextField userhighscoreTextField;
	private JTextArea WordEngTextField2;
	private JTextField ProgressNum1;
	private JTextField ProgressNum2;
	private JTextArea WordEngTextField3;
	private JTextArea WordEngTextField4;
	private JTextField ProgressNum4;
	private JTextField ProgressNum3;
	private JTextField SearchtextField;
	private JTextField WordEngTextField11;
	private JTextField WordEngTextField22;
	private JTextField WordEngTextField33;
	private JTextField WordEngTextField44;
	private JDialog exitDialog;
	
	UserInformation cu = new UserInformation();
	UserDBConnection DBConn = new UserDBConnection();
	WordDBConnection WDBConn = new WordDBConnection();
	
	
//	UserInfo loadedUserInfo = UserInfo.loadFromFile("src\\swing\\userlist2.txt");
//	ArrayList<String> names = loadedUserInfo.getNames();
//	ArrayList<String> levels = loadedUserInfo.getLevels();
//	ArrayList<String> highscores = loadedUserInfo.getHighscores();
//
//	EngWord loadedEngWord = EngWord.loadFromFile("src\\swing\\wordlist2.txt");
//	ArrayList<String> words = loadedEngWord.getWords();
//	ArrayList<String> meanings = loadedEngWord.getMeanings();
//	ArrayList<String> pronunciations = loadedEngWord.getPronunciations();
	int i =0;
///////////////////////////////////////////////////////////////////////////////////	
/**
 * @throws SQLException *******************************************************************************/
///////////////////////////////////////////////////////////////////////////////////	
	public WordStudy(MainUI MainFrame, String username) throws SQLException {
		String[] user = DBConn.BringUserInfo(MainUI.username);
		String[] words = WDBConn.BringWordEng(MainUI.username);
		String[] meanings = WDBConn.BringWordKor(MainUI.username);
		String[] pronunciations = WDBConn.BringWordPronunciation(MainUI.username);
		
		cu.name = user[0];
		cu.diff = user[1];
		cu.highscore = user[2];
		cu.lastword = Integer.parseInt(user[3]);
		
		setBackground(new Color(176, 196, 222));
		setBounds(140, 120, 1000, 550);
		setSize(1280, 800); // 화면 크기 설정
		setLayout(null);
		
		exitDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "돌아가기", true);
        exitDialog.getContentPane().setLayout(null);
		
		
		JButton ExitButton = new JButton("나가기");
		ExitButton.setBounds(12, 10, 103, 33);
		add(ExitButton);
		ExitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame.showPanel("wordMenuPage", null);
        		} 	
        });
		
		JButton nextButton = new JButton(">>>");
		nextButton.setFont(new Font("굴림", Font.BOLD, 20));
		nextButton.setBounds(1056, 359, 130, 70);
		add(nextButton);
        nextButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (i < words.length - 2) {
        			i = i + 4; // i를 증가시킴
        			try {
						updateTextFields();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // 텍스트 필드 업데이트
        		}
        	}
        });
        
        JButton prevButton = new JButton("<<<");
        prevButton.setFont(new Font("굴림", Font.BOLD, 20));
        prevButton.setBounds(80, 359, 130, 70);
        add(prevButton);
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                if (i > 0) {
                    i= i - 4; // i를 감소시킴
                    try {
						updateTextFields();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // 텍스트 필드 업데이트
                }
            }
        });
        
        
   	    JButton SaveProgress_ = new JButton("책갈피");
   	    SaveProgress_.setBounds(1000, 10, 100, 70);
        add(SaveProgress_);
        SaveProgress_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					DBConn.UpdateLastWord(cu.name, i);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        
        JButton saveButton = new JButton("불러오기");
        saveButton.setBounds(1122, 10, 100, 70);
        add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	WordEngTextField1.setText(words[cu.lastword]+"\n\n"+meanings[cu.lastword]);
            	
        	    WordEngTextField2.setText(words[cu.lastword+1] + "\n\n"+ meanings[cu.lastword+1]);
  
            	WordEngTextField3.setText(words[cu.lastword+2]+"\n\n"+meanings[cu.lastword+2]);

        	    WordEngTextField4.setText(words[cu.lastword+3]+"\n\n"+meanings[cu.lastword+3]);
        	    
        	    ProgressNum1.setText(Integer.toString(cu.lastword+1));
        	    ProgressNum2.setText(Integer.toString(cu.lastword+2));
        	    ProgressNum3.setText(Integer.toString(cu.lastword+3));
        	    ProgressNum4.setText(Integer.toString(cu.lastword+4));
        	    
            	WordEngTextField11.setText(pronunciations[cu.lastword]);
            	WordEngTextField22.setText(pronunciations[cu.lastword+1]);
            	WordEngTextField33.setText(pronunciations[cu.lastword+2]);
            	WordEngTextField44.setText(pronunciations[cu.lastword+3]);

        	    i = cu.lastword;
            }
        });
        
        
        WordEngTextField11 = new JTextField();
        WordEngTextField11.setEditable(false);
        WordEngTextField11.setText("["+pronunciations[i]+"]");
        WordEngTextField11.setFont(new Font("Charis SIL", Font.BOLD, 25));
        WordEngTextField11.setBounds(240, 315, 300, 70);
        WordEngTextField11.setBorder(null);
        add(WordEngTextField11);
        WordEngTextField11.setColumns(10);
        
        WordEngTextField22 = new JTextField();
        WordEngTextField22.setEditable(false);
        WordEngTextField22.setText("["+pronunciations[i+1]+"]");
        WordEngTextField22.setFont(new Font("Charis SIL", Font.BOLD, 25));
        WordEngTextField22.setBounds(240, 630, 300, 70);
        WordEngTextField22.setBorder(null);
        add(WordEngTextField22);
        WordEngTextField22.setColumns(10);
        
        WordEngTextField33 = new JTextField();
        WordEngTextField33.setEditable(false);
        WordEngTextField33.setText("["+pronunciations[i+2]+"]");
        WordEngTextField33.setFont(new Font("Charis SIL", Font.BOLD, 25));
        WordEngTextField33.setBounds(740, 315, 300, 70);
        WordEngTextField33.setBorder(null);
        add(WordEngTextField33);
        WordEngTextField33.setColumns(10);
        
        WordEngTextField44 = new JTextField();
        WordEngTextField44.setEditable(false);
        WordEngTextField44.setFont(new Font("Charis SIL", Font.BOLD, 25));
        WordEngTextField44.setText("["+pronunciations[i+3]+"]");
        WordEngTextField44.setBounds(740, 630, 300, 70);
        WordEngTextField44.setBorder(null);
        add(WordEngTextField44);
        WordEngTextField44.setColumns(10);
        

        
        
        WordEngTextField1 = new JTextArea();
        WordEngTextField1.setBackground(new Color(255, 255, 255));
        WordEngTextField1.setForeground(new Color(0, 0, 0));
        WordEngTextField1.setEditable(false);
        WordEngTextField1.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 25));
        WordEngTextField1.setText(words[i]+"\n\n"+ meanings[i]);
        WordEngTextField1.setBounds(240, 185, 300, 200);
        add(WordEngTextField1);
        WordEngTextField1.setColumns(10);

        
        
        WordEngTextField2 = new JTextArea();
        WordEngTextField2.setEditable(false);
        WordEngTextField2.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 25));
        WordEngTextField2.setText(words[i+1]+"\n\n"+ meanings[i+1]);
        WordEngTextField2.setBounds(240, 500, 300, 200);
        add(WordEngTextField2);
        WordEngTextField2.setColumns(10);       
        
        WordEngTextField3 = new JTextArea();
        WordEngTextField3.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 25));
        WordEngTextField3.setEditable(false);
        WordEngTextField3.setText(words[i+2]+"\n\n"+ meanings[i+2]);
        WordEngTextField3.setBounds(740, 185, 300, 200);
        add(WordEngTextField3);
        WordEngTextField3.setColumns(10);   
        
        WordEngTextField4 = new JTextArea();
        WordEngTextField4.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 25));
        WordEngTextField4.setText(words[i+3]+"\n\n"+ meanings[i+3]);
        WordEngTextField4.setEditable(false);
        WordEngTextField4.setBounds(740, 500, 300, 200);
        add(WordEngTextField4);
        WordEngTextField4.setColumns(10);
        
//////////////////////////////////////////////////////////////////////////////////////////           
        usernameTextField = new JTextField();
        usernameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        usernameTextField.setEditable(false);
        usernameTextField.setBackground(Color.WHITE);
        usernameTextField.setFont(new Font("굴림", Font.BOLD, 20));
        usernameTextField.setText(cu.name);
        usernameTextField.setBounds(150, 80, 150, 50);
        add(usernameTextField);
        usernameTextField.setColumns(10);
                     
        userlevelTextField = new JTextField();
        userlevelTextField.setHorizontalAlignment(SwingConstants.CENTER);
        userlevelTextField.setEditable(false);
        userlevelTextField.setBackground(Color.WHITE);
        userlevelTextField.setFont(new Font("굴림", Font.BOLD, 20));
        userlevelTextField.setText(cu.diff);
        userlevelTextField.setBounds(381, 80, 120, 50);
        add(userlevelTextField);
        userlevelTextField.setColumns(10);
               
        userhighscoreTextField = new JTextField();
        userhighscoreTextField.setHorizontalAlignment(SwingConstants.CENTER);
        userhighscoreTextField.setEditable(false);
        userhighscoreTextField.setBackground(Color.WHITE);
        userhighscoreTextField.setFont(new Font("굴림", Font.BOLD, 20));
        userhighscoreTextField.setText(cu.highscore);
        userhighscoreTextField.setBounds(625, 80, 120, 50);
        add(userhighscoreTextField);
        userhighscoreTextField.setColumns(10);
 //////////////////////////////////////////////////////////////////////////////////////////       

        
        ProgressNum1 = new JTextField();
        ProgressNum1.setEditable(false);
        ProgressNum1.setText("1");
        ProgressNum1.setBounds(240, 155, 96, 21);
        add(ProgressNum1);
        ProgressNum1.setColumns(10);
      
        ProgressNum2 = new JTextField();
        ProgressNum2.setEditable(false);
        ProgressNum2.setText("2");
        ProgressNum2.setBounds(240, 470, 96, 21);
        add(ProgressNum2);
        ProgressNum2.setColumns(10);
        
        ProgressNum4 = new JTextField();
        ProgressNum4.setText("4");
        ProgressNum4.setEditable(false);
        ProgressNum4.setBounds(740, 470, 96, 21);
        add(ProgressNum4);
        ProgressNum4.setColumns(10);
        
        ProgressNum3 = new JTextField();
        ProgressNum3.setText("3");
        ProgressNum3.setEditable(false);
        ProgressNum3.setBounds(740, 155, 96, 21);
        add(ProgressNum3);
        ProgressNum3.setColumns(10);
    
        
//////////////////////////////////////////////////////////////////////////////////////////   
        
        JLabel UserLabel = new JLabel("사용자:");
        UserLabel.setFont(new Font("굴림", Font.BOLD, 20));
        UserLabel.setBounds(80, 80, 100, 50);
        add(UserLabel);
        
        JLabel levelLabel = new JLabel("단계:");
        levelLabel.setFont(new Font("굴림", Font.BOLD, 20));
        levelLabel.setBounds(333, 80, 129, 50);
        add(levelLabel);
        
        JLabel highscoreLabel = new JLabel("최고점수:");
        highscoreLabel.setFont(new Font("굴림", Font.BOLD, 20));
        highscoreLabel.setBounds(538, 80, 116, 50);
        add(highscoreLabel);
        
        JLabel lblNewLabel = new JLabel("|");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel.setBounds(295, 80, 50, 50);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("|");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel_1.setBounds(499, 80, 50, 50);
        add(lblNewLabel_1);
        
        
        
        
        SearchtextField = new JTextField();
        SearchtextField.setText("");
        SearchtextField.setBounds(806, 90, 270, 35);
        add(SearchtextField);
        SearchtextField.setColumns(10);
        
        JButton SearchButton = new JButton("검색");
        SearchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String searchKeyword = SearchtextField.getText().trim().toLowerCase();

                
                int searchIndex = -1;
                for (int j = 0; j < words.length; j++) {
                    if (words[j].toLowerCase().contains(searchKeyword) || meanings[j].toLowerCase().contains(searchKeyword)) {
                        searchIndex = j;
                        break;
                    }
                }

               
                if (searchIndex != -1) {
                	if(searchIndex > words.length || searchIndex < 0)
                		i = 0;
                		
                	if((searchIndex % 4) == 0 || searchIndex == 4) {
                		i = searchIndex;
                		try {
							updateTextFields();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                	}
                	else if((searchIndex % 4) == 3 || searchIndex == 3) {
                		i = searchIndex+1;
                		try {
							updateTextFields();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                	}
                	
                	else if(((searchIndex % 4) == 2) || searchIndex == 2) {
                		i = searchIndex-2;
                		try {
							updateTextFields();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                	}
                	else if((searchIndex % 4) == 1 || searchIndex == 1) {
                		i = searchIndex-1;
                		try {
							updateTextFields();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                	}

                } else {
                   
                    JOptionPane.showMessageDialog(null, "단어를 찾을 수 없습니다.", "검색 결과", JOptionPane.INFORMATION_MESSAGE);
                }
        		
        		
        	}
        });
        SearchButton.setHorizontalAlignment(SwingConstants.LEADING);
        SearchButton.setBounds(1088, 90, 62, 35);
        add(SearchButton);
        
   
        
		
	}
	
	private void updateTextFields() throws SQLException {
		
		String[] words = WDBConn.BringWordEng(MainUI.username);
		String[] meanings = WDBConn.BringWordKor(MainUI.username);
		String[] pronunciations = WDBConn.BringWordPronunciation(MainUI.username);
		
    	WordEngTextField11.setText("["+pronunciations[i]+"]");
    	WordEngTextField22.setText("["+pronunciations[i+1]+"]");
    	WordEngTextField33.setText("["+pronunciations[i+2]+"]");
    	WordEngTextField44.setText("["+pronunciations[i+3]+"]");
		
	    WordEngTextField1.setText(words[i]+"\n\n"+meanings[i]);

	    WordEngTextField2.setText(words[i+1]+"\n\n"+meanings[i+1]);

	    WordEngTextField3.setText(words[i+2]+"\n\n"+meanings[i+2]);

	    WordEngTextField4.setText(words[i+3]+"\n\n"+meanings[i+3]);

	  
	    ProgressNum1.setText(Integer.toString(i+1));
	    ProgressNum2.setText(Integer.toString(i+2));
	    ProgressNum3.setText(Integer.toString(i+3));
	    ProgressNum4.setText(Integer.toString(i+4));

	    
	}
	
	public class UserInformation {
		public String name;
		public String diff;
		public String highscore;
		public int lastword;
	}

}