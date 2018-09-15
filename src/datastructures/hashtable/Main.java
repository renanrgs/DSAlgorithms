package datastructures.hashtable;

public class Main {
    public static void main(String[] args) {
        ProbeHashTable<Integer, String> t = new ProbeHashTable<>();

        System.out.println(t.size());
        t.put(1, "Renan Silva");
        System.out.println(t.get(1));
        t.remove(1);
        System.out.println(t.get(1));
    }
}
