package com.radkevich.factory.impl;

import com.radkevich.entity.CustomArray;
import com.radkevich.factory.CustomArrayFactory;
import com.radkevich.validator.CustomArrayValidator;
import com.radkevich.validator.impl.CustomArrayValidatorImpl;

import java.util.Arrays;

public class CustomArrayFactoryImpl implements CustomArrayFactory {


    private final CustomArrayValidator validator = new CustomArrayValidatorImpl();

    @Override
    public CustomArray createStrict(String line) {

        String[] parts = validator.extractStrict(line);
        return new CustomArray(parseToInts(parts));
    }

    @Override
    public CustomArray createFlexible(String line) {
        String[] parts = validator.extractFlexible(line);

        return new CustomArray(parseToInts(parts));
    }

    @Override
    public int[] parseToInts(String[] parts) {
        // Если пришел пустой список строк, отдаем пустой массив
        if (parts == null || parts.length == 0) {
            return new int[0];
        }


        return Arrays.stream(parts)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

