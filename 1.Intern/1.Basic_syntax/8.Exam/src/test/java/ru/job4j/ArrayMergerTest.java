package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Pogorelov on 17.03.2020
 */
public class ArrayMergerTest {
    @Test
    public void whenBothEmpty() {
        ArrayMerger algo = new ArrayMerger();
        int[] expect = new int[0];
        int[] result = algo.merge(
                new int[0],
                new int[0]
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenAscOrder() {
        ArrayMerger algo = new ArrayMerger();
        int[] expect = {1, 2, 3, 4};
        int[] result = algo.merge(
                new int[]{1, 2},
                new int[]{3, 4}
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenLeftLess() {
        ArrayMerger algo = new ArrayMerger();
        int[] expect = {1, 2, 3, 3, 4};
        int[] result = algo.merge(
                new int[]{1, 2, 3},
                new int[]{3, 4}
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenLeftGreat() {
        ArrayMerger algo = new ArrayMerger();
        int[] expect = {1, 2, 3, 4, 4};
        int[] result = algo.merge(
                new int[]{1, 2},
                new int[]{3, 4, 4}
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenLeftEmpty() {
        ArrayMerger algo = new ArrayMerger();
        int[] expect = {1, 2, 3, 4};
        int[] result = algo.merge(
                new int[]{},
                new int[]{1, 2, 3, 4}
        );
        assertThat(result, is(expect));
    }
}