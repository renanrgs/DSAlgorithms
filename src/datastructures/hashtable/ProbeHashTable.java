package datastructures.hashtable;

public class ProbeHashTable<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private Integer TABLE_SIZE = 16;
    private int N; //Number of elements in table

    public ProbeHashTable() {
        this.keys = (Key[]) new Object[TABLE_SIZE];
        this.values = (Value[]) new Object[TABLE_SIZE];
    }

    public ProbeHashTable(Integer cap) {
        this.TABLE_SIZE = cap;
        this.keys = (Key[]) new Object[cap];
        this.values = (Value[]) new Object[cap];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7FFFFFFF) % TABLE_SIZE;
    }

    public void put(Key key, Value value) {
        if (N >= TABLE_SIZE / 2) resize(2 * TABLE_SIZE);
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) values[index] = value;
            index = (index + 1) % TABLE_SIZE;
        }
        keys[index] = key;
        values[index] = value;
        N++;
    }

    public Value get(Key key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) return values[index];
            index = (index + 1) % TABLE_SIZE;
        }
        return null;
    }

    private void resize(Integer amount) {
        ProbeHashTable<Key, Value> hashTable = new ProbeHashTable(amount);
        for (int i = 0; i < TABLE_SIZE; i++) if (keys[i] != null) hashTable.put(keys[i], values[i]);
        keys = hashTable.keys;
        values = hashTable.values;
        TABLE_SIZE = hashTable.TABLE_SIZE;
    }

    public int size(){
        return TABLE_SIZE;
    }

    public void remove(Key key) {
        if (get(key) == null) return;
        int index = hash(key);

        while (keys[index] != key) {
            index = (index + 1) % TABLE_SIZE;
        }
        keys[index] = null;
        values[index] = null;

        index = (index + 1) % TABLE_SIZE;

        reorgazineCluster(index);
        N--;
        if (N > 0 && N == TABLE_SIZE / 8) resize(TABLE_SIZE / 2);
    }

    private void reorgazineCluster(int index) {
        while (keys[index] != null) {
            Key keyToRehash = keys[index];
            Value valueToRehash = values[index];

            keys[index] = null;
            values[index] = null;

            N--;
            put(keyToRehash, valueToRehash);

            index = (index + 1) % TABLE_SIZE;
        }
    }
}
