package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FactorialTest {
    @Test
    public void whenFiveThenOneHundredTwenty() {
        int expected = 120;
        assertThat(expected, is(Factorial.calc(5)));
    }

    @Test
    public void whenZeroThenOne() {
        int expected = 1;
        assertThat(expected, is(Factorial.calc(0)));
    }

    @Test
    public void whenOneThenOne() {
        int expected = 1;
        assertThat(expected, is(Factorial.calc(1)));
    }
}