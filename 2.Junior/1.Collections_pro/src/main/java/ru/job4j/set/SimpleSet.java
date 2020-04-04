package ru.job4j.set;

import ru.job4j.list.MyArrayList;

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by Roman on 04.04.2020
 */
public class SimpleSet<E> implements Iterable<E> {
    private MyArrayList<E> container = new MyArrayList<>(10);

    public void add(E value) {
        if (!contains(value)) {
            this.container.add(value);
        }
    }

    private boolean contains(E value) {
        boolean result = false;
        for (E current : this.container) {
            if (Objects.equals(current, value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}
