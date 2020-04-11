package ru.job4j.tracker.action;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        System.out.println("=== Show all items ===");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        return true;
    }
}
