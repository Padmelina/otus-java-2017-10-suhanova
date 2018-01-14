package padmelina.homework_three;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

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
        assertTrue(list.containsAll(check));
    }

    @Test
    public void testSort() {
        Collections.addAll(list, 5, 8, 2, 0, 3, -1);
        Collections.sort(list, (o1, o2) -> o1.equals(o2) ? 0 : ((o1 > o2) ? 1 : -1));
        List <Integer> compareList = new ArrayList<>();
        Collections.addAll(compareList, -1, 0, 2, 3, 5, 8);
        for (int i = 0; i < 6; i++) {
            assertTrue(list.get(i).equals(compareList.get(i)));
        }
    }

    @Test
    public void testCopy() {
        Collections.addAll(list, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List <Integer> destination = new MyArrayList<>(list.size());
        for (int i = 0; i < 16; i++) {
            destination.add(0);
        }
        Collections.copy(destination, list);
        assertTrue(destination.containsAll(list));
    }

    @Test
    public void testEmptyListSize(){
        List list = new MyArrayList(100);
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty(){
        List list = new MyArrayList(100);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray(){
        List list = new MyArrayList(10);
        list.add(1);
        list.add(2);
        assertArrayEquals(new Object[]{1,2}, list.toArray());
    }

}
