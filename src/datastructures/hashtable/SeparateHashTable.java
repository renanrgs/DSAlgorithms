package datastructures.hashtable;

import datastructures.symboltable.SequentialSearchST;

public class SeparateHashTable<Key, Value> {
    private int size;
    private SequentialSearchST<Key, Value>[] buckets;

    public SeparateHashTable(int size) {
        this.size = size;
        buckets = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[size];
    }

    public SeparateHashTable() {
        this(997);
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7FFFFFFF) % size;
    }

    public void put(Key key, Value value) {
        buckets[hash(key)].put(key, value);
    }

    public Value get(Key key) {
        return buckets[hash(key)].get(key);
    }
}
