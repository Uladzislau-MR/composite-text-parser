package com.radkevich.parser.impl;

import com.radkevich.parser.CustomParser;
import com.radkevich.validator.CustomArrayValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomParserImpl implements CustomParser  {
    private final CustomArrayValidator validator;

    private final String DELIMITER = "[\\s,;\\-]+";
    private final String LINE_BREAK = "\\r?\\n";

    public CustomParserImpl(CustomArrayValidator validator) {
        this.validator = validator;
    }


    public List<int[]> parse (String entireFileContent) {

        String[] lines = entireFileContent.split(LINE_BREAK);

        return Arrays.stream(lines)
                .map(line -> {

                    return Arrays.stream(line.strip().split(DELIMITER))
                            .filter(validator::isValidInteger)
                            .mapToInt(Integer::parseInt)
                            .toArray();
                })
                .filter(array -> array.length > 0)
                .collect(Collectors.toList());
    }
}
