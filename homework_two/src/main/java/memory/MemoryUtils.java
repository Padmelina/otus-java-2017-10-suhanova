package memory;

public class MemoryUtils {
    private Runtime runtime;

    public MemoryUtils() {
        runtime = Runtime.getRuntime();
    }

    public long getUsedMemory() {
        return  runtime.totalMemory() - runtime.freeMemory();
    }

    public void callGC() {
        runtime.gc();
    }
}
