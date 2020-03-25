package ru.job4j.lambda.ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Roman Pogorelov on 25.03.2020
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        Predicate<Person> testByName = person -> key.equals(person.getName());
        Predicate<Person> testBySurname = person -> key.equals(person.getSurname());
        Predicate<Person> testByAddress = person -> key.equals(person.getAddress());
        Predicate<Person> testByPhone = person -> key.equals(person.getPhone());
        Predicate<Person> combine = testByName.or(testBySurname).or(testByAddress).or(testByPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
