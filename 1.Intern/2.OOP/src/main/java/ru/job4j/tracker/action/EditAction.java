package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Editing the item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Editing the item ===");
        System.out.println("=== Find item by id ====");
        String id = input.askStr("Enter id: ");
        boolean result = tracker.editItemById(id, new Item(input.askStr("Enter new name: ")));
        System.out.println("Editing: " + (result ? "success" : "not success"));
        return true;
    }
}
