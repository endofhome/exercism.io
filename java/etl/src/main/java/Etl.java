
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Etl {

   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
       return old.entrySet()
               .stream()
               .flatMap(entry -> entry.getValue()
                       .stream()
                       .map(string -> new AbstractMap.SimpleEntry<>(string.toLowerCase(), 1)))
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
   }
}