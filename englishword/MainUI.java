package englishword;

import DB.*;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.SQLException;

public class MainUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    public String[] none = null;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    DefaultListModel<String> listModel = new DefaultListModel<>();
    public static String username;
    /**
     * Launch the application.
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainUI frame = new MainUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @throws SQLException 
     */
    public MainUI() throws SQLException {    
        UserDBConnection DBConn = new UserDBConnection();
        DBConn.DB_Connect();
        String[] name = DBConn.BringUser();
        for (String s : name) {
            listModel.addElement(s);
        }
        setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 15));
        setTitle("영단어 학습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 800); // 화면 크기 설정
        setLocationRelativeTo(null); // 화면을 중앙에 표시
        setResizable(false); // 화면 크기 설정 불가

        // 화면 이동을 위한 설정
        cardLayout = new CardLayout();

        mainPanel = new JPanel(cardLayout);
        mainPanel.setForeground(new Color(0, 0, 0));
        mainPanel.setBackground(new Color(230, 230, 250));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainPanel);
        
        // 시작 페이지 화면
        JPanel startPage = new JPanel();
        startPage.setBackground(new Color(176, 196, 222));
        startPage.setBounds(140, 120, 1000, 550);
        mainPanel.add(startPage, "startPage");
        startPage.setLayout(null);

        // 시작 페이지 상단 제목
        JLabel mainName = new JLabel("영어 단어 학습");
        mainName.setHorizontalAlignment(SwingConstants.CENTER);
        mainName.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 40));
        mainName.setBounds(500, 22, 300, 72);
        startPage.add(mainName);

        // 유저 생성 버튼
        JButton createButton = new JButton("생 성");
        createButton.setBackground(new Color(245, 245, 245));
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel("createUserPage", none);
            }
        });
        createButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 16));
        createButton.setBounds(1057, 145, 130, 70);
        startPage.add(createButton);

        // 미구현 - 유저 목록
        JPanel UserListPanel = new JPanel();
        UserListPanel.setBounds(200, 145, 800, 360);
        startPage.add(UserListPanel);
        UserListPanel.setLayout(null);

        JList<String> list = new JList<>(listModel);
        list.setBounds(10, 10, 747, 340);
        list.setSelectedIndex(0);
        UserListPanel.add(list);

        // 메인 화면 버튼
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                username = list.getSelectedValue();
            }
        });
        JButton startButton = new JButton("시 작");
        startButton.addActionListener(this);
        startButton.setForeground(new Color(255, 255, 255));
        startButton.setBackground(new Color(173, 216, 230));
        startButton.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 30));
        startButton.setBounds(540, 600, 200, 70);
        startPage.add(startButton);
    }

    public void showPanel(String panelName, String[] list) {
        cardLayout.show(mainPanel, panelName);
        if (panelName.equals("startPage")) {
            listModel.clear();
            for(int i=0;i<list.length;i++)
                listModel.addElement(list[i]);
        }
    }

    public void actionPerformed(ActionEvent e) {

        CreateUser createUserPage = new CreateUser(this);
        mainPanel.add(createUserPage, "createUserPage");
        createUserPage.setVisible(false);
        
        // 메인 화면
        WordMenu wordMenuPage;
        try {
            wordMenuPage = new WordMenu(this, username);
            mainPanel.add(wordMenuPage, "wordMenuPage");
            wordMenuPage.setVisible(false);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        // 단어 퀴즈 화면
        WordQuiz wordQuizPage;
        try {
            wordQuizPage = new WordQuiz(this, username);
            mainPanel.add(wordQuizPage, "wordQuizPage");
            wordQuizPage.setVisible(false);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        showPanel("wordMenuPage", none);
    }
}