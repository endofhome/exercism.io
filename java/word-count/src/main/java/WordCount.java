import java.util.HashMap;
import java.util.Map;

class WordCount {

    Map<String,Integer> phrase(String phrase) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put(phrase, 1);

        return result;
    }

    private String[] reformatPhrase(String phrase) {
        throw new IllegalArgumentException("");
    }

}
