import java.util.*;

class PhraseSolver {
    private List<Player> players = new ArrayList<Player>();

    public PhraseSolver(int np) {
        // Precondition: np > 1
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
    }

    public void play() {

    }

}