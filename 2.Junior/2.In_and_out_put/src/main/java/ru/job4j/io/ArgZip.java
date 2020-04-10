package ru.job4j.io;

/**
 * Created by Roman on 09.04.2020
 */
public class ArgZip {
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        return this.args.length == 6;
    }

    public String directory() {
        return this.args[1];
    }

    public String exclude() {
        return this.args[3];
    }

    public String output() {
        return this.args[5];
    }
}
