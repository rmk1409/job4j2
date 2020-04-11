package ru.job4j.tracker.action;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "=== Exiting the program ===";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        System.out.println("=== Exiting the program ===");
        return false;
    }
}
