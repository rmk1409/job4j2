package ru.job4j.array;

/**
 * Created by Roman Pogorelov on 17.03.2020
 */
public class SortSelected {
    public static int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = findMin(data, i, data.length);
            int index = FindLoopWithRange.indexOf(data, min, i, data.length);
            if (i != index) {
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
            }
        }
        return data;
    }

    private static int findMin(int[] data, int start, int finish) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < finish; i++) {
            if (min > data[i]) {
                min = data[i];
            }
        }
        return min;
    }
}
