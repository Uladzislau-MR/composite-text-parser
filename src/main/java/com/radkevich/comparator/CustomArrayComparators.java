package com.radkevich.comparator;

import com.radkevich.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayComparators {
    public static final Comparator<CustomArray> BY_ID =
            Comparator.comparingLong(CustomArray::getId);

    public static final Comparator<CustomArray> BY_FIRST_ELEMENT =
            Comparator.comparingInt(array -> array.getElements()[0]);


public static final Comparator<CustomArray> BY_ARRAY_LENGTH =
        Comparator.comparingInt(array -> array.getElements().length );
}
