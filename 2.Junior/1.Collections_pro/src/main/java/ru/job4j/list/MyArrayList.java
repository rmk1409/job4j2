package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Roman on 04.04.2020
 * Необходимо создать динамический контейнер с методами:
 * <p>
 * 1) add(E value);
 * <p>
 * 2) E get(int index);
 * <p>
 * 3) реализовать интерфейс Iterable<E>.
 * <p>
 * Внутри контейнер должен базироваться на массиве (Object[] container). Использовать стандартные коллекции JDK (ArrayList, LinkedList и т.д.) запрещено.
 * Контейнер должен быть динамическим, т.е. при полном заполнении увеличиваться.
 * <p>
 * Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция подверглась структурному изменению,
 * итератор должен кидать ConcurrentModificationException.
 * Это достигается через введение счетчика изменений - modCount. Каждая операция, которая структурно модифицирует коллекцию должна инкрементировать этот счетчик.
 * В свою очередь итератор запоминает значение этого счетчика на момент своего создания (expectedModCount), а затем на каждой итерации сравнивает сохраненное значение,
 * с текущим значением поля modCount, если они отличаются, то генерируется исключение.
 */
public class MyArrayList<E> implements Iterable<E> {
    private Object[] container;
    private int modCount;
    private int index;

    public MyArrayList(int size) {
        this.container = new Object[size];
    }

    public void add(E value) {
        this.modCount++;
        this.checkContainerCapacity();
        this.container[index++] = value;
    }

    private void checkContainerCapacity() {
        if (index == this.container.length) {
            Object[] newContainer = new Object[this.container.length * 2];
            System.arraycopy(this.container, 0, newContainer, 0, this.container.length);
            this.container = newContainer;
        }
    }

    public E get(int index) {
        if (index < 0 || this.index <= index) {
            throw new NoSuchElementException();
        }
        return (E) this.container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int iteratorIndex;

            @Override
            public boolean hasNext() {
                this.checkContainerModification();
                return this.iteratorIndex < index;
            }

            private void checkContainerModification() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public E next() {
                this.checkContainerModification();
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[iteratorIndex++];
            }
        };
    }
}
