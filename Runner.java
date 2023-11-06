import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
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
