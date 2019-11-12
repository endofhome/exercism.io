import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Pangrams {

    public static boolean isPangram(String sentence) {
        List<Character> characters = charactersFrom(sentence);

        return IntStream.range(97, 123)
                .filter(c -> characters.contains((char) c))
                .count() == 26;
    }

    private static List<Character> charactersFrom(String sentence) {
        return sentence
                .toLowerCase()
                .replaceAll("[\"]", "")
                .chars()
                .mapToObj(c -> (char) c)
                .collect(toList());

    }

}