package ru.job4j.loop;

/**
 * 1. Необходимо создать класс PrimeNumber;
 * 2. В классе PrimeNumber написать метод
 * public int calc(int finish)
 * <p>
 * 3. Метод должен вычислять количество простых чисел от 1 до X включительно
 * <p>
 * Пример:
 * <p>
 * finish = 5, то мы должны проверить числа 2, 3, 4, 5. Простые числа будут 2, 3, 5. Метод должен вернуть 3.
 */
public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int number = 2; number <= finish; number++) {
            if (CheckPrimeNumber.check(number)) {
                count++;
            }
        }
        return count;
    }
}
