package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman on 08.04.2020
 */
public class AnaliseTest {

    @Test
    public void test() throws IOException, URISyntaxException {
        String sourcePath = AnaliseTest.class.getClassLoader().getResource("server.log").toURI().getPath();
        String targetPath = AnaliseTest.class.getResource("/").getPath() + "time.log";
        new Analise().unavailable(sourcePath, targetPath);
        List<String> actual = new BufferedReader(new FileReader(targetPath)).lines().collect(Collectors.toList());
        List<String> expected = List.of("10:58:01;10:59:01", "11:01:02;11:02:02");
        assertThat(actual, is(expected));
    }
}