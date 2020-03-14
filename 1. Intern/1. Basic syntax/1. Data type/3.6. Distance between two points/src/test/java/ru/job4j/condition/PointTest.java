package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. Создайте класс ru.job4j.condition.PointTest. Напишите код по аналогии с классом ru.job4j.converter.ConverterTest.
 * 2. Создайте в нем тест-методы для проверки расстояний между точками в системе координат.
 */
public class PointTest {
    @Test
    public void distance() {
        double expected = 2;
        Assert.assertEquals(expected, Point.distance(0, 0, 2, 0), 0.01);
    }
}
