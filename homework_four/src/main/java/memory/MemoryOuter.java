package memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryOuter {
    private List<Integer> list = new ArrayList<>();
    private int i = 0;

    public void doMemoryOut() {
        while (true) {
            list.add(i);
            if (i%2 == 0) {
                list.remove(i);
                i++;
            }
        }
    }
}
