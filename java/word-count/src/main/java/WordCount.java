import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.toList;

class WordCount {

    Map<String,Integer> phrase(String phrase) {
        List<String> words = validWordsFrom(phrase);
        BiFunction<HashMap<String, Integer>, String, HashMap<String, Integer>> accumulator = (map, word) -> {
            map.put(word, (map.getOrDefault(word, 0) + 1));
            return map;
        };
        BinaryOperator<HashMap<String, Integer>> combiner = (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };

        return words
                .stream()
                .reduce(new HashMap<>(), accumulator, combiner);
    }

    private List<String> validWordsFrom(String phrase) {
        return Arrays.stream(phrase.split(" "))
                .map(word ->
                        word.replaceAll("\\p{Punct}", "")
                            .toLowerCase()
                )
                .filter(word -> ! word.isEmpty())
                .collect(toList());
    }
}
