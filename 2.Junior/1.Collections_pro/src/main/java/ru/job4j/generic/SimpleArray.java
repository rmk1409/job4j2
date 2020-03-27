package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;

/**
 * В этом задании необходимо сделать универсальную обертку над массивом.
 * Также, реализуйте интерфейс Iterable<T> - метод iterator() возвращает итератор, предназначенный для обхода данной структуры.
 * <p>
 * Объект должен принимать количество ячеек. Структура не должна быть динамической. Если идет переполнение надо выкинуть ошибку.
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int index;

    public SimpleArray(int size) {
        this.container = new Object[size];
    }

    public void add(T model) {
        if (this.index == this.container.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.container[index++] = model;
    }

    public void set(int index, T model) {
        if (index >= this.container.length) {
            throw new IllegalArgumentException();
        }
        this.container[index] = model;
    }

    public void remove(int index) {
        if (index >= this.index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.index--;
        System.arraycopy(this.container, index + 1, this.container, index, this.container.length - index - 1);
    }

    public T get(int index) {
        if (index >= this.index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) this.container[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(this.container);
    }

    public static void main(String[] args) {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        System.out.println(array);

        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println(array);

        Integer integer = array.get(2);
        System.out.println(integer);
        System.out.println(array);

        array.set(2, 10);
        System.out.println(array);

        array.remove(1);
        System.out.println(array);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int i;

            @Override
            public boolean hasNext() {
                return this.i < index;
            }

            @Override
            public T next() {
                return (T) container[i++];
            }
        };
    }
}
