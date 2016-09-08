import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {

   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
       Map<String, Integer> result = new HashMap<String, Integer>();
       for (Integer integer : old.keySet()) {
           for (String letter : old.get(integer)) {
               result.put(letter.toLowerCase(), integer);
           }
       }
       return result;
   }

}