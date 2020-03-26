package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Roman Pogorelov on 26.03.2020
 */
public class EvenIterator implements Iterator<Integer> {
    private int[] container;
    private int index;

    public EvenIterator(int[] container) {
        this.container = container;
        this.tryToMoveToNextEven();
    }

    private void tryToMoveToNextEven() {
        while (this.index < this.container.length && this.container[this.index] % 2 != 0) {
            this.index++;
        }
    }

    @Override
    public boolean hasNext() {
        return this.index < this.container.length;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int res = this.container[this.index++];
        this.tryToMoveToNextEven();
        return res;
    }
}
