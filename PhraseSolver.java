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


    /**
     * Constructor for PhraseSolver class. Intializes a board object
     * and an amount of Player objects. Takes a paramater for amount of 
     * players as well as the names of the players,setting them to 
     * "Player #" by default if no input entered. Uses a precondition 
     * that np > 1 to set up a proper multiplayer game to play.
     * 
     * @param np - an int param to determine amount of players
     */
    public PhraseSolver(int np) {
        // Set up precondition in Runner.java?

        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= np; i++) {
            System.out.print("Player " + i + " name: ");
            String name = input.nextLine();
            if (name.strip().equals("")) {
                players.add(new Player("Player " + i));
            } else {
                players.add(new Player(name));
            }
        }
        board = new Board();
    }



    public void play() {

    }

}