package ru.job4j.tracker.action;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Deleting the item ===";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        System.out.println("=== Deleting the item ===");
        System.out.println("=== Find item by id ====");
        Long id = Long.valueOf(input.askStr("Enter id: "));
        boolean result = tracker.delete(id);
        System.out.println("Deleting: " + (result ? "success" : "not success"));
        return true;
    }
}
