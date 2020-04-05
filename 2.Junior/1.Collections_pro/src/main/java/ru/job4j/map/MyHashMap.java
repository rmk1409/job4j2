package ru.job4j.map;

import java.util.*;

/**
 * Ассоциативный массив на базе хэш-таблицы должен быть унифицирован через генерики и иметь методы:
 * boolean insert(K key, V value);
 * V get(K key);
 * boolean delete(K key);
 * <p>
 * Реализовывать итератор.
 * Внутренняя реализация должна использовать массив. Нужно обеспечить фиксированное время вставки и получение.
 * Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.
 * <p>
 * Методы разрешения коллизий реализовывать не надо. Например: если при добавлении ключ уже есть, то возвращать false.
 * <p>
 * Created by Roman on 04.04.2020
 */
public class MyHashMap<K, V> implements Iterable<MyHashMap.Node<K, V>> {
    private Node<K, V>[] container = (Node<K, V>[]) new Node[10];
    private int modCount;
    private int size;
    private double loadFactor = 0.75;

    public boolean insert(K key, V value) {
        boolean result = false;
        int bucketNumber = findBucket(key.hashCode());
        if (!checkCollision(bucketNumber)) {
            this.container[bucketNumber] = new Node<>(key, value);
            result = true;
            this.size++;
            this.modCount++;
            this.checkContainerSize();
        }
        return result;
    }

    private int findBucket(int hashCode) {
        return hashCode % this.container.length;
    }

    private boolean checkCollision(int bucketNumber) {
        return this.container[bucketNumber] != null;
    }

    private void checkContainerSize() {
        if (this.size >= this.loadFactor * this.container.length) {
            Node<K, V>[] old = this.container;
            this.container = (Node<K, V>[]) new Node[old.length * 2];
            this.size = 0;
            Arrays.stream(old)
                    .filter(Objects::nonNull)
                    .forEach(e -> this.insert(e.key, e.value));
        }
    }

    public V get(K key) {
        return this.container[this.findBucket(key.hashCode())].value;
    }

    public boolean delete(K key) {
        boolean result = false;
        int bucketNumber = this.findBucket(key.hashCode());
        if (this.container[bucketNumber] != null) {
            this.container[bucketNumber] = null;
            size--;
            result = true;
            this.modCount++;
        }
        return result;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private int index;
            private int expectedModCount = modCount;
            private Node<K, V> currentNode;

            {
                this.findNext();
            }

            @Override
            public boolean hasNext() {
                this.checkContainerModification();
                return this.currentNode != null;
            }

            @Override
            public Node<K, V> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<K, V> result = this.currentNode;
                this.currentNode = null;
                this.findNext();
                return result;
            }

            private void findNext() {
                for (int i = this.index; i < container.length; i++) {
                    if (container[i] != null) {
                        this.currentNode = container[i];
                        this.index = i + 1;
                        break;
                    }
                }
            }

            private void checkContainerModification() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
