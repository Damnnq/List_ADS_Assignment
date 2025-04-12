package structures;

import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void add(T value) {
        list.add(0, value); // add to the back
    }

    public T remove() {
        if (list.isEmpty()) {
            System.out.println("Queue empty");
            return null;
        }
        return list.remove(0); // remove from front
    }

    public T viewTop() {
        return list.get(0); // see front item
    }

    public boolean isEmpty() {
        return list.isEmpty(); // true if empty
    }

    public int size() {
        return list.size();  // how many items
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator(); // get iterator
    }
}
