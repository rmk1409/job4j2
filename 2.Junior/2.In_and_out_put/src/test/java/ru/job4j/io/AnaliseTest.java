package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman on 08.04.2020
 */
public class AnaliseTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void test() throws IOException {
        File sourceFile = this.folder.newFile("server1.log");
        File targetFile = this.folder.newFile("time1.log");
        try (PrintWriter out = new PrintWriter(sourceFile)) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        String targetPath = targetFile.getAbsolutePath();
        new Analise().unavailable(sourceFile.getAbsolutePath(), targetPath);
        List<String> actual = Files.readAllLines(Paths.get(targetPath));
        List<String> expected = List.of("10:58:01;10:59:01", "11:01:02;11:02:02");
        assertThat(actual, is(expected));
    }
}