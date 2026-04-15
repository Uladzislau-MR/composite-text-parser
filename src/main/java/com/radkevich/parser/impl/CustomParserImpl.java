package com.radkevich.parser.impl;

import com.radkevich.parser.CustomParser;
import com.radkevich.validator.CustomArrayValidator;
import com.radkevich.validator.impl.CustomArrayValidatorImpl;

import java.util.Arrays;

public class CustomParserImpl implements CustomParser {
    private final CustomArrayValidator validator;

    public CustomParserImpl(CustomArrayValidator validator) {
        this.validator = validator;
    }

    public int[] parseInt(String line) {
        String delimiter = "[\\s,;\\-]+";
        return  Arrays.stream(line.strip().split(delimiter))
                .filter(validator::isValidInteger)
                .mapToInt(Integer::parseInt)
                .toArray();

    }

}
