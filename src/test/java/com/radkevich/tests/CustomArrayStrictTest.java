package com.radkevich.tests;

import com.radkevich.service.CustomArrayService;
import com.radkevich.service.impl.CustomArrayServiceImpl;
import com.radkevich.validator.ValidationMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayStrictTest {
    CustomArrayService customArrayService;
    String fileName = "Data.txt";

    @BeforeEach
    public void setup() {
        customArrayService = new CustomArrayServiceImpl();
    }
    @Test
    public void sum() {
        int sum = customArrayService.findSum(fileName, ValidationMode.STRICT);
        Assertions.assertEquals(82, sum, "The calculated sum does not match the expected value.");
    }

    @Test
    public void min() {
        OptionalInt min = customArrayService.findMin(fileName, ValidationMode.STRICT);
        Assertions.assertTrue(min.isPresent(), "Minimum value should be present.");
        Assertions.assertEquals(2, min.getAsInt(), "The minimum value does not match the expected one.");
    }

    @Test
    public void max() {
        OptionalInt max = customArrayService.findMax(fileName, ValidationMode.STRICT);
        Assertions.assertTrue(max.isPresent(), "Maximum value should be present.");
        Assertions.assertEquals(77, max.getAsInt(), "The maximum value does not match the expected one.");
    }

    @Test
    public void average() {
        OptionalDouble avg = customArrayService.findAverage(fileName, ValidationMode.STRICT);
        Assertions.assertTrue(avg.isPresent(), "Average value should be present.");
        Assertions.assertEquals(27.33, avg.getAsDouble(), 0.01, "The average value does not match the expected one.");
    }

    @Test
    public void sortBubble() {
        int[] result = customArrayService.sortBubble(fileName, ValidationMode.STRICT);
        int[] expected = {2, 3, 77};

        Assertions.assertArrayEquals(expected, result, "Bubble sort result does not match the expected sorted array.");
    }

    @Test
    public void sortSelection() {
        int[] result = customArrayService.sortSelection(fileName, ValidationMode.STRICT);
        int[] expected = {2, 3, 77};
        Assertions.assertArrayEquals(expected, result, "Selection sort result does not match the expected sorted array.");
    }
}