package padmelina.homework.memory;

import padmelina.homework.model.MemoryAllocater;

public class MemoryCounter {
    public static long countObjectSize(int size, Class type) {
        try {
            MemoryUtils memoryUtils = new MemoryUtils();
            memoryUtils.callGC();
            long before = memoryUtils.getUsedMemory();
            Object[] array = MemoryAllocater.createArray(size, type);
            long after = memoryUtils.getUsedMemory();
            return (after - before)/size;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
