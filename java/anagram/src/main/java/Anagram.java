import java.util.ArrayList;
import java.util.List;

public class Anagram {

    private final String baseWord;

    public Anagram(String word) {
        this.baseWord = word;
    }

    public List<String> match(List<String> words) {
        ArrayList<String> matches = new ArrayList<>();
        for (String word : words) {
            if (word.length() != baseWord.length()) {
                break;
            }
            matches.add(word);
        }
        return matches;
    }
}
