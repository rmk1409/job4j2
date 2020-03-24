package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Deleting the item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Deleting the item ===");
        System.out.println("=== Find item by id ====");
        String id = input.askStr("Enter id: ");
        boolean result = tracker.deleteItemById(id);
        System.out.println("Deleting: " + (result ? "success" : "not success"));
        return true;
    }
}
