package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Pogorelov on 25.03.2020
 */
public class FlatMapUsageTest {
    @Test
    public void test() {
        FlatMapUsage flatMapUsage = new FlatMapUsage();
        List<Integer> expected = List.of(1, 1, 2, 1, 2, 3);
        assertThat(expected, is(flatMapUsage.convert(new Integer[][]{{1}, {1, 2}, {1, 2, 3}})));
    }
}