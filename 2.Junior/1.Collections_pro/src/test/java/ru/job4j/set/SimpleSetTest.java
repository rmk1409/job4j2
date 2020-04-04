package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * Created by Roman on 04.04.2020
 */
public class SimpleSetTest {
    @Test
    public void add() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(null);
        set.add(1);
        set.add(2);
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.next(), is(1));
        assertNull(iterator.next());
        assertThat(iterator.next(), is(2));
        assertFalse(iterator.hasNext());
    }
}