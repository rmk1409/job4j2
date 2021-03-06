package ru.job4j.tracker.action;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        for (Item item : tracker.findByName(name)) {
            System.out.println(item);
        }
        return true;
    }
}
