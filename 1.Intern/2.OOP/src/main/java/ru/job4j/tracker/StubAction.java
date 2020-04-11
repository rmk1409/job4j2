package ru.job4j.tracker;

import ru.job4j.tracker.action.UserAction;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public class StubAction implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
