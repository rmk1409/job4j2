package ru.job4j.tracker;

/**
 * Created by Roman Pogorelov on 18.03.2020
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);
}
