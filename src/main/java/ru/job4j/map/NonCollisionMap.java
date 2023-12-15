package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int h = hash(Objects.hashCode(key));
        int f = keyIndex(h);
        boolean rsl = table[f] == null;
        if (rsl) {
            table[f] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return rsl;
    }

    private int keyIndex(int h) {
        return indexFor(h);
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int k = hash(Objects.hashCode(entry.key));
                int newTableIndex = keyIndex(k);
                newTable[newTableIndex] = new MapEntry<>(entry.key, entry.value);
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        V result = null;
        int ko = Objects.hashCode(key);
        int k = keyIndex(hash(ko));
        if (table[k] != null) {
            if (compareKeys(ko, key, k)) {
                result = table[k].value;
            }
        }
        return result;
    }

    private boolean compareKeys(int ko, K key, int i) {
        return ko == Objects.hashCode(table[i].key)
                && Objects.equals(table[i].key, key);
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int ko = Objects.hashCode(key);
        int k = keyIndex(hash(ko));
        if (table[k] != null) {
            if (compareKeys(ko, key, k)) {
                table[k] = null;
                rsl = true;
            }
        }
        count--;
        modCount++;
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            int index = 0;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
