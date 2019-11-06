import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Anagram {
    private final String sortedSubject;

    public Anagram(String subject) {
        sortedSubject = sortCharacters(subject);
    }

    public List<String> match(List<String> candidates) {
        return candidates.stream()
                .filter(it -> sortCharacters(it).equals(this.sortedSubject))
                .collect(toList());
    }

    private String sortCharacters(String subject) {
        return Arrays.stream(subject.split(""))
                .sorted()
                .collect(joining());
    }
}
