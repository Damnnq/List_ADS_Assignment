package structures;

import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T value) {
        list.add(0, value); // add item to top of stack
    }

    public T removeTop() {
        if (list.isEmpty()) {
            System.out.println("Stack empty");
            return null;
        }
        return list.remove(list.size() - 1); // remove from top
    }

    public T viewTop() {
        return list.get(list.size() - 1); // check top item
    }

    public boolean isEmpty() {
        return list.isEmpty(); // true if stack is empty
    }

    public int size() {
        return list.size(); // number of items
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator(); // return iterator
    }
}
