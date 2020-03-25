package ru.job4j;

import java.util.Set;

/**
 * Created by Roman Pogorelov on 25.03.2020
 */
public class Student {
    private String name;
    private Set<String> units;

    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public Set<String> getUnits() {
        return units;
    }
}
