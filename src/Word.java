import java.util.ArrayList;

public class Word {

    private final String word;
    private boolean[] guessed;
    private int unguessedLetters;
    private ArrayList<Character> guessedLetters;

    public Word(String word) {
        this.word = word;
        guessed = new boolean[word.length()];
        unguessedLetters = word.length();
        guessedLetters = new ArrayList<>();

        for (boolean b : guessed) {
            b = false;
        }
    }

    public boolean contains(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) return true;
        }
        return false;
    }

    // letter passed as parameter must be in word
    public void reveal(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                guessed[i] = true;
                unguessedLetters--;
            }
        }
    }

    public void guessLetter(char letter) {
        guessedLetters.add(letter);
    }

    public boolean alreadyGuessed(char letter) {
        return guessedLetters.contains(letter);
    }

    public String toString() {
        String toReturn = "";

        for (int i = 0; i < word.length(); i++) {
            if (guessed[i]) toReturn += word.charAt(i) + " ";
            else toReturn += "_ ";
        }

        return toReturn;
    }

    public String getWord() {
        return word;
    }

    public boolean allGuessed() {
        return unguessedLetters == 0;
    }

    // for testing
//    public static void main(String[] args) {
//        Word word = new Word("adin");
//        System.out.println(word);
//        word.reveal('a');
//        System.out.println(word);
//    }

}
