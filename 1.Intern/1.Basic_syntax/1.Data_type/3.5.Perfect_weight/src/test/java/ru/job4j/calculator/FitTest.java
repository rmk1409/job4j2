package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. Создайте класс ru.job4j.calculator.FitTest. Напишите код по аналогии с классом ru.job4j.converter.ConverterTest.
 * 2. Создайте в нем тест-методы для проверки идеального веса для мужчины и женщины.
 */
public class FitTest {
    @Test
    public void manWeight() {
        int in = 178;
        double expected = 89.7;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void womanWeight() {
        int in = 165;
        double expected = 63.24;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
}
