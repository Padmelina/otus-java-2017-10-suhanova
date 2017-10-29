package padmelina.homework.model;

public class MemoryAllocater {

    public static Object [] createArray(int size, Class type) throws InstantiationException, IllegalAccessException {
        Object [] array = new Object[size];
        for (int i = 0; i < size; ++i) {
            array[i] = type.newInstance();
        }
        return array;
    }
}
