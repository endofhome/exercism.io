import java.util.stream.IntStream;

public class Pangrams {

    public static boolean isPangram(String sentence) {
        String formattedSentence = formatted(sentence);

        return ! IntStream.range(97, 123)
                .filter(c -> ! formattedSentence.contains(Character.toString((char) c)))
                .findAny()
                .isPresent();
    }

    private static String formatted(String sentence) {
        return sentence
                .toLowerCase()
                .replaceAll("[\"]", "");
    }

}