import javafx.util.Pair;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Hamming {
    public static Integer compute(String baseStrand, String compareStrand) {
        if (baseStrand.length() != compareStrand.length()) {
            throw new IllegalArgumentException("Strands are not equal length: base strand is " + baseStrand.length() + ", compare strand is " + compareStrand.length());
        }
        String[] baseStrandArray = baseStrand.split("");
        String[] compareStandArray = compareStrand.split("");
        List<Pair<String, String>> pairs = IntStream.range(0, baseStrand.length()).mapToObj(i ->
            new Pair<>(baseStrandArray[i], compareStandArray[i])
        ).collect(toList());

        return countNonMatchingPairs(pairs);
    }

    private static int countNonMatchingPairs(List<Pair<String, String>> pairs) {
        return (int) pairs.stream().filter(Hamming::doesNotMatch).count();
    }

    private static boolean doesNotMatch(Pair<String, String> pair) {
        return !(pair.getKey().equals(pair.getValue()));
    }
}
