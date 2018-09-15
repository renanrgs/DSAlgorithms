package datastructures.stack;

public class Stack<Item> {

    private Node first;
    private int size;

    private class Node {
        Item item;
        Node next;

        private Node(Item item) {
            this.item = item;
        }
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        Node newNode = new Node(item);
        newNode.next = first;
        first = newNode;
        size++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Size: " + stack.size());
        stack.push(3);
        System.out.println("Size: " + stack.size());
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.size());
    }
}
