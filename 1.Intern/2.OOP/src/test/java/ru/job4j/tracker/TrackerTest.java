package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Roman Pogorelov on 17.03.2020
 */
public class TrackerTest {
    @Test
    public void addItem() {
        Tracker tracker = new Tracker();
        assertThat(tracker.findAll().length, is(0));
        tracker.add(new Item("item1"));
        assertThat(tracker.findAll().length, is(1));
    }

    @Test
    public void deleteFirst() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertTrue(tracker.deleteItemById(item.getId()));
        assertThat(tracker.findAll(), is(new Item[]{item2, item3}));
    }

    @Test
    public void deleteMiddle() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertTrue(tracker.deleteItemById(item2.getId()));
        assertThat(tracker.findAll(), is(new Item[]{item, item3}));
    }

    @Test
    public void deleteLast() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertTrue(tracker.deleteItemById(item3.getId()));
        assertThat(tracker.findAll(), is(new Item[]{item, item2}));
    }

    @Test
    public void deleteNotSuchElement() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertFalse(tracker.deleteItemById(""));
        assertThat(tracker.findAll(), is(new Item[]{item, item2, item3}));
    }

    @Test
    public void replace() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item item4 = new Item("test4");
        assertTrue(tracker.editItemById(item2.getId(), item4));
        assertThat(tracker.findAll(), is(new Item[]{item, item4, item3}));
    }

    @Test
    public void replaceNoSuchElement() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertFalse(tracker.editItemById("", new Item("test4")));
        assertThat(tracker.findAll(), is(new Item[]{item, item2, item3}));
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findByName(item.getName());
        assertThat(result, is(new Item[]{item, item2}));
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(null);
        tracker.add(item2);
        tracker.add(null);
        tracker.add(item3);
        tracker.add(null);
        Item[] result = tracker.findAll();
        assertThat(result, is(new Item[]{item, item2, item3}));
    }
}