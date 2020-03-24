package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public class UsageArrayList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
