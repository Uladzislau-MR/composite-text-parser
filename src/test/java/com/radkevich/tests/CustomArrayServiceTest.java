package com.radkevich.tests;

import com.radkevich.factory.CustomArrayFactory;
import com.radkevich.factory.impl.CustomArrayFactoryImpl;
import com.radkevich.parser.CustomParser;
import com.radkevich.parser.impl.CustomParserImpl;
import com.radkevich.reader.CustomArrayReader;
import com.radkevich.reader.impl.CustomArrayReaderImpl;
import com.radkevich.service.CustomArrayService;
import com.radkevich.service.impl.CustomArrayServiceImpl;
import com.radkevich.validator.CustomArrayValidator;
import com.radkevich.validator.impl.CustomArrayValidatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayServiceTest {
    CustomArrayService customArrayService;
    String fileName = "Data.txt";

    @BeforeEach
    public void setup() {
        CustomArrayReader reader = new CustomArrayReaderImpl();
        CustomArrayValidator validator = new CustomArrayValidatorImpl();
        CustomParser parser = new CustomParserImpl(validator);
        CustomArrayFactory factory = new CustomArrayFactoryImpl();

        customArrayService = new CustomArrayServiceImpl(reader, parser, factory);
    }
    @Test
    public void sum() {
        int sum = customArrayService.findSum(fileName);
        Assertions.assertEquals(141, sum, "The calculated sum does not match the expected value.");
    }

    @Test
    public void min() {
        OptionalInt min = customArrayService.findMin(fileName);
        Assertions.assertTrue(min.isPresent(), "Minimum value should be present.");
        Assertions.assertEquals(1, min.getAsInt(), "The minimum value does not match the expected one.");
    }

    @Test
    public void max() {
        OptionalInt max = customArrayService.findMax(fileName);
        Assertions.assertTrue(max.isPresent(), "Maximum value should be present.");
        Assertions.assertEquals(77, max.getAsInt(), "The maximum value does not match the expected one.");
    }

    @Test
    public void average() {
        OptionalDouble avg = customArrayService.findAverage(fileName);
        Assertions.assertTrue(avg.isPresent(), "Average value should be present.");
        Assertions.assertEquals(15.66, avg.getAsDouble(), 0.01, "The average value does not match the expected one.");
    }

    @Test
    public void sortBubble() {
        int[] result = customArrayService.sortBubble(fileName);
        int[] expected = {1, 1, 2, 2, 2, 3, 11, 42, 77};

        Assertions.assertArrayEquals(expected, result, "Bubble sort result does not match the expected sorted array.");
    }

    @Test
    public void sortSelection() {
        int[] result = customArrayService.sortSelection(fileName);
        int[] expected = {1, 1, 2, 2, 2, 3, 11, 42, 77};


        Assertions.assertArrayEquals(expected, result, "Selection sort result does not match the expected sorted array.");
    }
}