import java.io.File;
import java.util.*;

/**
 * A Board class for the Phrase Solver game, which stores the
 * secret phrase to be guessed, and processes player guesses
 * and game progress.
 * 
 * Date updated: 06 Nov 2023
 * 
 * @author Rocket Uzarraga
 * @author Ryan Ramakrishnan
 * @version %I%, %G%
 * @since 1.0
 */
public class Board {
    private List<String> phrases; // An import from a text file?
    private String phrase;
    private String solvedPhrase = "";
    private int currentLetterValue;
    private Player currentTurn;

    /**
     * Constructor for Board. Grabs a random phrase from the
     * phrase.txt file and sets it as the phrase attribute, then
     * generates a random letter value and sets it to the
     * 'currentLetterValue' attribute.
     */
    public Board() {
        phrase = loadPhrase();
        setLetterValue();
    }

    /**
     * An accessor method to retrive the current letter value
     * of a Board object.
     * 
     * @return an int representing the current letter guess value
     */
    public int getLetterValue() {
        return currentLetterValue;
    }

    /**
     * An accessor method for the solvedPhrase attribute of a
     * Board object to get a read on the game progress.
     * 
     * @return a String representing how much the game progress
     */
    public String gameStatus() {
        return solvedPhrase;
    }

    /* ---------- provided code, do not modify ---------- */
    public void setLetterValue() {
        int randomInt = (int) (Math.random() * 11) * 100;
        currentLetterValue = randomInt;
    }

    public boolean isSolved(String guess) {
        if (phrase.equals(guess)) {
            return true;
        }
        return false;
    }

    // Can i change this pls
    private String loadPhrase() {
        String tempPhrase = "";

        int numOfLines = 0;
        try {
            Scanner sc = new Scanner(new File("phrases.txt"));
            while (sc.hasNextLine()) {
                tempPhrase = sc.nextLine().trim();
                numOfLines++;
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing phrases.txt");
        }

        int randomInt = (int) ((Math.random() * numOfLines) + 1);

        try {
            int count = 0;
            Scanner sc = new Scanner(new File("phrases.txt"));
            while (sc.hasNextLine()) {
                count++;
                String temp = sc.nextLine().trim();
                if (count == randomInt) {
                    tempPhrase = temp;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing phrases.txt");
        }

        for (int i = 0; i < tempPhrase.length(); i++) {
            if (tempPhrase.substring(i, i + 1).equals(" ")) {
                solvedPhrase += "  ";
            } else {
                solvedPhrase += "_ ";
            }
        }

        return tempPhrase.toUpperCase();
    }

    /*
     * Checks to see what letters in the guessed word match the actual phrase
     * 
     * Preconditions:
     * phrase exists and isn't an empty string or null
     * Postcondition:
     * The instance newSolvedPhrase is populated.
     * The instance sovledPhrase is populated.
     */
    public boolean guessLetter(String guess) {
        boolean foundLetter = false;
        String newSolvedPhrase = "";

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.substring(i, i + 1).equals(guess)) {
                newSolvedPhrase += guess + " ";
                foundLetter = true;
            } else {
                newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";
            }
        }
        solvedPhrase = newSolvedPhrase;
        return foundLetter;
    }

}
