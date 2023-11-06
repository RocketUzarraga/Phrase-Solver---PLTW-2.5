import java.util.*;

/**
 * Phrase Solver, a class to run a game where players guess letters
 * or full phrases in order to correctly discover a secret phrase.
 * 
 * Date updated: 31 Oct 2023
 * 
 * @author Rocket Uzarraga
 * @author Ryan Ramakrishnan
 * @version %I%, %G%
 * @since 1.0
 */
class PhraseSolver {
    private List<Player> players = new ArrayList<Player>();
    private Board board;
    private boolean solved = false;
    private String guessed = "";
    private Scanner input;

    /**
     * Constructor for PhraseSolver class. Intializes a board object
     * and an amount of Player objects. Takes a paramater for amount of
     * players as well as the names of the players,setting them to
     * "Player #" by default if no input entered. Uses a precondition
     * that np > 1 to set up a proper multiplayer game to play.
     * 
     * @param np - an int param to determine amount of players
     */
    public PhraseSolver(int np, Scanner s) {
        // Set up precondition in Runner.java?
        input = s;
        // Loop for as many times as np
        for (int i = 1; i <= np; i++) {
            // Ask input for player # name
            System.out.print("Player " + i + " name: ");
            String name = input.nextLine();

            // Add each Player object to ArrayList
            if (name.strip().equals("")) {
                // Default to player # for a name
                players.add(new Player("Player " + i));
            } else {
                players.add(new Player(name));
            }
        }
        // Set up Board object
        board = new Board();
        System.out.println("\nWelcome to Phrase Solver (not a Wheel of Fortune ripoff)\n");
    }

    /**
     * A play method for the PhraseSolver class, to initiate a game loop.
     * Will go through each Player in the ArrayList, take their input, and determine
     * game actions based on their inputs, and change scores accordingly.
     */
    public void play() {
        String guess = "";
        // Game loop. Designed to loop through array list indexes.
        for (int turn = 0; !solved; turn = (turn + 1) % players.size()) {
            // Change turn
            Player current = players.get(turn);
            // Print game info
            System.out.println(current.getName() + "'s turn. Current money: $" + current.getScore());
            System.out.println("Your wheel spin: $" + board.getLetterValue());
            System.out.println("Guesed letters: " + guessed);
            System.out.println("Game progress: " + board.gameStaus());
            System.out.print("Make a guess: ");

            // Get user input (strip spaces, uniform letter casing)
            guess = input.nextLine().strip().toUpperCase();

            // Phrase guess conditional
            if (guess.length() > 1) {
                // Guess is correct?
                if (board.isSolved(guess)) {
                    solved = true;
                    current.setScore(current.getScore() + board.getLetterValue());
                    System.out.println("Congrats " + current.getName() + "! You get $" + current.getScore() + "!");
                    // Guess is not correct
                } else {
                    System.out.println("Your guess was incorrect. Skill issue.");
                }

                // Letter guess conditional
            } else {
                // Prevent guessing of same letter
                if (guessed.contains(guess)) {
                    System.out.println("That's been guessed already. Bad. Skipping your turn.");

                } else {
                    guessed += guess + " ";
                    // Guess is in phrase?
                    if (board.guessLetter(guess)) {
                        System.out.println("That's in the phrase! Adding $" + board.getLetterValue());
                        current.setScore(current.getScore() + board.getLetterValue());
                        // Guess isn't in phrase.
                    } else {
                        System.out.println("That's not it! You lose your turn.");
                    }
                }
            }
            // Line spacing
            System.out.println("\n");
            // Set new letter value
            board.setLetterValue();
        }
    }

}