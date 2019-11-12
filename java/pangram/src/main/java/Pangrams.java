import java.util.stream.IntStream;

public class Pangrams {

    public static boolean isPangram(String sentence) {
        String formattedSentence = formatted(sentence);

        return ! IntStream.range(97, 123)
                .filter(i -> ! formattedSentence.contains(asciiStringFor(i)))
                .findAny()
                .isPresent();
    }

    private static String formatted(String sentence) {
        return sentence
                .toLowerCase()
                .replaceAll("[\"]", "");
    }

    private static String asciiStringFor(int i) {
        return Character.toString((char) i);
    }
}