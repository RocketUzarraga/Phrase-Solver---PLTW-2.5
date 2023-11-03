/**
 * A Player class to represent the players in the Phrase
 * Solver game, storing their names and scores.
 * 
 * Date updated: 31 Oct 2023
 * 
 * @author Rocket Uzarraga
 * @author Ryan Ramakrishnan
 * @version %I%, %G%
 * @since 1.0
 */
public class Player {
    private String name;
    private int score = 0;

    /**
     * Constructor for Player. Sets the player 'name' attribute
     * to the inputted paramater.
     * 
     * @param n - A String param for the player name
     */
    public Player(String n) {
        name = n;
    }


    /**
     * Default constructor for player. Sets the player 'name'
     * attribute to "No name" if no parameter is entered.
     */
    public Player() {
        name = "No name";
    }


    /**
     * An accessor method to retrieve the name of a Player object
     * 
     * @return a String representing the player name
     */
    public String getName() {
        return name;
    }


    /**
     * An accessor method to retrive the score of a Player object
     * 
     * @return an int representing the player score
     */
    public int getScore() {
        return score;
    }

    

    /**
     * Set the Player object score attribute to a value
     * @param s - An int param to set new score to
     */
    public void setScore(int s) {
        score = s;
    }

}
