import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public Map<String,Integer> phrase(String phrase) {
        String[] words = reformatPhrase(phrase);
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word:words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }

    private String[] reformatPhrase(String phrase) {
        String punctuationRemovedPhrase = phrase
                .replaceAll("[:!&@$%^&,]", "")
                .replaceAll(" +", " ");
        return punctuationRemovedPhrase.split(" ");
    }

}
