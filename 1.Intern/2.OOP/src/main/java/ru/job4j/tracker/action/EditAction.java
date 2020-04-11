package ru.job4j.tracker.action;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Editing the item ===";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        System.out.println("=== Editing the item ===");
        System.out.println("=== Find item by id ====");
        Long id = Long.valueOf(input.askStr("Enter id: "));
        boolean result = tracker.replace(id, new Item(input.askStr("Enter new name: ")));
        System.out.println("Editing: " + (result ? "success" : "not success"));
        return true;
    }
}
