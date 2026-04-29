package com.radkevich.calculator;

import com.radkevich.entity.CustomArray;
import com.radkevich.entity.Statistics;

public interface CustomArrayCalculator {
    Statistics createStatistics(CustomArray array);
    int findMin(CustomArray array);
    int findMax(CustomArray array);
    int findSum(CustomArray array);
    double findAverage(CustomArray array);
}

