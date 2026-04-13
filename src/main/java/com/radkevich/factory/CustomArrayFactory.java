package com.radkevich.factory;

import com.radkevich.entity.CustomArray;

public interface CustomArrayFactory {

    CustomArray createStrict(String line);
    CustomArray createFlexible(String line);
    int[] parseToInts(String[] parts);
}
