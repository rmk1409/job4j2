package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Created by Roman Pogorelov on 25.03.2020
 */
public class SchoolTest {
    private List<Student> students;
    private School school;

    @Before
    public void setUp() {
        this.students = new ArrayList<>();
        this.students.add(new Student(100));
        this.students.add(new Student(90));
        this.students.add(new Student(80));
        this.students.add(new Student(70));
        this.students.add(new Student(60));
        this.students.add(new Student(50));
        this.students.add(new Student(40));
        this.students.add(new Student(30));
        this.students.add(new Student(20));
        this.students.add(new Student(10));
        this.students.add(new Student(0));
        this.school = new School();
    }

    @Test
    public void list1() {
        List<Student> expected = List.of(new Student(100), new Student(90), new Student(80), new Student(70));
        assertThat(expected, is(this.school.collect(this.students, student -> student.getScore() >= 70)));
    }

    @Test
    public void list2() {
        List<Student> expected = List.of(new Student(60), new Student(50));
        assertThat(expected, is(this.school.collect(this.students, student -> student.getScore() < 70 && student.getScore() >= 50)));
    }

    @Test
    public void list3() {
        List<Student> expected = List.of(new Student(40), new Student(30), new Student(20), new Student(10));
        assertThat(expected, is(this.school.collect(this.students, student -> student.getScore() < 50 && student.getScore() > 0)));
    }

    @Test
    public void toMap() {
        Map<String, Student> expected = Map.of("Petrov", new Student(100, "Petrov"), "Ivanov", new Student(200, "Ivanov"));
        assertThat(expected, is(this.school.collectToMap(List.of(new Student(100, "Petrov"), new Student(200, "Ivanov")))));
    }
}