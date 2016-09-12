import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.sort;

public class Anagram {

    private final String baseWord;

    public Anagram(String word) {
        this.baseWord = word;
    }

    public List<String> match(List<String> words) {
        ArrayList<String> matches = new ArrayList<>();
        for (String word : words) {
            char[] wordArray = sortedArrayOf(word);
            char[] baseWordArray = sortedArrayOf(baseWord);
            for (int i=0; i < word.length(); i++) {
                if (wordArray[i] != baseWordArray[i]) {
                    break;
                }
                if (i == word.length() -1) {
                    matches.add(word);
                }
            }
        }
        return matches;
    }

    private char[] sortedArrayOf(String word) {
        char[] wordArray = word.toCharArray();
        sort(wordArray);
        return wordArray;
    }
}
