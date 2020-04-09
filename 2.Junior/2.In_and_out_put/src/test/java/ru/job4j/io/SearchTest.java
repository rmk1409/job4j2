package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman on 09.04.2020
 */
public class SearchTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    private File txtFile, anotherTxtFile, javaFile;

    @Before
    public void setUp() throws Exception {
        this.txtFile = folder.newFile("a.txt");
        this.anotherTxtFile = folder.newFile("b.txt");
        this.javaFile = folder.newFile("c.java");
    }

    @Test
    public void testTxtFiles() throws IOException {
        assertThat(Search.search(Paths.get(folder.getRoot().getAbsolutePath()), ".txt"), is(List.of(txtFile.getAbsolutePath(), anotherTxtFile.getAbsolutePath())));
    }

    @Test
    public void testJavaFiles() throws IOException {
        assertThat(Search.search(Paths.get(folder.getRoot().getAbsolutePath()), ".java"), is(List.of(javaFile.getAbsolutePath())));
    }

    @Test
    public void testNotFoundFiles() throws IOException {
        assertThat(Search.search(Paths.get(folder.getRoot().getAbsolutePath()), ".js"), is(List.of()));
    }
}