package ru.job4j.array;

/**
 * В элементах таблицы вам нужно записать элементы таблицы умножения
 * Created by Roman Pogorelov on 17.03.2020
 */
public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}