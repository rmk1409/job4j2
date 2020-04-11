package ru.job4j.tracker;

/**
 * Created by Roman Pogorelov on 17.03.2020
 */
public class Item {
    private Long id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + '}';
    }
}
