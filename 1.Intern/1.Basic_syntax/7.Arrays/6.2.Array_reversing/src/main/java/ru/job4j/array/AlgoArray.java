package ru.job4j.array;

/**
 * Допишите остальные операторы в метод main класса AlgoArray так, чтобы элементы массива располагались по возрастанию.
 * Created by Roman Pogorelov on 17.03.2020
 */
public class AlgoArray {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 2, 1, 4};
        int temp = array[0]; // переменная для временного хранения значение ячейки с индексом 0.
        array[0] = array[3]; // записываем в ячейку с индексом 0 значение ячейки с индексом 3.
        array[3] = temp; // записываем в ячейку с индексом 3 значение временной переменной.
        temp = array[1];
        array[1] = array[2];
        array[2] = temp;
        temp = array[3];
        array[3] = array[4];
        array[4] = temp;
        for (int i : array) {
            System.out.println(i);
        }
    }
}
