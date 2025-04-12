package structures;

import interfaces.MyList;
import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>, Iterable<T> {
    private class Node {
        T data;
        Node next, prev;

        Node(T data) {
            this.data = data; // store data
        }
    }

    private Node head, tail; // start and end of list
    private int size;

    public MyLinkedList() {
        head = tail = null; // list is empty
        size = 0;
    }

    @Override
    public void add(int i, T element) {
        Node node = new Node(element); // new node
        if (head == null) {
            head = tail = node; // first item
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node; // add at the end
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index:" + index);
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next; // move to index
        return current.data;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Remove failed,invalid index:" + index);
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;

        if (current.prev != null) current.prev.next = current.next;
        else head = current.next; // update head if needed

        if (current.next != null) current.next.prev = current.prev;
        else tail = current.prev; // update tail if needed

        size--;
        return current.data;
    }

    @Override
    public int size() {
        return size; // return count
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // true if no items
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator(); // get iterator
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null; // check if more
        }

        @Override
        public T next() {
            if (!hasNext()) throw new RuntimeException("No more elements");
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
