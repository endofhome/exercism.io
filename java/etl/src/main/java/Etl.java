import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;

public class Etl {
   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
       Integer firstKey = old.keySet().iterator().next();
       String firstValue = old.get(firstKey).get(0).toLowerCase();
       ImmutableMap<String, Integer> result = ImmutableMap.of(firstValue, firstKey);
       return result;
   }
}
