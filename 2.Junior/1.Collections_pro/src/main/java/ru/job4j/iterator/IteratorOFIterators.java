package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Roman Pogorelov on 26.03.2020
 */
public class IteratorOFIterators {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        return new Iterator<>() {
            private Iterator<Integer> currentIterator;
            private boolean hasNext;

            {
                this.moveToNext();
            }

            private void moveToNext() {
                this.hasNext = false;
                while (this.currentIterator == null || !this.currentIterator.hasNext()) {
                    if (!its.hasNext()) {
                        break;
                    }
                    this.currentIterator = its.next();
                }
                if (this.currentIterator != null && this.currentIterator.hasNext()) {
                    this.hasNext = true;
                }
            }

            @Override
            public boolean hasNext() {
                return this.hasNext;
            }

            @Override
            public Integer next() {
                if (!this.currentIterator.hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer res = this.currentIterator.next();
                this.moveToNext();
                return res;
            }
        };
    }
}
