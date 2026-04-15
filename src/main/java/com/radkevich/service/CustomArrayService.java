package com.radkevich.service;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface CustomArrayService {

    OptionalInt findMin(String fileName);

    OptionalInt findMax(String fileName);

    int findSum(String fileName);

    OptionalDouble findAverage(String fileName);

    int[] sortBubble(String fileName);

    int[] sortSelection(String fileName);
}


