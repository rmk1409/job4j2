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
        int euro = Converter.rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euro.");
        System.out.printf("180 rubles are %d dollars.\n", Converter.rubleToDollar(180));
    }
}
