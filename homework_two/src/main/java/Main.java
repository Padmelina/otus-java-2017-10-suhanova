import memory.MemoryCounter;

public class Main {
    public static int ARRAY_SIZE = 2000000;
    public static void main(String[] args) {
        long size = MemoryCounter.countObjectSize(ARRAY_SIZE, String.class);
        System.out.println(size);
    }
}
