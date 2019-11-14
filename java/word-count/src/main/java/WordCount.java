import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

class WordCount {

    Map<String,Integer> phrase(String phrase) {
        HashMap<String, Integer> result = new HashMap<>();
        List<String> words = asList(phrase.split(" "));
        words.forEach(word -> result.put(word, 1));

        return result;
    }

    private String[] reformatPhrase(String phrase) {
        throw new IllegalArgumentException("");
    }

}
