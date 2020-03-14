package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. Подключите в вашему проекту библиотеки junit + hamcrest.
 * 2. Создайте класс ru.job4j.converter.ConverterTest.
 */
public class ConverterTest {
    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void rubleToDollar() {
        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }
}
