package interfaces;

import java.util.Iterator;

public interface MyList<T> extends Iterable<T> {
    void add(int i, T element);
    T get(int index);
    T remove(int index);
    int size();
    boolean isEmpty();
    @Override
    Iterator<T> iterator(); // New method for iteration
}
