import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
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
                .filter(x -> x == dnaChar)
                .count();
    }

    public Map<Character, Integer> nucleotideCounts() {
        return nucleotides
                .stream()
                .collect(toMap((x -> x), (x -> 0)));
    }

    private List<Character> charactersFrom(String identifier) {
        List<Character> identifierCharacters = new ArrayList<>();
        char[] chars = identifier.toCharArray();
        for (char c : chars) {
            identifierCharacters.add(c);
        }

        return identifierCharacters;
    }
}
