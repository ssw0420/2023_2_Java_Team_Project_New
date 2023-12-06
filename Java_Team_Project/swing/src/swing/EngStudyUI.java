package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class EngStudyUI extends JFrame{
	ImageIcon icon;
		
	private JPanel Panele;
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
	
	public EngStudyUI() {
		getContentPane().setFont(new Font("굴림", Font.BOLD, 20));
		getContentPane().setBackground(SystemColor.activeCaption);
		WordMemorizeUI();
	}
	UserInfo loadedUserInfo = UserInfo.loadFromFile("src\\swing\\userlist2.txt");
	ArrayList<String> names = loadedUserInfo.getNames();
	ArrayList<String> levels = loadedUserInfo.getLevels();
	ArrayList<String> highscores = loadedUserInfo.getHighscores();

	EngWord loadedEngWord = EngWord.loadFromFile("src\\swing\\wordlist2.txt");
	ArrayList<String> words = loadedEngWord.getWords();
	ArrayList<String> meanings = loadedEngWord.getMeanings();
	ArrayList<String> pronunciations = loadedEngWord.getPronunciations();
	
	
	
	int user_id = 0;
	int i =0;
	int save = 0 ;

	
	private void updateTextFields() {
		
    	WordEngTextField11.setText(pronunciations.get(i));
    	WordEngTextField22.setText(pronunciations.get(i + 1));
    	WordEngTextField33.setText(pronunciations.get(i+2));
    	WordEngTextField44.setText(pronunciations.get(i + 3));
		
	    WordEngTextField1.setText(words.get(i)+"\n\n"+meanings.get(i));

	    WordEngTextField2.setText(words.get(i + 1)+"\n\n"+meanings.get(i + 1));

	    WordEngTextField3.setText(words.get(i+2)+"\n\n"+meanings.get(i+2));

	    WordEngTextField4.setText(words.get(i + 3)+"\n\n"+meanings.get(i + 3));

	  
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
		ExitButton.setBounds(12, 10, 103, 33);
		getContentPane().add(ExitButton);
		
		JButton nextButton = new JButton(">>>");
		nextButton.setFont(new Font("굴림", Font.BOLD, 20));
		nextButton.setBounds(1056, 359, 130, 70);
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
        prevButton.setBounds(80, 359, 130, 70);
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
   	    SaveProgress_.setBounds(1000, 10, 100, 70);
        getContentPane().add(SaveProgress_);
        SaveProgress_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	UserInfo userInfo = new UserInfo();
            	userInfo.updateUserInfo(names.get(user_id), levels.get(user_id), highscores.get(user_id), Integer.toString(i+1));
            	userInfo.saveToFile("src\\swing\\userlist.txt");
            	save = i;
            }
        });
        
        
        JButton saveButton = new JButton("불러오기");
        saveButton.setBounds(1122, 10, 100, 70);
        getContentPane().add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	

            	
            	WordEngTextField1.setText(words.get(save)+"\n\n"+meanings.get(save));
            	
        	    WordEngTextField2.setText(words.get(save + 1) + "\n\n"+ meanings.get(save + 1));
  
            	WordEngTextField3.setText(words.get(save)+"\n\n"+meanings.get(save));

        	    WordEngTextField4.setText(words.get(save + 1)+"\n\n"+meanings.get(save + 1));
        	    
        	    ProgressNum1.setText(Integer.toString(save+1));
        	    ProgressNum2.setText(Integer.toString(save+2));
        	    ProgressNum3.setText(Integer.toString(save+3));
        	    ProgressNum4.setText(Integer.toString(save+4));
        	    
            	WordEngTextField11.setText(pronunciations.get(save));
            	WordEngTextField22.setText(pronunciations.get(save + 1));
            	WordEngTextField33.setText(pronunciations.get(save));
            	WordEngTextField44.setText(pronunciations.get(save + 1));

        	    i =save;
            }
        });
        
        
        WordEngTextField11 = new JTextField();
        WordEngTextField11.setEditable(false);
        WordEngTextField11.setText(pronunciations.get(i));
        WordEngTextField11.setFont(new Font("Charis SIL", Font.BOLD, 25));
        WordEngTextField11.setBounds(240, 315, 300, 70);
        WordEngTextField11.setBorder(null);
        getContentPane().add(WordEngTextField11);
        WordEngTextField11.setColumns(10);
        
        WordEngTextField22 = new JTextField();
        WordEngTextField22.setEditable(false);
        WordEngTextField22.setText(pronunciations.get(i+1));
        WordEngTextField22.setFont(new Font("Charis SIL", Font.BOLD, 25));
        WordEngTextField22.setBounds(240, 630, 300, 70);
        WordEngTextField22.setBorder(null);
        getContentPane().add(WordEngTextField22);
        WordEngTextField22.setColumns(10);
        
        WordEngTextField33 = new JTextField();
        WordEngTextField33.setEditable(false);
        WordEngTextField33.setText(pronunciations.get(i+2));
        WordEngTextField33.setFont(new Font("Charis SIL", Font.BOLD, 25));
        WordEngTextField33.setBounds(740, 315, 300, 70);
        WordEngTextField33.setBorder(null);
        getContentPane().add(WordEngTextField33);
        WordEngTextField33.setColumns(10);
        
        WordEngTextField44 = new JTextField();
        WordEngTextField44.setEditable(false);
        WordEngTextField44.setFont(new Font("Charis SIL", Font.BOLD, 25));
        WordEngTextField44.setText(pronunciations.get(i+3));
        WordEngTextField44.setBounds(740, 630, 300, 70);
        WordEngTextField44.setBorder(null);
        getContentPane().add(WordEngTextField44);
        WordEngTextField44.setColumns(10);
        

        
        
        WordEngTextField1 = new JTextArea();
        WordEngTextField1.setBackground(new Color(255, 255, 255));
        WordEngTextField1.setForeground(new Color(0, 0, 0));
        WordEngTextField1.setEditable(false);
        WordEngTextField1.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 25));
        WordEngTextField1.setText(words.get(i)+"\n\n"+ meanings.get(i));
        WordEngTextField1.setBounds(240, 185, 300, 200);
        getContentPane().add(WordEngTextField1);
        WordEngTextField1.setColumns(10);

        
        
        WordEngTextField2 = new JTextArea();
        WordEngTextField2.setEditable(false);
        WordEngTextField2.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 25));
        WordEngTextField2.setText(words.get(i+1)+"\n\n"+meanings.get(i+1));
        WordEngTextField2.setBounds(240, 500, 300, 200);
        getContentPane().add(WordEngTextField2);
        WordEngTextField2.setColumns(10);       
        
        WordEngTextField3 = new JTextArea();
        WordEngTextField3.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 25));
        WordEngTextField3.setEditable(false);
        WordEngTextField3.setText(words.get(i+2)+"\n\n"+meanings.get(i+2));
        WordEngTextField3.setBounds(740, 185, 300, 200);
        getContentPane().add(WordEngTextField3);
        WordEngTextField3.setColumns(10);   
        
        WordEngTextField4 = new JTextArea();
        WordEngTextField4.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 25));
        WordEngTextField4.setText(words.get(i+3)+"\n\n"+meanings.get(i+3));
        WordEngTextField4.setEditable(false);
        WordEngTextField4.setBounds(740, 500, 300, 200);
        getContentPane().add(WordEngTextField4);
        WordEngTextField4.setColumns(10);
        
