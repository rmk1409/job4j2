package ru.job4j.tracker;

import ru.job4j.tracker.action.*;

/**
 * Created by Roman Pogorelov on 17.03.2020
 */
public class StartUI {
    public void init(Input input, ITracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            System.out.printf("%d. %s%n", i, actions[i].name());
        }
    }


    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        ITracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindAllAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new EditAction(),
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
