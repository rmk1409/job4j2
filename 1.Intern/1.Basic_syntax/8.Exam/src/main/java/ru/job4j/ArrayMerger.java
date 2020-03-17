package ru.job4j;

import java.util.Arrays;

/**
 * Combine two sorted arrays.
 * Created by Roman Pogorelov on 17.03.2020
 */
public class ArrayMerger {
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            rsl[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) {
            rsl[k++] = left[i++];
        }
        while (j < right.length) {
            rsl[k++] = right[j++];
        }
        return rsl;
    }

    public static void main(String[] args) {
        ArrayMerger process = new ArrayMerger();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
