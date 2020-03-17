package ru.job4j.array;

/**
 * Метод должен проверить то, что все элементы в массиве являются true или false
 * Created by Roman Pogorelov on 17.03.2020
 */
public class Check {
    public static boolean mono(boolean[] data) {
        boolean result = true;
        boolean pattern = data[0];
        for (int i = 1; i < data.length; i++) {
            if (pattern != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
