import java.io.File;
import java.util.Scanner;

public class HangmanGame {

    private int mistakesRemaining;
    private Word word;
    private boolean playAgain;

    public HangmanGame() {
        playAgain = true;
        WordList allWords = new WordList(new File("WordList.txt"));

        while (playAgain) {
            mistakesRemaining = 6;

            word = new Word(allWords.getRandom());
            System.out.println("Welcome to Hangman!\n");
            System.out.println("Mistakes remaining: " + mistakesRemaining);

            while (mistakesRemaining > 0 && !word.allGuessed()) {
                System.out.println(word);
                guess(getGuessFromUser());
            }

            if (word.allGuessed()) {
                System.out.println("Great job!");
            } else {
                System.out.println("You're out of guesses.");
            }
            System.out.println("The word was: " + word.getWord() + ".\n");
            System.out.println("Play again? (Y/N)");
            if (getTFFromUser() == 'n') {
                playAgain = false;
                System.out.println("\nThanks for playing!");
            } else System.out.println();
        }
    }

    private char getGuessFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a letter: ");
        String userInput = sc.nextLine();
        while (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {
            System.out.print("Please enter a single letter: ");
            userInput = sc.nextLine();
        }
        return Character.toLowerCase(userInput.charAt(0));
    }

    private char getTFFromUser() {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        while (userInput.length() != 1
                || (Character.toLowerCase(userInput.charAt(0)) != 'y'
                && Character.toLowerCase(userInput.charAt(0)) != 'n')) {
            System.out.print("Please enter \"Y\" or \"N\": ");
            userInput = sc.nextLine();
        }
        return Character.toLowerCase(userInput.charAt(0));
    }

    private void guess(char letter) {
        if (word.alreadyGuessed(letter)) {
            System.out.println("You already guessed " + letter + ".\n");
            return;
        } else {
            word.guessLetter(letter);
        }

        if (word.contains(letter)) {
            word.reveal(letter);
            System.out.println("You got it!" + "\n");
        } else {
            System.out.println("Not quite!" + "\n");
            mistakesRemaining--;
            System.out.println("Mistakes remaining: " + mistakesRemaining);
        }
    }

    // main driver
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
    }

}
