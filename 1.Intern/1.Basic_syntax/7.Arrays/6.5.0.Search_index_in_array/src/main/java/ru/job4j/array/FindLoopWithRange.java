package ru.job4j.array;

/**
 * Теперь нужно сделать поиск по массиву, но не во всем массиве, а только в указанном диапазоне.
 * Created by Roman Pogorelov on 17.03.2020
 */
public class FindLoopWithRange extends FindLoop {
    public static int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = start; i < finish; i++) {
            if (el == data[i]) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
