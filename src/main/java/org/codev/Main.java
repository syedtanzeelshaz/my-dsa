package org.codev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String COURSE_NAME = "Codev DSA Course in Java";

    public static void main(String[] args) {
        log.info("Welcome to the {}", COURSE_NAME);
    }
}