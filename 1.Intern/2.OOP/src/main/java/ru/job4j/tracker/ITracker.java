package ru.job4j.tracker;

import java.util.List;

/**
 * Created by Roman on 11.04.2020
 */
public interface ITracker {
    Item add(Item item);
    boolean replace(String id, Item item);
    boolean delete(String id);
    List<Item> findAll();
    List<Item> findByName(String key);
    Item findById(String id);
}
