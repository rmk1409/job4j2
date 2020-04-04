package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Roman on 04.04.2020
 */
public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void revert() {
        if (this.head != null && this.head.next != null) {
            Node<T> previous = null;
            Node<T> first = this.head;
            Node<T> second = this.head.next;
            while (second != null) {
                Node<T> next = second.next;
                second.next = first;
                first.next = previous;
                previous = first;
                first = second;
                second = next;
            }
            this.head = first;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}