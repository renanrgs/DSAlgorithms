package datastructures.sortedlist;

public class SortedList<Item extends Comparable> {
    private Node first;
    private int size;

    private class Node {
        private Item item;
        private Node next;

        private Node(Item item) {
            this.item = item;
        }
    }

    public void insert(Item item) {
        Node newNode = new Node(item);
        Node previous = null;
        Node current = first;

        while (current != null && current.item.compareTo(item) >= 0) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            newNode.next = first;
            first = newNode;
        } else {
            previous.next = newNode;
            newNode.next = current;
        }

        size++;
    }

    public boolean isEmpty(){
        return first ==  null;
    }

    public void display() {
        if(!isEmpty()) return;
    }

    public static void main(String[] args) {
        SortedList<Integer> sortedList = new SortedList<>();
    }
}
