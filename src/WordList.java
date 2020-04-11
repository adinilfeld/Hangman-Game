import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WordList {

    private Scanner sc;
    private ArrayList<String> wordList;

    public WordList(File file) {
        openFile(file);
        readFile();
    }

    public String getRandom() {
        int randomIndex = (int) (Math.random() * wordList.size());
        return wordList.get(randomIndex).toLowerCase();
    }

    private void openFile(File file) {
        try {
            sc = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Word list file not found.");
            System.exit(-1);
        }
    }

    private void readFile() {
        wordList = new ArrayList<>();
        // sc.useDelimiter(",");
        while (sc.hasNext()) {
            wordList.add(sc.next());
        }
        sc.close();
    }

    // for testing
//    public static void main(String[] args) {
//        WordList test = new WordList();
//        for (String str : test.wordList) {
//            System.out.println(str);
//        }
//    }

}
