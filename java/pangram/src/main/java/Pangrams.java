public class Pangrams {

    public static boolean isPangram(String sentence) {
        for(int i=97; i<123; i++) {
            Character character = (char) i;
            if (!formatted(sentence).contains(character.toString())) {
                return false;
            }
        }
        return true;
    }

    private static String formatted(String sentence) {
        return sentence.toLowerCase().replaceAll("[\"]", "");
    }

}