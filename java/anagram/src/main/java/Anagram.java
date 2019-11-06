import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Anagram {
    private final String subject;

    public Anagram(String subject) {
        this.subject = subject;
    }

    public List<String> match(List<String> candidates) {
        return candidates.stream()
                .filter(this::isAnagram)
                .filter(word -> !(word.toLowerCase().equals(subject.toLowerCase())))
                .collect(toList());
    }

    private boolean isAnagram(String word) {
        return normalise(word).equals(normalise(subject));
    }

    private String normalise(String s) {
        return sortCharacters(s.toLowerCase());
    }

    private String sortCharacters(String s) {
        return Arrays.stream(s.split(""))
                .sorted()
                .collect(joining());
    }
}
