package ru.job4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Roman Pogorelov on 25.03.2020
 */
public class School {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(e -> e.getScore() > bound)
                .collect(Collectors.toList());
    }
}
