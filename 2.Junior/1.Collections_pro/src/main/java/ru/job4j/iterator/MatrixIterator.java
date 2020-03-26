package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Roman Pogorelov on 26.03.2020
 */
public class MatrixIterator implements Iterator<Integer> {
    private int[][] container;
    private int vertical, horizontal;

    public MatrixIterator(int[][] container) {
        this.container = container;
    }

    @Override
    public boolean hasNext() {
        return this.vertical < this.container.length;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int res = this.container[vertical][horizontal++];
        if (horizontal == this.container[vertical].length) {
            horizontal = 0;
            vertical++;
        }
        return res;
    }
}
