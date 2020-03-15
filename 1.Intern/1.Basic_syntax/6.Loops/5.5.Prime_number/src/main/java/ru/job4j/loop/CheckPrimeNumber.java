package ru.job4j.loop;

/**
 * В этом задании нужно проверить, что число является простым. Простым считается число, которое делится только на себя и на единицу.
 */
public class CheckPrimeNumber {
    public static boolean check(int number) {
        boolean prime = true;
        if (number == 1) {
            prime = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    prime = false;
                    break;
                }
            }
        }
        return prime;
    }
}
