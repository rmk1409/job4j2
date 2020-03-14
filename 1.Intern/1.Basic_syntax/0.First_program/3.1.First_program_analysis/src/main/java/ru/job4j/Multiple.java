package ru.job4j;

/**
 * 1. Создайте новый класс ru.job4j.ru.job4j.Multiple.
 * <p>
 * 2. Создайте в нем метод main по аналогии с классом ru.job4j.StudentInfo.
 * <p>
 * 3. Добавьте в него вывод таблицы умножения на один.
 * <p>
 * 1 * 2 = 2
 * <p>
 * 1 * 3 = ...
 * <p>
 * 1 * 9 = ..
 * <p>
 * В одной строчке должен быть один пример.
 * <p>
 * System.out.println("1 * 9 = 9");
 * <p>
 * 4. Загрузите файл ru.job4j.Multiple.java на сайт github и оставьте ссылку на изменения.
 */
public class Multiple {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("1 * %d = %d\n", i, i);
        }
    }
}