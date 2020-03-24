package ru.job4j;

import java.util.Arrays;

/**
 * В этом задании нужно реализовать механизм возврата монет в eендинговых аппаратах, используя жадный алгоритм.
 * <p>
 * У вас есть купюра 50, 100 рублей. Вы хотите купить кофе на 35. Если вы засунули 50 рублей, то автомат должен вернут 15 рублей (монетами 10 и 5).
 * <p>
 * Created by Roman Pogorelov on 24.03.2020
 */
public class Machine {
    private static final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        money -= price;
        for (int currentCoin : COINS) {
            while (money - currentCoin >= 0) {
                rsl[size++] = currentCoin;
                money -= currentCoin;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
