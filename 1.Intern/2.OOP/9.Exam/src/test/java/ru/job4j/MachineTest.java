package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Pogorelov on 24.03.2020
 */
public class MachineTest {
    private Machine machine = new Machine();

    @Test
    public void whenEquals() {
        int[] expected = {};
        int[] rsl = this.machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by35() {
        int[] expected = {10, 5};
        int[] rsl = this.machine.change(50, 35);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by38() {
        int[] expected = {10, 2};
        assertThat(expected, is(this.machine.change(50, 38)));
    }

    @Test
    public void when50by27() {
        int[] expected = {10, 10, 2, 1};
        assertThat(expected, is(this.machine.change(50, 27)));
    }
}