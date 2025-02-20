package task.module_2;

import java.util.Arrays;

public class ArrayFilter {

    public static Object[] filter(Object[] array, Filter ft) {
        Object[] result = new Object[array.length];
        int count = 0;
        for (Object item : array) {
            Object filteredItem = ft.apply(item);
            if (filteredItem != null) {
                result[count++] = filteredItem;
            }
        }
        return Arrays.copyOf(result, count);
    }
}
