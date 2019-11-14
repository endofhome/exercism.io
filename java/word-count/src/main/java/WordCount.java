import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

class WordCount {

    Map<String,Integer> phrase(String phrase) {
        HashMap<String, Integer> result = new HashMap<>();
        List<String> words = asList(phrase.split(" "));
        words.forEach(word -> {
            Integer count = (int) words
                    .stream()
                    .filter(w -> w.equals(word))
                    .count();
            result.put(word, count);
        });

        return result;
    }

    private String[] reformatPhrase(String phrase) {
        throw new IllegalArgumentException("");
    }

}
