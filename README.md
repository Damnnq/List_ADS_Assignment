# Java Data Structures Project

This project includes basic implementations of some important data structures in Java. Each class is written from scratch without using Java's built-in collections. The goal is to understand how these structures work internally.

## 📦 Structures Included

###  MyArrayList
- A simple version of ArrayList.
- Uses an array to store data.
- Expands when full.

###  MyLinkedList
- Doubly linked list.
- Nodes have references to the next and previous nodes.
- Good for adding/removing from anywhere.

###  MyStack
- Stack using MyArrayList.
- Follows LIFO (Last In First Out) rule.
- You can `push`, `removeTop`, and `viewTop`.

###  MyQueue
- Queue using MyLinkedList.
- Follows FIFO (First In First Out) rule.
- You can `add`, `remove`, and `viewTop`.

###  MyMinHeap
- Min Heap using MyArrayList.
- Always keeps the smallest value at the top.
- Includes `heapUp` and `heapDown` to maintain order.
