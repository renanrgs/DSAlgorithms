package datastructures.doublylist;

public class DoublyLinkedList<Item> {
    private Node first;
    private Node last;

    private class Node {
        private Node next;
        private Node previous;
        private Item item;

        private Node(Item item) {
            this.item = item;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = first;
            newNode.previous = first.previous;
            first.previous = newNode;
        }
        first = newNode;
    }

    public void insertLast(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) first = newNode;
        else {
            newNode.next = last.next;
            newNode.previous = last;
            last.next = newNode;
        }
        last = newNode;
    }

    public Item deleteFirst() {
        Node temp = first;
        if (isEmpty()) return null;
        if (first.next == null) { //Just one element in the list
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        return temp.item;
    }

    public Item deleteLast() {
        Node temp = last;
        if (isEmpty()) return null;
        if (first.next == null) {
            first = null;
            last = null;
        } else {
            last.previous.next = null;
            last = last.previous;
        }
        return temp.item;

    }

    public Item delete(Item item) {
        if (isEmpty()) return null;
        if (first.item.equals(item)) return deleteFirst();
        if (last.item.equals(item)) return deleteLast();

        Node current = first.next;

        while (current != null) {
            if (current.item.equals(item)) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                return current.item;
            }
        }
        return null;
    }
}
