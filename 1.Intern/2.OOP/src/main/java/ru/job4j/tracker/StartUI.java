package ru.job4j.tracker;

/**
 * Created by Roman Pogorelov on 17.03.2020
 */
public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            switch (select) {
                case 0:
                    StartUI.createItem(input, tracker);
                    break;
                case 1:
                    StartUI.showAllItems(tracker);
                    break;
                case 2:
                    StartUI.editItem(input, tracker);
                    break;
                case 3:
                    StartUI.deleteItem(input, tracker);
                    break;
                case 4:
                    StartUI.findItemById(input, tracker);
                    break;
                case 5:
                    StartUI.findItemsByName(input, tracker);
                    break;
                case 6:
                    System.out.println("=== Exiting the program ====");
                    run = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + select);
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name1 = input.askStr("Enter name: ");
        for (Item item1 : tracker.findByName(name1)) {
            System.out.println(item1);
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ====");
        String id3 = input.askStr("Enter id: ");
        System.out.println(tracker.findById(id3));
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Deleting the item ====");
        System.out.println("=== Find item by id ====");
        String id2 = input.askStr("Enter id: ");
        boolean result2 = tracker.deleteItemById(id2);
        System.out.println("Deleting: " + (result2 ? "success" : "not success"));
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Editing the item ====");
        System.out.println("=== Find item by id ====");
        String id = input.askStr("Enter id: ");
        boolean result = tracker.editItemById(id, new Item(input.askStr("Enter new name: ")));
        System.out.println("Editing: " + (result ? "success" : "not success"));
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ====");
        for (Item item1 : tracker.findAll()) {
            System.out.println(item1);
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
