import java.util.Scanner;

/**
 * A class made to run the PhraseSolver game. Codes in replay loops
 * and game setup.
 * 
 * Date updated: 06 Nov 2023
 * 
 * @author Rocket Uzarraga
 * @author Ryan Ramakrishnan
 * @version %I%, %G%
 * @since 1.0
 */
public class Runner {
    public static void main(String[] args) {
        // Welcome to the messiest code in the world
        System.out.println("Rules:");
        System.out.println("Each player gets 1 guess per turn.");
        System.out.println("A player can guess the full phrase, or a single letter.");
        System.out.println("Guessing the full phrase earns a player double their spin, and wins them the game.");
        System.out.println("If the phrase is solved with individual letters, the player with the most money wins.\n\n");

        boolean replay = true;
        PhraseSolver ps;
        int numPlayers;

        Scanner input = new Scanner(System.in);
        while (replay) {
            // Input number of players
            System.out.print("How many players (2-4)? ");
            try {
                numPlayers = Integer.parseInt(input.nextLine());
                // Limit between 2-4 players
                if (numPlayers < 2 || numPlayers > 4) {
                    System.out.println("Between 2-4 players!");
                    continue;
                }

                // Exception if input isn't number
            } catch (Exception e) {
                System.out.println("Invalid. Try again.");
                continue;
            }
            // Initialize and start Phrase Solver game
            ps = new PhraseSolver(numPlayers, input);
            ps.play();

            // Replay loop
            System.out.print("\nPlay again (y/n)? ");
            if (!input.nextLine().toUpperCase().equals("Y")) {
                replay = false;
            }
        }
        System.out.println("Thank you for playing!");
        input.close();
    }
}
