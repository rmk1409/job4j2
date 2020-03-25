package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Реализовать метод подсчета функции в диапазоне
 * Created by Roman Pogorelov on 25.03.2020
 */
public class MyFunction {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double i = start; i < end; i++) {
            result.add(func.apply(i));
        }
        return result;
    }
}
