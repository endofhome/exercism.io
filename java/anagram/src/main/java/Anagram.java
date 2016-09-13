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
            if (word.length() != baseWord.length()) { continue; }
            char[] wordArray = sortedArrayOf(word);
            char[] baseWordArray = sortedArrayOf(baseWord);
            for (int i=0; i < word.length(); i++) {
                if (wordArray[i] != baseWordArray[i]) {
                    break;
                }
                if (i == word.length() -1 && notTheSameWord(word)) {
                    matches.add(word);
                }
            }
        }
        return matches;
    }

    private boolean notTheSameWord(String word) {
        return !word.toLowerCase().equals(baseWord.toLowerCase());
    }

    private char[] sortedArrayOf(String word) {
        word = word.toLowerCase();
        char[] wordArray = word.toCharArray();
        sort(wordArray);
        return wordArray;
    }
}
