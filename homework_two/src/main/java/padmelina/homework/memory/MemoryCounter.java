package padmelina.homework.memory;

import padmelina.homework.model.MemoryAllocater;

import java.util.List;

import static padmelina.homework.model.Constans.BIG_NUMBER_FOR_MEMORY_CHECK;
import static padmelina.homework.model.Constans.SMALLER_NUMBER_FOR_MEMORY_CHECK;

public class MemoryCounter {
    public static long countObjectSize(Class type) throws InstantiationException, IllegalAccessException {
        return countObjectSize(type, BIG_NUMBER_FOR_MEMORY_CHECK);
    }

    public static long countCollectionSize(int sizeOfCollection) throws IllegalAccessException, InstantiationException {
        return countCollectionSize(SMALLER_NUMBER_FOR_MEMORY_CHECK, sizeOfCollection);
    }

    private static long countObjectSize(Class type, int sizeOfArray) throws IllegalAccessException, InstantiationException {
        MemoryUtils memoryUtils = new MemoryUtils();
        memoryUtils.callGC();
        long before = memoryUtils.getUsedMemory();
        Object[] array = MemoryAllocater.createArray(sizeOfArray, type);
        long after = memoryUtils.getUsedMemory();
        memoryUtils.callGC();
        Object o = array[0];
        return (after - before)/ sizeOfArray;
    }

    private static long countCollectionSize(int sizeOfArray, int sizeOfCollection) throws IllegalAccessException, InstantiationException {
        MemoryUtils memoryUtils = new MemoryUtils();
        memoryUtils.callGC();
        long before = memoryUtils.getUsedMemory();
        List<List<String>> array = MemoryAllocater.createCollection(sizeOfArray, sizeOfCollection);
        long after = memoryUtils.getUsedMemory();
        memoryUtils.callGC();
        array.size();
        return (after - before)/ sizeOfArray;
    }
}
