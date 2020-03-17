package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Roman Pogorelov on 17.03.2020
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище.
     *
     * @param item новая заявка.
     */
    public Item add(Item item) {
        if (item != null) {
            item.setId(generateId());
        }
        items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + new Random().nextLong());
    }

    /**
     * Method finds Item by Id or return null.
     *
     * @param id is used to search.
     * @return item or null.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (id.equals(item.getId())) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Method returns all not null items.
     *
     * @return array with not null items.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        int size = 0;
        for (Item item : this.items) {
            if (item != null) {
                result[size++] = item;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    /**
     * Methods finds all items with concrete name.
     *
     * @param name is used to search.
     * @return array with items.
     */
    public Item[] findByName(String name) {
        Item[] all = this.findAll();
        Item[] result = new Item[all.length];
        int size = 0;
        for (Item item : all) {
            if (name.equals(item.getName())) {
                result[size++] = item;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }
}
