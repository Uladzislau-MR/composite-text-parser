package com.radkevich.service.impl;

import com.radkevich.exeption.ReadingException;
import com.radkevich.factory.CustomArrayFactory;
import com.radkevich.factory.impl.CustomArrayFactoryImpl;
import com.radkevich.service.CustomArrayService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayServiceImpl implements CustomArrayService {

    private static final Logger logger = LogManager.getLogger(CustomArrayServiceImpl.class);
    private final CustomArrayFactory factory = new CustomArrayFactoryImpl();



    @Override
    public OptionalInt findMin(String fileName) {
        try {
            int[] elements = factory.create(fileName).getElements();
            return Arrays.stream(elements).min();
        } catch (ReadingException e) {
            logger.error("Error in findMin ({}): {}", fileName, e.getMessage());
            return OptionalInt.empty();
        }
    }

    @Override
    public OptionalInt findMax(String fileName) {
        try {
            int[] elements = factory.create(fileName).getElements();
            return Arrays.stream(elements).max();
        } catch (ReadingException e) {
            logger.error("Error in findMax ({}): {}", fileName, e.getMessage());
            return OptionalInt.empty();
        }
    }

    @Override
    public int findSum(String fileName) {
        try {
            int[] elements = factory.create(fileName).getElements();
            return Arrays.stream(elements).sum();
        } catch (ReadingException e) {
            logger.error("Error in findSum ({}): {}", fileName, e.getMessage());
            return 0;
        }
    }

    @Override
    public OptionalDouble findAverage(String fileName) {
        try {
            int[] elements =factory.create(fileName).getElements();
            return Arrays.stream(elements).average();
        } catch (ReadingException e) {
            logger.error("Error in findAverage ({}): {}", fileName, e.getMessage());
            return OptionalDouble.empty();
        }
    }

    @Override
    public int[] sortBubble(String fileName) {
        try {
            int[] array = factory.create(fileName).getElements();
            int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
            return array;
        } catch (ReadingException e) {
            logger.error("Error in sortBubble ({}): {}", fileName, e.getMessage());
            return new int[0];
        }
    }

    @Override
    public int[] sortSelection(String fileName) {
        try {
            int[] array = factory.create(fileName).getElements();
            int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    if (array[j] < array[minIdx]) {
                        minIdx = j;
                    }
                }
                int temp = array[minIdx];
                array[minIdx] = array[i];
                array[i] = temp;
            }
            return array;
        } catch (ReadingException e) {
            logger.error("Error in sortSelection ({}): {}", fileName, e.getMessage());
            return new int[0];
        }
    }
}