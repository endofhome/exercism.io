import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public Map<String,Integer> phrase(String phrase) {
        String[] words = phrase.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word:words) {
            wordCount.put(word, 1);
        }
        return wordCount;
    }

}
