package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Roman on 04.04.2020
 */
public class MyArrayListTest {
    private MyArrayList<String> container;

    @Before
    public void setUp() {
        this.container = new MyArrayList<>(10);
        this.container.add("Hello");
        this.container.add("World");
    }

    @Test
    public void add() {
        String testData = "And";
        this.container.add(testData);
        assertThat(testData, is(this.container.get(2)));
    }

    @Test
    public void get() {
        assertThat("Hello", is(this.container.get(0)));
    }

    @Test(expected = NoSuchElementException.class)
    public void getNoSuchElementException() {
        this.container.get(3);
    }

    @Test
    public void iteratorHasNext() {
        Iterator<String> iterator = this.container.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorNext() {
        Iterator<String> iterator = this.container.iterator();
        assertThat("Hello", is(iterator.next()));
        assertThat("World", is(iterator.next()));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iteratorConcurrentModificationException() {
        Iterator<String> iterator = this.container.iterator();
        this.container.add("And");
        iterator.hasNext();
    }
}