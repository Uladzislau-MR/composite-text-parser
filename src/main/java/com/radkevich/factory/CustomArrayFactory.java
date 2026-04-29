package com.radkevich.factory;

import com.radkevich.entity.CustomArray;
import com.radkevich.exeption.ReadingException;

import java.util.List;

public interface CustomArrayFactory {

    CustomArray create (int[] numbers) throws ReadingException;
    List<CustomArray> createArraysList(List<int[]> numbersList) throws ReadingException;


}
