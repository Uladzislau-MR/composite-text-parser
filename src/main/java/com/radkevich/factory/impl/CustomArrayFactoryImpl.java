package com.radkevich.factory.impl;

import com.radkevich.entity.CustomArray;
import com.radkevich.exeption.ReadingException;
import com.radkevich.factory.CustomArrayFactory;

import java.util.ArrayList;
import java.util.List;


public class CustomArrayFactoryImpl implements CustomArrayFactory {
    private static long idCounter = 0;

    public List<CustomArray> createArraysList(List<int[]> numbersList) throws ReadingException {
        List<CustomArray> result = new ArrayList<>();

        for (int[] numbers : numbersList) {
            result.add(create(numbers));
        }

        return result;
    }





    @Override
    public CustomArray create(int[] numbers) throws ReadingException {
        long id = ++idCounter;
           return new CustomArray(id,numbers);
    }
}

