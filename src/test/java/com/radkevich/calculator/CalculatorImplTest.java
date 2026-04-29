package com.radkevich.calculator;

import com.radkevich.calculator.impl.CustomArrayCalculatorImpl;
import com.radkevich.entity.CustomArray;
import com.radkevich.entity.Statistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorImplTest {
    CustomArrayCalculator calculator;
    CustomArray testArray;

    @BeforeEach
    public void setup() {
        calculator = new CustomArrayCalculatorImpl();
        testArray = new CustomArray(1L, 10, 20, 30);
    }

    @Test
    void createStatisticsSuccessTest() {
        Statistics stats = calculator.createStatistics(testArray);

        Assertions.assertAll("Verify all calculation logic",
                () -> Assertions.assertNotNull(stats, "Statistics object should not be null"),
                () -> Assertions.assertEquals(10, stats.getMin(), "Min value mismatch"),
                () -> Assertions.assertEquals(30, stats.getMax(), "Max value mismatch"),
                () -> Assertions.assertEquals(60, stats.getSum(), "Sum mismatch"),
                () -> Assertions.assertEquals(20.0, stats.getAverage(), 0.001, "Average mismatch")
        );
    }

    @Test
    void findMinTest() {
        int min = calculator.findMin(testArray);
        Assertions.assertEquals(10, min, "Should return the smallest element");
    }

    @Test
    void findMaxTest() {
        int max = calculator.findMax(testArray);
        Assertions.assertEquals(30, max, "Should return the largest element");
    }

    @Test
    void findSumTest() {
        int sum = calculator.findSum(testArray);
        Assertions.assertEquals(60, sum, "Should return correct sum of elements");
    }

    @Test
    void findAverageTest() {
        double average = calculator.findAverage(testArray);
        Assertions.assertEquals(20.0, average, 0.001, "Should return correct average value");
    }
}