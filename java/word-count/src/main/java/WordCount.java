import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public Map<String,Integer> phrase(String word) {
        Map<String, Integer> wordCount = new HashMap<>();
        wordCount.put(word, 1);
        return wordCount;
    }

}
