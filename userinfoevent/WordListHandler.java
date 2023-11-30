package userinfoevent;

public class WordListHandler {
    private String selectedWord = "신승우";

    public void setSelectedWord(String selectedWord) {
        this.selectedWord = selectedWord;
//        System.out.println(this.selectedWord);
    }

    public String getSelectedWord() {
//        System.out.println(1);
        return selectedWord;
    }
}
