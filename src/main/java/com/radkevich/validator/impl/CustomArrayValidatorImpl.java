package com.radkevich.validator.impl;

import com.radkevich.validator.CustomArrayValidator;

import java.util.Arrays;

public class CustomArrayValidatorImpl implements CustomArrayValidator {

    private static final String WHITESPACE_DELIMITER = "\\s+";

    private static final String INTEGER_PATTERN = "-?\\d+";

    private static final String NON_DIGIT_DELIMITER = "[^0-9]+";

    public String[] extractStrict(String line) {
        if (line == null || line.isBlank()) {
            return new String[0];
        }

        return Arrays.stream(line.trim().split(WHITESPACE_DELIMITER))
                .filter(s -> s.matches(INTEGER_PATTERN))
                .toArray(String[]::new);
    }

    public String[] extractFlexible(String line) {
        if (line == null || line.isBlank()) {
            return new String[0];
        }

        return Arrays.stream(line.split(NON_DIGIT_DELIMITER))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }
}