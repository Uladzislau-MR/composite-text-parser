package com.radkevich.validator.impl;

import com.radkevich.validator.CustomArrayValidator;


public class CustomArrayValidatorImpl implements CustomArrayValidator {


    public boolean isValidInteger(String line) {
        if (line == null || line.isEmpty()) {
            return false;
        }
        String INT_REGEX = "^[+-]?\\d+$";
        return line.matches(INT_REGEX);
    }
}