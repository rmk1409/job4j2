package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Roman on 09.04.2020
 */
public class ArgZipTest {
    private ArgZip arg = new ArgZip(new String[]{"-d", "c:\\project\\job4j\\", "-e", "*.java", "-o", "project.zip"});

    @Test
    public void valid() {
        assertTrue(this.arg.valid());
    }

    @Test
    public void validFalse() {
        this.arg = new ArgZip(new String[]{"-d", "c:\\project\\job4j\\", "-e", "*.java", "-o"});
        assertFalse(this.arg.valid());
    }

    @Test
    public void directory() {
        assertThat(this.arg.directory(), is("c:\\project\\job4j\\"));
    }

    @Test
    public void exclude() {
        assertThat(this.arg.exclude(), is("*.java"));
    }

    @Test
    public void output() {
        assertThat(this.arg.output(), is("project.zip"));
    }
}