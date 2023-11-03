import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        // Code in replay loop and input for amt of players later.
        Scanner input = new Scanner(System.in);
        PhraseSolver ps = new PhraseSolver(2, input);
        ps.play();
        input.close();
    }
}
