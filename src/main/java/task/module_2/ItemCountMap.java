package task.module_2;

import java.util.HashMap;
import java.util.Map;

public class ItemCountMap {

    public Map<String, Integer> createItemCountMap(final String[] itemArray) {
        Map<String, Integer> itemMap = new HashMap<>();
        for (String item : itemArray) {
            itemMap.merge(item, 1, Integer::sum);
        }
        return itemMap;
    }
}
