package padmelina.homework.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemoryAllocater {

    public static Object [] createArray(int size, Class type) throws InstantiationException, IllegalAccessException {
        Object [] array = new Object[size];
        for (int i = 0; i < size; ++i) {
            array[i] = type.newInstance();
        }
        return array;
    }

    public static List<List<String>> createCollection(int arraySize, int collectionSize) throws InstantiationException, IllegalAccessException {
        List<List<String>> array = new ArrayList<>(arraySize);
        for (int i = 0; i < arraySize; ++i) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < collectionSize; ++j) {
                list.add(new String("awawa"));
            }
            array.add(list);
        }
        return array;
    }
}
