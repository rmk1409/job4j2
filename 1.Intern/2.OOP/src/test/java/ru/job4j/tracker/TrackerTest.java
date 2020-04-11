package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

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
        ITracker tracker = new Tracker();
        assertThat(tracker.findAll().size(), is(0));
        tracker.add(new Item("item1"));
        assertThat(tracker.findAll().size(), is(1));
    }

    @Test
    public void deleteFirst() {
        ITracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertTrue(tracker.delete(item.getId()));
        assertThat(tracker.findAll(), is(List.of(item2, item3)));
    }

    @Test
    public void deleteMiddle() {
        ITracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertTrue(tracker.delete(item2.getId()));
        assertThat(tracker.findAll(), is(List.of(item, item3)));
    }

    @Test
    public void deleteLast() {
        ITracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertTrue(tracker.delete(item3.getId()));
        assertThat(tracker.findAll(), is(List.of(item, item2)));
    }

    @Test
    public void deleteNotSuchElement() {
        ITracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertFalse(tracker.delete(""));
        assertThat(tracker.findAll(), is(List.of(item, item2, item3)));
    }

    @Test
    public void replace() {
        ITracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item item4 = new Item("test4");
        assertTrue(tracker.replace(item2.getId(), item4));
        assertThat(tracker.findAll(), is(List.of(item, item4, item3)));
    }

    @Test
    public void replaceNoSuchElement() {
        ITracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertFalse(tracker.replace("", new Item("test4")));
        assertThat(tracker.findAll(), is(List.of(item, item2, item3)));
    }

    @Test
    public void findById() {
        ITracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findByName() {
        ITracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = tracker.findByName(item.getName());
        assertThat(result, is(List.of(item, item2)));
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
        List<Item> result = tracker.findAll();
        assertThat(result, is(List.of(item, item2, item3)));
    }
}