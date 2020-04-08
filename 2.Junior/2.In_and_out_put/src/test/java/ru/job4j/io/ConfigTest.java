package ru.job4j.io;

import org.junit.Test;

import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman on 06.04.2020
 */
public class ConfigTest {
    @Test
    public void test() throws URISyntaxException {
        String path = ConfigTest.class.getClassLoader().getResource("app.properties").toURI().getPath();
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }
}