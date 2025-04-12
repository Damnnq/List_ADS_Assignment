package structures;

import java.util.Iterator;

public class MyMinHeap<T extends Comparable<T>> implements Iterable<T> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void add(T value) {
        heap.add(0, value); // add at the end
        heapUp(heap.size() - 1); // fix position
    }

    public T removeMin() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty");
            return null;
        }

        T min = heap.get(0); // get smallest item
        T last = heap.remove(heap.size() - 1); // take out last
        if (!heap.isEmpty()) {
            heap.add(0, last); // move last to top
            heapDown(0); // fix position
        }
        return min;
    }

    public T viewTop() {
        return heap.get(0); // see top item
    }

    public int size() {
        return heap.size(); // number of items
    }

    public boolean isEmpty() {
        return heap.isEmpty(); // true if empty
    }

    private void heapUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            T current = heap.get(index);
            T parentValue = heap.get(parent);
            if (current.compareTo(parentValue) < 0) {
                swap(index, parent); // move up
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest == index) break;

            swap(index, smallest); // move down
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i); // swap two items
        heap.add(i, heap.get(j));
        heap.add(j, temp);
    }

    @Override
    public Iterator<T> iterator() {
        return heap.iterator(); // get iterator
    }
}
