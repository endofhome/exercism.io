import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {

   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
       Map<String, Integer> result = new HashMap<String, Integer>();
       for (int i=0; i< old.get(1).size(); i++) {
           String letter = old.get(1).get(i).toLowerCase();
           result.put(letter, 1);
       }
       return result;
   }

}