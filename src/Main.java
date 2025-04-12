import structures.*;

public class Main {
    public static void main(String[] args) {
        // Testing MyStack
        System.out.println("TestMyStack");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("remove: " + stack.removeTop()); // should be 30
        System.out.println("view top: " + stack.viewTop()); // should be 20

        // Testing MyQueue
        System.out.println("\nTestMyQueue");
        MyQueue<String> queue = new MyQueue<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        System.out.println("remove: " + queue.remove()); // should be A
        System.out.println("view top: " + queue.viewTop()); // should be B

        // Testing MyMinHeap
        System.out.println("\nTestMyMinHeap");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(50);
        heap.add(20);
        heap.add(30);
        heap.add(10);
        heap.add(40);
        System.out.println("view top min: " + heap.viewTop()); // should be 10
        System.out.println("remove min: " + heap.removeMin()); // should remove 10
        System.out.println("new min: " + heap.viewTop()); // should be 20
    }
}
