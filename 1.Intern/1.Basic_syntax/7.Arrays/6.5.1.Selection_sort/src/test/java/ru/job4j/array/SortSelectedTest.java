package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Pogorelov on 17.03.2020
 */
public class SortSelectedTest {
    @Test
    public void whenOdd() {
        int[] input = new int[]{3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[]{1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenEven() {
        int[] input = new int[]{3, 4, 1, 2};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[]{1, 2, 3, 4};
        assertThat(result, is(expect));
    }
}