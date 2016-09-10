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

    public Integer count(char nucleotide) {
        return 0;
    }

    public Map<Character, Integer> nucleotideCounts() {
        HashMap<Character, Integer> result = new HashMap<>();
        for (char character:nucleotides) {
            result.put(character, count(character));
        }
        return result;
    }
}
