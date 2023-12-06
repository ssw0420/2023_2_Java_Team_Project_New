package swing;

import java.io.*;
import java.util.ArrayList;

public class EngWord {
    private ArrayList<String> words;
    private ArrayList<String> meanings;
    private ArrayList<String> pronunciations;

    public EngWord() {
        words = new ArrayList<>();
        meanings = new ArrayList<>();
        pronunciations = new ArrayList<>();
    }

    public void addWord(String word, String meaning, String pronunciation) {
        words.add(word);
        meanings.add(meaning);
        pronunciations.add(pronunciation);
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < words.size(); i++) {
                writer.println(words.get(i) + "," + meanings.get(i) + "," + pronunciations.get(i)/* + "," + wordlevels.get(i)*/);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EngWord loadFromFile(String fileName) {
        EngWord engWord = new EngWord();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                engWord.addWord(parts[0], parts[1], parts[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return engWord;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public ArrayList<String> getMeanings() {
        return meanings;
    }

    public ArrayList<String> getPronunciations() {
        return pronunciations;
    }
}




