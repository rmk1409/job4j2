package ru.job4j.condition;

/**
 * 1. Создайте класс ru.job4j.condition.SqArea. Допишите метод square.
 * 2. Доработайте метод main с демонстрацией работы программы с параметрами p = 6, k = 2, площадь должна быть 2.
 */
public class SqArea {
    public static double square(int p, int k) {
        double h = p / (2.0 * (k + 1));
        double l = h * k;
        return l * h;
    }

    public static void main(String[] args) {
        double result1 = SqArea.square(4, 1);
        System.out.println(" p = 4, k = 1, s = 1, real = " + result1);
        System.out.println(" p = 6, k = 2, s = 2, real = " + SqArea.square(6, 2));
    }
}
