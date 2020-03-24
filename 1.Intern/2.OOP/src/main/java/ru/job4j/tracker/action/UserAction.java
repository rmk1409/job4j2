package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
