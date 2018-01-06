package padmelina.homework_three;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyArrayListTest {
    private List <Integer> list;
    @Before
    public void setUp() {
        list = new MyArrayList<Integer>();
    }

    @Test
    public void testAddAll() {
        Collections.addAll(list, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List check = new ArrayList(16);
        Collections.addAll(check, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        assert (list.containsAll(check));
    }

    @Test
    public void testSort() {
        Collections.addAll(list, 5, 8, 2, 0, 3, -1);
        Collections.sort(list, (o1, o2) -> o1 > o2 ? o1 : o2);
    }

    @Test
    public void testCopy() {
        Collections.addAll(list, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List <Integer> destination = new MyArrayList<>(list.size());
        Collections.copy(destination, list);
        assert (destination.containsAll(list));
    }
}
