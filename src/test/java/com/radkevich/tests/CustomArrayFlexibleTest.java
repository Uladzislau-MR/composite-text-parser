package com.radkevich.tests;

import com.radkevich.service.CustomArrayService;
import com.radkevich.service.impl.CustomArrayServiceImpl;
import com.radkevich.validator.ValidationMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayFlexibleTest {
    CustomArrayService customArrayService;
    String fileName = "Data.txt";

    @BeforeEach
    public void setup() {
        customArrayService = new CustomArrayServiceImpl();
    }

    @Test
    public void sum() {
        int sum = customArrayService.findSum(fileName, ValidationMode.FLEXIBLE);
        Assertions.assertEquals(155, sum, "The calculated sum in FLEXIBLE mode does not match the expected value.");
    }

    @Test
    public void min() {
        OptionalInt min = customArrayService.findMin(fileName, ValidationMode.FLEXIBLE);
        Assertions.assertTrue(min.isPresent(), "Minimum value should be present in FLEXIBLE mode.");
        Assertions.assertEquals(1, min.getAsInt(), "The minimum value in FLEXIBLE mode does not match expected.");
    }

    @Test
    public void max() {
        OptionalInt max = customArrayService.findMax(fileName, ValidationMode.FLEXIBLE);
        Assertions.assertTrue(max.isPresent(), "Maximum value should be present in FLEXIBLE mode.");
        Assertions.assertEquals(77, max.getAsInt(), "The maximum value in FLEXIBLE mode does not match expected.");
    }

    @Test
    public void average() {
        OptionalDouble avg = customArrayService.findAverage(fileName, ValidationMode.FLEXIBLE);
        Assertions.assertTrue(avg.isPresent(), "Average value should be present in FLEXIBLE mode.");
        Assertions.assertEquals(12.916, avg.getAsDouble(), 0.01, "The average value in FLEXIBLE mode does not match expected.");
    }

    @Test
    public void sortBubble() {
        int[] result = customArrayService.sortBubble(fileName, ValidationMode.FLEXIBLE);
        int[] expected = {1, 1, 2, 2, 2, 3, 3, 5, 6, 11, 42, 77};

        Assertions.assertArrayEquals(expected, result, "Bubble sort result (FLEXIBLE) does not match expected array.");
    }

    @Test
    public void sortSelection() {
        int[] result = customArrayService.sortSelection(fileName, ValidationMode.FLEXIBLE);
        int[] expected = {1, 1, 2, 2, 2, 3, 3, 5, 6, 11, 42, 77};

        Assertions.assertArrayEquals(expected, result, "Selection sort result (FLEXIBLE) does not match expected array.");
    }
}