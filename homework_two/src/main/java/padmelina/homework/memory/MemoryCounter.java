package padmelina.homework.memory;

import padmelina.homework.model.Constans;
import padmelina.homework.model.MemoryAllocater;

import java.util.Collection;
import java.util.List;

import static padmelina.homework.model.Constans.BIG_NUMBER_FOR_COLLECTION;
import static padmelina.homework.model.Constans.BIG_NUMBER_FOR_MEMORY_CHECK;
import static padmelina.homework.model.Constans.SMALLER_NUMBER_FOR_MEMORY_CHECK;

public class MemoryCounter {
    public static long countObjectSize(Class type) {
        try {
            MemoryUtils memoryUtils = new MemoryUtils();
            memoryUtils.callGC();
            long before = memoryUtils.getUsedMemory();
            Object[] array = MemoryAllocater.createArray(BIG_NUMBER_FOR_MEMORY_CHECK, type);
            long after = memoryUtils.getUsedMemory();
            memoryUtils.callGC();
            Object o = array[0];
            return (after - before)/ BIG_NUMBER_FOR_MEMORY_CHECK;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long countCollectionSize(int sizeOfArray) throws IllegalAccessException, InstantiationException {
        MemoryUtils memoryUtils = new MemoryUtils();
        memoryUtils.callGC();
        long before = memoryUtils.getUsedMemory();
        List<List<String>> array = MemoryAllocater.createCollection(SMALLER_NUMBER_FOR_MEMORY_CHECK, sizeOfArray);
        long after = memoryUtils.getUsedMemory();
        memoryUtils.callGC();
        array.size();
        return (after - before)/ BIG_NUMBER_FOR_MEMORY_CHECK;
    }
}
