package datastructures.linkedlist;

public class LinkedList<E> {

    private Node first;

    private class Node {
        private E element;
        private Node next;

        public Node(E element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element != null ? element.toString() : null;
        }
    }

    public E delete(E element) {
        if (isEmpty()) return null;
        if(first.element.equals(element)) return deleteFirst();

        Node current = first;
        Node previous = first;

        while(!current.element.equals(element)){
            if(current == null) return null; //Element is not in the list
            previous = current;
            current = current.next; //Iterating over the list
        }
        previous.next = current.next; //Element to be deleted has no nodes pointing to it
        return current.element;
    }

    public void add(E element) {
        Node newNode = new Node(element);
        newNode.next = first;
        first = newNode;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public E find(E element) {
        if (isEmpty()) return null;
        Node current = first;
        while (current != null) {
            if (current.element.equals(element)) return current.element;
            current = current.next;
        }
        return null;
    }

    public E deleteFirst() {
        if (!this.isEmpty()) { //List is not empty
            Node temp = first; //The element to be deleted
            first = first.next;
            return temp.element;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.find(1));
        System.out.println(list.find(2));
        System.out.println(list.find(3));

        list.delete(3);
        System.out.println(list.find(1));
        System.out.println(list.find(2));
        System.out.println(list.find(3));
    }
}
