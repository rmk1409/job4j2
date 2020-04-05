package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Roman on 05.04.2020
 */
public class MyHashMapTest {
    private MyHashMap<String, String> container = new MyHashMap<>();

    @Before
    public void setUp() {
        this.container.insert("Hi", "First");
        this.container.insert("Hi", "Second");
        this.container.insert("Hi3", "Third");
    }

    @Test
    public void insert() {
        assertThat(this.container.getSize(), is(2));
    }

    @Test
    public void get() {
        assertThat(this.container.get("Hi"), is("First"));
        assertThat(this.container.get("Hi3"), is("Third"));
    }

    @Test
    public void delete() {
        Assert.assertTrue(this.container.delete("Hi"));
        assertThat(this.container.getSize(), is(1));
        Assert.assertTrue(this.container.delete("Hi3"));
        assertThat(this.container.getSize(), is(0));
        Assert.assertFalse(this.container.delete("Hi3"));
    }

    @Test
    public void iteratorHasNext() {
        Iterator<MyHashMap.Node<String, String>> iterator = this.container.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorNext() {
        Iterator<MyHashMap.Node<String, String>> iterator = this.container.iterator();
        MyHashMap.Node<String, String> next = iterator.next();
        assertThat(next.getKey(), is("Hi"));
        assertThat(next.getValue(), is("First"));
        next = iterator.next();
        assertThat(next.getKey(), is("Hi3"));
        assertThat(next.getValue(), is("Third"));
    }

    @Test(expected = NoSuchElementException.class)
    public void noSuchElementException() {
        Iterator<MyHashMap.Node<String, String>> iterator = this.container.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iteratorInsertConcurrentModificationException() {
        Iterator<MyHashMap.Node<String, String>> iterator = this.container.iterator();
        this.container.insert("Hi4", "Fourth");
        iterator.hasNext();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iteratorDeleteConcurrentModificationException() {
        Iterator<MyHashMap.Node<String, String>> iterator = this.container.iterator();
        this.container.delete("Hi");
        iterator.hasNext();
    }
}