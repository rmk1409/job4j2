package ru.job4j.stream;

import java.util.Objects;

/**
 * Created by Roman Pogorelov on 25.03.2020
 */
public class Student {
    private int score;
    private String surName;

    public Student(int score) {
        this.score = score;
    }

    public Student(int score, String surName) {
        this.score = score;
        this.surName = surName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surName, student.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surName);
    }
}
