import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

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
        throw new IllegalArgumentException("");
    }
}