//////////////////////////////////////////////////////////////////////////////////////////           
        usernameTextField = new JTextField();
        usernameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        usernameTextField.setEditable(false);
        usernameTextField.setBackground(Color.WHITE);
        usernameTextField.setFont(new Font("굴림", Font.BOLD, 20));
        usernameTextField.setText(names.get(user_id));
        usernameTextField.setBounds(150, 80, 150, 50);
        getContentPane().add(usernameTextField);
        usernameTextField.setColumns(10);
                     
        userlevelTextField = new JTextField();
        userlevelTextField.setHorizontalAlignment(SwingConstants.CENTER);
        userlevelTextField.setEditable(false);
        userlevelTextField.setBackground(Color.WHITE);
        userlevelTextField.setFont(new Font("굴림", Font.BOLD, 20));
        userlevelTextField.setText(levels.get(user_id));
        userlevelTextField.setBounds(381, 80, 120, 50);
        getContentPane().add(userlevelTextField);
        userlevelTextField.setColumns(10);
               
        userhighscoreTextField = new JTextField();
        userhighscoreTextField.setHorizontalAlignment(SwingConstants.CENTER);
        userhighscoreTextField.setEditable(false);
        userhighscoreTextField.setBackground(Color.WHITE);
        userhighscoreTextField.setFont(new Font("굴림", Font.BOLD, 20));
        userhighscoreTextField.setText(highscores.get(user_id));
        userhighscoreTextField.setBounds(625, 80, 120, 50);
        getContentPane().add(userhighscoreTextField);
        userhighscoreTextField.setColumns(10);
 //////////////////////////////////////////////////////////////////////////////////////////       

        
        ProgressNum1 = new JTextField();
        ProgressNum1.setEditable(false);
        ProgressNum1.setText("1");
        ProgressNum1.setBounds(240, 155, 96, 21);
        getContentPane().add(ProgressNum1);
        ProgressNum1.setColumns(10);
      
        ProgressNum2 = new JTextField();
        ProgressNum2.setEditable(false);
        ProgressNum2.setText("2");
        ProgressNum2.setBounds(240, 470, 96, 21);
        getContentPane().add(ProgressNum2);
        ProgressNum2.setColumns(10);
        
        ProgressNum4 = new JTextField();
        ProgressNum4.setText("4");
        ProgressNum4.setEditable(false);
        ProgressNum4.setBounds(740, 470, 96, 21);
        getContentPane().add(ProgressNum4);
        ProgressNum4.setColumns(10);
        
        ProgressNum3 = new JTextField();
        ProgressNum3.setText("3");
        ProgressNum3.setEditable(false);
        ProgressNum3.setBounds(740, 155, 96, 21);
        getContentPane().add(ProgressNum3);
        ProgressNum3.setColumns(10);
    
        
