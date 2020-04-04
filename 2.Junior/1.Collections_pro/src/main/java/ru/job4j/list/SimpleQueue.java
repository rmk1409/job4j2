package ru.job4j.list;

/**
 * Created by Roman on 04.04.2020
 */
public class SimpleQueue<T> {
    private SimpleStack<T> pushStack = new SimpleStack<>();
    private SimpleStack<T> pollStack = new SimpleStack<>();

    public T poll() {
        if (this.pollStack.isEmpty()) {
            while (!this.pushStack.isEmpty()) {
                this.pollStack.push(this.pushStack.poll());
            }
        }
        return this.pollStack.poll();
    }

    public void push(T value) {
        this.pushStack.push(value);
    }
}