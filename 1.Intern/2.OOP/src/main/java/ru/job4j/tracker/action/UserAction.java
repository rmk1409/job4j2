package ru.job4j.tracker.action;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public interface UserAction {
    String name();

    boolean execute(Input input, ITracker tracker);
}
