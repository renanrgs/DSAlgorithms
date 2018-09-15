package datastructures.Queue;

public class Queue<Item> {
    private int size;
    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    public int size() {
        return this.size;
    }

    public void enqueue(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) return null;
        Node toBeDequeued = first;
        first = first.next;
        size--;
        return toBeDequeued.item;
    }

    public Item find(Item item) {
        if (isEmpty()) return null;
        if (last.item.equals(item)) return last.item;
        Node current = first;
        while (current != null) {
            if (current.item.equals(item)) return current.item;
            current = current.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
