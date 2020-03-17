package ru.job4j.array;

/**
 * Метод проверяет то, что слово заканчивается на определенную последовательность.
 * Created by Roman Pogorelov on 17.03.2020
 */
public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        for (int i = post.length - 1, j = word.length - 1; i >= 0; i--, j--) {
            if (post[i] != word[j]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
