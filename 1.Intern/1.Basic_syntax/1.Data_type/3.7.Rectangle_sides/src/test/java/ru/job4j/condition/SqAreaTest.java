package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {
    @Test
    public void square() {
        double expected = 1.0;
        Assert.assertEquals(expected, SqArea.square(4, 1), 0.01);
    }
}
