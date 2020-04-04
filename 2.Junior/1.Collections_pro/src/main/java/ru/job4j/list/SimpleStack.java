package ru.job4j.list;

/**
 * Created by Roman on 04.04.2020
 */
public class SimpleStack<T> {
    private MyLinkedList<T> linked = new MyLinkedList<>();

    public T poll() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }

    public boolean isEmpty() {
        return this.linked.isEmpty();
    }
}