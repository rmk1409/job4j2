package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Задание.
 * 1. Реализуйте метод unavailable.
 * source - имя файла лога
 * target - имя файла после анализа.
 * <p>
 * 2. Метод anavailable должен находить диапазоны, когда сервер не работал.
 * Сервер не работал. если status = 400 или 500.
 * Диапазон считается последовательность статусов 400 и 500
 * Например:
 * 200 10:56:01
 * 500 10:57:01
 * 400 10:58:01
 * 200 10:59:01
 * 500 11:01:02
 * 200 11:02:02
 * тут два периода - 10:57:01 до 10:59:01 и 11:01:02 до 11:02:02
 * Начальное время - это время когда статус 400 или 500. конечное время это когда статус меняется с 400 или 500 на 200 300.
 * <p>
 * 3. Результат анализа нужно записать в файл target.
 * Формат файла
 * начала периода;конец периода;
 * <p>
 * 4. Записать тесты.
 * <p>
 * Created by Roman on 08.04.2020
 */
public class Analise {
    public static final String CLIENT_ERROR = "400";
    public static final String SERVER_ERROR = "500";

    /**
     * @param source is log file name
     * @param target is file name for analysis
     */
    public void unavailable(String source, String target) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(source));
        List<String> result = new ArrayList<>();
        String start = "";
        String end;
        for (String line : lines) {
            String[] split = line.split(" ");
            String errorCode = split[0];
            if (start.isEmpty() && (Objects.equals(CLIENT_ERROR, errorCode) || Objects.equals(SERVER_ERROR, errorCode))) {
                start = split[1];
            } else if (!start.isEmpty() && (!Objects.equals(CLIENT_ERROR, errorCode) && !Objects.equals(SERVER_ERROR, errorCode))) {
                end = split[1];
                result.add(String.format("%s;%s", start, end));
                start = "";
            }
        }
        Files.write(Paths.get(target), result);
    }
}
