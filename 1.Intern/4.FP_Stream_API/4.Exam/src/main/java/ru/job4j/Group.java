package ru.job4j;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Roman Pogorelov on 25.03.2020
 */
public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getUnits().stream()
                        .map(unit -> new Holder(unit, student.getName())))
                .collect(
                        Collectors.groupingBy(t -> t.key, Collectors.mapping(e -> e.value, Collectors.toSet())));
    }

    static class Holder {
        public String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
