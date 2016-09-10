import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DNA {

    private final ArrayList<Character> nucleotides;
    private final String identifier;

    public DNA(String identifier) {
        this.identifier = identifier;
        this.nucleotides = new ArrayList<>();
        nucleotides.add('A');
        nucleotides.add('C');
        nucleotides.add('G');
        nucleotides.add('T');
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
