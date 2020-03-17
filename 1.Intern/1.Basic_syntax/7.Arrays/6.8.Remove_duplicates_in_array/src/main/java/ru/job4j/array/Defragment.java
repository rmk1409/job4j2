package ru.job4j.array;

/**
 * В этом уроке необходимо написать код, который будет перемещать заполненные ячейки массива в начало, а пустые в конец.
 * Для выполнения этой задачи нужно использовать: цикл for с индексом, цикл while для поиска заполненной ячейки, оператор условия if.
 * Created by Roman Pogorelov on 17.03.2020
 */
public class Defragment {
    public static String[] compress(String[] array) {
        int nullQuantity = 0;
        for (int index = 0; index < array.length - nullQuantity; index++) {
            if (array[index] == null) {
                nullQuantity++;
                int point = index;
                while (point < array.length && array[point] == null) {
                    point++;
                }
                if (point < array.length && array[point] != null) {
                    array[index] = array[point];
                    array[point] = null;
                }
            }
            System.out.print(array[index] + " ");
        }
        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}
