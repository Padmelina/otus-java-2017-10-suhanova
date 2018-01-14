package padmelina.homework_three;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private Object[] array;
    private int size;
    private int realSize;
    private Itrtr iterator;

    private static final int DEFAULT_SIZE = 10;
    private static final int SIZE_COEFFICIENT = 2;

    public MyArrayList(int size) {
        if (size < 0) throw new  IllegalArgumentException();
        else if (size == 0)  array = new Object[DEFAULT_SIZE];
        array = new Object[size];
        realSize = size;
    }

    public MyArrayList() {
        array = new Object[] {};
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return array == null || size == 0;
    }

    public boolean contains(Object element) {
        if (element == null) throw new NullPointerException();
        for (Object arr : array) {
            if (element.equals(arr)) return true;
        }
        return false;
    }

    public Iterator iterator() {
        if (iterator == null) {
            iterator = new Itrtr();
        }
        return iterator;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public boolean add(Object element) {
        checkSize();
        array[size++] = element;
        return true;
    }

    public boolean remove(Object element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
        if(index == size - 1) {
            array[index] = null;
            size--;
            checkSize();
            return true;
        }
        Object [] tempArray = new Object[size - 1];
        if (index == 0) {
            System.arraycopy(array, 1, tempArray, 0, size - 1);
        }  else {
            System.arraycopy(array, 0, tempArray, 0, index);
            System.arraycopy(array, index + 1, tempArray, index, size - index - 1);
        }
        array = tempArray;
        size--;
        checkSize();
        return true;
    }

    public boolean containsAll(Collection c) {
       if (c.isEmpty()) throw new NullPointerException();
       ListIterator itrt = listIterator();
       while (itrt.hasNext()) {
           if (!contains(itrt.next()))
               return false;
       }
        return true;
    }

    public boolean addAll(Collection c) {
        if (c.isEmpty()) throw new NullPointerException();
        Iterator iterator = c.iterator();
        for (int i = 0; i < c.size(); i++) {
            add(iterator.next());
        }
        return true;
    }

    public boolean addAll(int index, Collection c) {
        if (c.isEmpty()) throw new NullPointerException();
        if (index > size() || index < 0) throw new IndexOutOfBoundsException();
        Iterator iterator = c.iterator();
        for (int i = 0; i < c.size(); i++) {
            add(index, iterator.next());
        }
        return true;
    }

    public boolean removeAll(Collection c) {
        if (c.isEmpty()) throw new NullPointerException();
        int i = 0;
        for (Object element : c) {
            if (contains(element))
                remove(element);
            i++;
        }
        return i != 0;
    }

    public boolean retainAll(Collection c) {
        if (c == null || c.size() == 0) throw new NullPointerException();
        Object [] list = new Object[c.size()];
        int i = 0;
        Iterator iterator = c.iterator();
        for (; iterator.hasNext();) {
            Object current = iterator.next();
            if (contains(current)) {
                list[i] = current;
            }
            i++;
        }
        for (int j = 0; j < list.length; j++) {
            if (list[j] == null) remove(j);
        }
        if (list.length != 0) {
            array = list;
            size = list.length;
            checkSize();
        }
        return list.length != 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        realSize = 0;
    }

    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    public void add(int index, Object element) {
        if (index >= size) throw new IndexOutOfBoundsException();
        if (index == size - 1) {
            add(element);
            return;
        }
        Object [] tmpArray = new Object[size + 1];
        if (index == 0) {
            tmpArray[0] = element;
            System.arraycopy(array, 0, tmpArray, 1, size);
        }
        System.arraycopy(array, 0, tmpArray, 0, index);
        tmpArray[index] = element;
        System.arraycopy(array, index, tmpArray, index + 1, size - index);
        array = tmpArray;
        size++;
        checkSize();
    }

    public T remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        T deleted = (T) array[index];
        Object [] tempArray = new Object[size - 1];
        if (index == 0) {
            System.arraycopy(array, 1, tempArray, 0, size - 1);
        }  else {
            System.arraycopy(array, 0, tempArray, 0, index);
            System.arraycopy(array, index + 1, tempArray, index, size - index - 1);
        }
        array = tempArray;
        size--;
        checkSize();
        return deleted;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) index = i;
        }
        return index;
    }

    private void checkSize() {
        if (size == 0) {
            realSize = DEFAULT_SIZE;
            array = new Object[realSize];
        }
        else if (size >= DEFAULT_SIZE && ((realSize - size <= 1) || (size < realSize/SIZE_COEFFICIENT))) {
            realSize = SIZE_COEFFICIENT * size;
            resize(realSize);
        }
    }

    private void resize(int newSize) {
        if (array == null || size == 0) {
            array = new Object[newSize];
            return;
        }
        if (newSize == 0) {
            array = new Object[] {};
            return;
        }
        if (size == newSize) return;
        Object [] tmpArray = new Object[newSize];
        System.arraycopy(array, 0, tmpArray, 0, size);
        array = tmpArray;
    }

    @Override
    public <E> E[] toArray(E[] list) {
        if (list == null) throw new NullPointerException();
        if (realSize <= list.length) {
            resize(list.length);
        }
        System.arraycopy(list, 0, array, 0, list.length);
        return (E[]) array;

    }

    @Override
    public T set(int index, T element) {
        if (index >= size) throw new IndexOutOfBoundsException();
        T previous = (T) array[index];
        array[index] = element;
        return previous;
    }

    public ListIterator listIterator() {
        return new ListItrtr();
    }

    public ListIterator listIterator(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        return new ListItrtr(index);
    }

    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        for (int i = 0; i < size-1; ++i) {
            for (int j = i; j < size; ++j) {
                if (comparator.compare((T) array[i], (T) array[j]) > 0) {
                    Collections.swap(this,  i,  j);
                }
            }
        }
    }

    private class Itrtr implements Iterator<T> {
        protected int pointer = 0;
        protected int current = 0;

        Itrtr() {
            pointer = 0;
        }

        Itrtr(int index) {
            pointer = index;
        }

        public boolean hasNext() {
            return pointer + 1 < size;
        }

        public T next() {
            if (pointer >= size) throw new IndexOutOfBoundsException();
            current = pointer;
            pointer++;
            return (T) array[current];
        }

        public void remove() {
            if (pointer >= size) throw new IndexOutOfBoundsException();
            MyArrayList.this.remove(pointer);
        }
    }

    private class ListItrtr extends Itrtr implements ListIterator<T> {

        ListItrtr() {
            super();
            current = 0;
        }

        ListItrtr(int index) {
            super();
            pointer = index;
            current = pointer;
        }
        @Override
        public boolean hasPrevious() {
            return pointer - 1 < 0;
        }

        @Override
        public T previous() {
            if (pointer - 1 < 0) throw new IndexOutOfBoundsException();
            current = pointer - 1;
            pointer--;
            return (T) array[current];
        }

        @Override
        public int nextIndex() {
            if (pointer + 1 >= size) throw new IndexOutOfBoundsException();
            return pointer + 1;
        }

        @Override
        public int previousIndex() {
            if (pointer - 1 < 0) throw new IndexOutOfBoundsException();
            return pointer - 1;
        }

        @Override
        public void set(T t) {
            MyArrayList.this.set(current, t);
        }

        @Override
        public void add(T t) {
            MyArrayList.this.add(t);
        }
    }

}