//////////////////////////////////////////////////////////////////////////////////////////   
        
        JLabel UserLabel = new JLabel("사용자:");
        UserLabel.setFont(new Font("굴림", Font.BOLD, 20));
        UserLabel.setBounds(80, 80, 100, 50);
        getContentPane().add(UserLabel);
        
        JLabel levelLabel = new JLabel("단계:");
        levelLabel.setFont(new Font("굴림", Font.BOLD, 20));
        levelLabel.setBounds(333, 80, 129, 50);
        getContentPane().add(levelLabel);
        
        JLabel highscoreLabel = new JLabel("최고점수:");
        highscoreLabel.setFont(new Font("굴림", Font.BOLD, 20));
        highscoreLabel.setBounds(538, 80, 116, 50);
        getContentPane().add(highscoreLabel);
        
        JLabel lblNewLabel = new JLabel("|");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel.setBounds(295, 80, 50, 50);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("|");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel_1.setBounds(499, 80, 50, 50);
        getContentPane().add(lblNewLabel_1);
        
        
        
        
        SearchtextField = new JTextField();
        SearchtextField.setText("");
        SearchtextField.setBounds(806, 90, 270, 35);
        getContentPane().add(SearchtextField);
        SearchtextField.setColumns(10);
        
        JButton SearchButton = new JButton("검색");
        SearchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String searchKeyword = SearchtextField.getText().trim().toLowerCase();

                
                int searchIndex = -1;
                for (int j = 0; j < words.size(); j++) {
                    if (words.get(j).toLowerCase().contains(searchKeyword) || meanings.get(j).toLowerCase().contains(searchKeyword)) {
                        searchIndex = j;
                        break;
                    }
                }

               
                if (searchIndex != -1) {
                	if((searchIndex % 4) == 0 || searchIndex == 4) {
                		i = searchIndex+6;
                		updateTextFields();
                	}
                	else if((searchIndex % 3) == 0 || searchIndex == 3) {
                		i = searchIndex+5;
                		updateTextFields();
                	}
                	
                	else if(((searchIndex % 4) == 2) || searchIndex == 2) {
                		i = searchIndex+4;
                		updateTextFields();
                	}
                	else if((searchIndex % 4) == 1 || searchIndex == 1) {
                		i = searchIndex+3;
                		updateTextFields();
                	}

                } else {
                   
                    JOptionPane.showMessageDialog(null, "단어를 찾을 수 없습니다.", "검색 결과", JOptionPane.INFORMATION_MESSAGE);
                }
        		
        		
        	}
        });
        SearchButton.setHorizontalAlignment(SwingConstants.LEADING);
        SearchButton.setBounds(1088, 90, 62, 35);
        getContentPane().add(SearchButton);
        
   
        
		
		setResizable(false);/// 크기 고정
		setSize(1280, 800);
		setVisible(true);
	}
	
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EngStudyUI();
        });
    }
}
