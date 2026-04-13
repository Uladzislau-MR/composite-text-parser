package com.radkevich.service;

import com.radkevich.validator.ValidationMode;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface CustomArrayService {

    OptionalInt findMin(String fileName, ValidationMode mode);

    OptionalInt findMax(String fileName, ValidationMode mode);

    int findSum(String fileName, ValidationMode mode);

    OptionalDouble findAverage(String fileName, ValidationMode mode);

    int[] sortBubble(String fileName, ValidationMode mode);

    int[] sortSelection(String fileName, ValidationMode mode);
}


