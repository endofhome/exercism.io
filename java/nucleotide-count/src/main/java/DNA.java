import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class DNA {

    private final List<Character> nucleotides;
    private final String identifier;

    public DNA(String identifier) {
        this.identifier = identifier;
        this.nucleotides = asList('A', 'C', 'G', 'T');
    }

    public int count(char dnaChar) {
        List<Character> identifierCharacters = charactersFrom(identifier);

        return (int) identifierCharacters
                .stream()
                .filter(c -> c == dnaChar)
                .count();
    }

    public Map<Character, Integer> nucleotideCounts() {
        return nucleotides
                .stream()
                .collect(toMap((c -> c), (x -> 0)));
    }

    private List<Character> charactersFrom(String identifier) {
        return identifier
                .chars()
                .mapToObj(c -> (char) c)
                .collect(toList());
    }
}
