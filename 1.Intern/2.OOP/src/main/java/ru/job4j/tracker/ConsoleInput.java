package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Created by Roman Pogorelov on 20.03.2020
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return this.scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        System.out.print(question);
        return Integer.parseInt(this.scanner.nextLine());
    }
}
