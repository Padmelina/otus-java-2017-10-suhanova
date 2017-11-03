package padmelina.homework;

import padmelina.homework.memory.MemoryCounter;
import padmelina.homework.model.Constans;

import java.util.Vector;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println(String.class.getName() + " size = " + MemoryCounter.countObjectSize(String.class));
        System.out.println(Object.class.getName() + " size = " + MemoryCounter.countObjectSize(Object.class));
        System.out.println(Vector.class.getName() + " size = " + MemoryCounter.countObjectSize(Vector.class));
        System.out.println("List of String with " + Constans.SMALL_NUMBER_FOR_COLLECTION + " size = " + MemoryCounter.countCollectionSize(Constans.SMALL_NUMBER_FOR_COLLECTION));
        System.out.println("List of String with " + Constans.BIG_NUMBER_FOR_COLLECTION + " size = " + MemoryCounter.countCollectionSize(Constans.BIG_NUMBER_FOR_COLLECTION));
    }
}
