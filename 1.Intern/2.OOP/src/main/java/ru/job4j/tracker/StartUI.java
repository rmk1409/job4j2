package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Created by Roman Pogorelov on 17.03.2020
 */
public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("=== Show all items ====");
                    for (Item item1 : tracker.findAll()) {
                        System.out.println(item1);
                    }
                    break;
                case 2:
                    System.out.println("=== Editing the item ====");
                    System.out.println("=== Find item by id ====");
                    System.out.print("Enter id: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    boolean result = tracker.editItemById(id, new Item(scanner.nextLine()));
                    System.out.println("Editing: " + (result ? "success" : "not success"));
                    break;
                case 3:
                    System.out.println("=== Deleting the item ====");
                    System.out.println("=== Find item by id ====");
                    System.out.print("Enter id: ");
                    String id2 = scanner.nextLine();
                    boolean result2 = tracker.deleteItemById(id2);
                    System.out.println("Deleting: " + (result2 ? "success" : "not success"));
                    break;
                case 4:
                    System.out.println("=== Find item by id ====");
                    System.out.print("Enter id: ");
                    String id3 = scanner.nextLine();
                    System.out.println(tracker.findById(id3));
                    break;
                case 5:
                    System.out.println("=== Find items by name ====");
                    System.out.print("Enter name: ");
                    String name1 = scanner.nextLine();
                    for (Item item1 : tracker.findByName(name1)) {
                        System.out.println(item1);
                    }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
