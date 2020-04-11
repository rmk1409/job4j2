package ru.job4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by Roman on 11.04.2020
 */
public class UsageLog4j {
    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
