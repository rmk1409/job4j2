package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Created by Roman Pogorelov on 25.03.2020
 */
public class SchoolTest {
    private List<Student> students;

    @Before
    public void setUp() {
        this.students = new ArrayList<>();
        this.students.add(new Student(100, "best"));
        this.students.add(new Student(90, "some"));
        this.students.add(new Student(80, "some"));
        this.students.add(null);
        this.students.add(new Student(70, "some"));
        this.students.add(new Student(60, "some"));
        this.students.add(null);
        this.students.add(new Student(50, "middle"));
        this.students.add(null);
        this.students.add(new Student(40, "bad"));
        this.students.add(new Student(30, "bad"));
        this.students.add(new Student(20, "bad"));
        this.students.add(new Student(10, "bad"));
        this.students.add(new Student(0, "bad"));
    }

    @Test
    public void list1() {
        var expected = List.of(new Student(100, "best"),
                new Student(90, "some"), new Student(80, "some"), new Student(70, "some"));
        var value = School.levelOf(this.students, 60);
        assertThat(expected, is(value));
    }
}