package ru.job4j;

/**
 * 1. Реализовать метод конвертации рублей в евро и доллары.
 * <p>
 * То есть вам нужно вместo -1 подставить формулу для вычисления валюты.
 * <p>
 * 1 доллар = 60 рублей.
 * 1 евро = 70 рублей.
 * <p>
 * 2. Доработайте метод main. Добавьте в него примеры выводов всех видов конвертаций.
 */
public class Converter {
    public static final int ONE_EURO = 70;
    public static final int ONE_DOLLAR = 60;

    public static int rubleToEuro(int value) {
        return value / ONE_EURO;
    }

    public static int rubleToDollar(int value) {
        return value / ONE_DOLLAR;
    }

    public static void main(String[] args) {
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2 euros. Test result: " + passed);
        int in2 = 180;
        int expected2 = 3;
        int out2 = rubleToDollar(in2);
        boolean passed2 = expected2 == out2;
        System.out.println("180 rubles are 3 dollars. Test result: " + passed2);
    }
}
