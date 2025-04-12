package structures;

import interfaces.MyList;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>, Iterable<T> {
    private Object[] data; // stores the element
    private int size; // keeps track of how many elements


    public MyArrayList() {
        data = new Object[5]; // starting with size 5
        size = 0;
    }

    @Override
    public void add(int i, T element) {
        if (size == data.length) {
            expand(); // make array bigger if full
        }
        data[size++] = element; // add element at the end
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of range:" + index);
            return null;
        }
        return (T) data[index]; // return element at index
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Remove failed, index out of range:" + index);
            return null;
        }
        T removed = (T) data[index]; // store item to remove
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1]; // shift elements left
        }
        size--;
        return removed; // return removed item
    }

    @Override
    public int size() {
        return size; // how many elements in list
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // true if no items
    }

    private void expand() {
        Object[] bigger = new Object[data.length * 2]; // double the size
        for (int i = 0; i < size; i++) {
            bigger[i] = data[i]; // copy items to new array
        }
        data = bigger;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator(); // return iterator for list
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size; // check if more elements
        }

        @Override
        public T next() {
            if (!hasNext()) throw new RuntimeException("No more elements");
            return (T) data[current++]; // return next item
        }
    }
}
