import java.util.*;

public class Board {
    private List<String> phrases; // An import from a text file?
    private String fullPhrase;

    public Board() {
        int rand = (int) (Math.random() * (phrases.size() - 1));
        fullPhrase = phrases.get(rand);
    }
}
