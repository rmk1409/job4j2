package ru.job4j.array;

/**
 * Метод проверяет то, что слово начинается c определенной последовательности.
 * Created by Roman Pogorelov on 17.03.2020
 */
public class ArrayChar {
    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = true;
        for (int i = 0; i < pref.length; i++) {
            if (word[i] != pref[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
