package padmelina.homework;

import padmelina.homework.memory.MemoryCounter;

import java.util.Vector;

public class Main {
    public static int ARRAY_SIZE = 2000000;
    public static void main(String[] args) {
        System.out.println(String.class.getName() + " size = " + MemoryCounter.countObjectSize(ARRAY_SIZE, String.class));
        System.out.println(Object.class.getName() + " size = " + MemoryCounter.countObjectSize(ARRAY_SIZE, Object.class));
        System.out.println(Vector.class.getName() + " size = " + MemoryCounter.countObjectSize(ARRAY_SIZE, Vector.class));
    }
}
