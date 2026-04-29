package com.radkevich.calculator.impl;

import com.radkevich.calculator.CustomArrayCalculator;
import com.radkevich.entity.CustomArray;
import com.radkevich.entity.Statistics;

import java.util.Arrays;

public class CustomArrayCalculatorImpl implements CustomArrayCalculator {

    @Override
    public Statistics createStatistics(CustomArray array) {
        return new Statistics(findMin(array), findMax(array), findSum(array), findAverage(array));
    }

    @Override
    public int findMin(CustomArray array) {
        return Arrays.stream(array.getElements()).min().getAsInt();
    }

    @Override
    public int findMax(CustomArray array) {

        return Arrays.stream(array.getElements()).max().getAsInt();

    }

    @Override
    public int findSum(CustomArray array) {

        return Arrays.stream(array.getElements()).sum();

    }

    @Override
    public double findAverage(CustomArray array) {

        return Arrays.stream(array.getElements()).average().getAsDouble();


    }
}
