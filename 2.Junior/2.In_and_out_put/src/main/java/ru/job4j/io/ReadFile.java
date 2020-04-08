package ru.job4j.io;

import java.io.FileInputStream;

/**
 * Created by Roman on 06.04.2020
 */
public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream(
                ReadFile.class.getClassLoader()
                        .getResource("input.txt")
                        .getFile())) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}