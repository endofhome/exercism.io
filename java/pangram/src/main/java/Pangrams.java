import java.util.Arrays;
import java.util.List;

public class Pangrams {

    public static boolean isPangram(String sentence) {
        for(int i=97; i<123; i++) {
            Character character = (char) i;
            if (!sentence.contains(character.toString())) {
                return false;
            }
        }
        return true;
    }

}