package englishword;

import java.io.*;
import java.util.ArrayList;

public class UserInfo {
	
	public void updateUserInfo(String newName, String newLevel, String newHighscore,String newprogressNum) {
	    // 이전 값들을 모두 제거
	    names.clear();
	    levels.clear();
	    highscores.clear();
	    progressNums.clear();
	    // 새로운 값을 추가
	    names.add(newName);
	    levels.add(newLevel);
	    highscores.add(newHighscore);
	    progressNums.add(newprogressNum);
	}
	
	
    private ArrayList<String> names;
    private ArrayList<String> levels;
    private ArrayList<String> highscores;
    private ArrayList<String> progressNums;

    public UserInfo() {
    	names = new ArrayList<>();
    	levels = new ArrayList<>();
    	highscores = new ArrayList<>();
    	progressNums = new ArrayList<>();
    }

    public void addWord(String name, String level, String highscore, String progressNum) {
    	names.add(name);
    	levels.add(level);
    	highscores.add(highscore);
    	progressNums.add(progressNum);
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < names.size(); i++) {
                writer.println(names.get(i) + "," + levels.get(i) + "," + highscores.get(i) + "," + progressNums.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserInfo loadFromFile(String fileName) {
    	UserInfo userInfo = new UserInfo();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                userInfo.addWord(parts[0], parts[1], parts[2], parts[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInfo;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<String> getLevels() {
        return levels;
    }

    public ArrayList<String> getHighscores() {
        return highscores;
    }
    public ArrayList<String> getProgressNums() {
        return progressNums;
    }
    

}


//	UserInfo userInfo = new UserInfo();
//userInfo.updateUserInfo(names.get(i), levels.get(i), highscores.get(i), k);


