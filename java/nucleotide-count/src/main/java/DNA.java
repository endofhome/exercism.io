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

    public int count(char nucleotide) {
        validateArguments(nucleotide);
        int result = 0;
        for (char character:identifier.toCharArray()) {
            if (character == nucleotide) {
                result++;
            }
        }
        return result;
    }

    public Map<Character, Integer> nucleotideCounts() {
        HashMap<Character, Integer> result = new HashMap<>();
        for (char character:nucleotides) {
            result.put(character, count(character));
        }
        return result;
    }

    private void validateArguments(char nucleotide) {
        if (!nucleotides.contains(nucleotide)) {
            throw new IllegalArgumentException(String.format("%s is not a valid nucleotide", nucleotide));
        }
    }

}
