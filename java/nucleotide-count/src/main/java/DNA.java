import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
        return 0;
    }

    public Map<Character, Integer> nucleotideCounts() {
        return nucleotides
                .stream()
                .collect(toMap((x -> x), (x -> 0)));
    }
}
