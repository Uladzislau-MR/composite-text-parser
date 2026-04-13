package com.radkevich.validator;

import java.util.Arrays;

public interface CustomArrayValidator {

    public String[] extractStrict(String line);
    public String[] extractFlexible(String line);

}
