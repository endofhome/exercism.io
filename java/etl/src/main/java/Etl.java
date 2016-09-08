import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {

   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
       Map<String, Integer> result = new HashMap<String, Integer>();
       String one = old.get(1).get(0).toLowerCase();
       result.put(one, 1);
       return result;
   }

}