package datastructures.symboltable;

public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key, Value value) {
        for (Node current = first; current != null; current = current.next) {
            if (current.key.equals(key)) current.value = value;
        }
        first = new Node(key, value, first);
    }

    public Value get(Key key) {
        if (isEmpty()) return null;

        for (Node current = first; current != null; current = current.next) {
            if (current.key.equals(key)) return current.value;
        }

        return null;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
