package ru.job4j.io;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * В классе нужно прочитать файл even.txt. Для каждого числа проверить является ли оно четным числом. Ответ вывести на консоль
 * <p>
 * Created by Roman on 06.04.2020
 */
public class EvenNumberFile {
    public static void main(String[] args) throws URISyntaxException {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(EvenNumberFile.class.getClassLoader().getResource("event.txt").toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.forEach(e -> {
            String output = "even";
            if (Integer.parseInt(e) % 2 != 0) {
                output = "odd";
            }
            System.out.println(output);
        });
    }
}
