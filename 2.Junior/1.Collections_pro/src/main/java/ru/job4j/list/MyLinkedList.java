package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Roman on 04.04.2020
 * <p>
 * Необходимо создать динамический контейнер с методами:
 * <p>
 * 1) add(E value);
 * 2) E get(int index);
 * 3) реализовать интерфейс Iterable<E>.
 * <p>
 * Внутри контейнер должен базироваться на связанном списке(Node<E> node). Использовать стандартные коллекции JDK (ArrayList, LinkedList и т.д.) запрещено.
 * Контейнер должен быть динамическим, т.е. увеличиваться по мере добавления элементов.
 * <p>
 * Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция подверглась структурному изменению,
 * итератор должен кидать ConcurrentModificationException.
 * Это достигается через введение счетчика изменений - modCount. Каждая операция, которая структурно модифицирует коллекцию должна инкрементировать этот счетчик.
 * В свою очередь итератор запоминает значение этого счетчика на момент своего создания (expectedModCount), а затем на каждой итерации сравнивает сохраненное значение,
 * с текущим значением поля modCount, если они отличаются, то генерируется исключение.
 */
public class MyLinkedList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    public void add(E value) {
        Node<E> node = new Node<>(value);
        modCount++;
        size++;
        if (this.first == null) {
            this.first = node;
            this.last = node;
        }
        if (1 < size) {
            this.last.next = node;
            this.last = node;
        }
    }

    public E get(int index) {
        if (index < 0 || this.size < index) {
            throw new NoSuchElementException();
        }
        E result = null;
        if (index < this.size) {
            Node<E> nodeWithResult = this.first;
            for (int i = 1; i <= index; i++) {
                nodeWithResult = nodeWithResult.next;
            }
            result = nodeWithResult.value;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private Node<E> currentNode = first;

            @Override
            public boolean hasNext() {
                this.checkModCount();
                return this.currentNode != null;
            }

            @Override
            public E next() {
                this.checkModCount();
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = this.currentNode.value;
                this.currentNode = this.currentNode.next;
                return result;
            }

            private void checkModCount() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;

        private Node(E value) {
            this.value = value;
        }
    }
}
