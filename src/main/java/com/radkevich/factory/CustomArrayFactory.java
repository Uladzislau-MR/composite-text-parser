package com.radkevich.factory;

import com.radkevich.entity.CustomArray;
import com.radkevich.exeption.ReadingException;

public interface CustomArrayFactory {

    CustomArray create (int[] numbers) throws ReadingException;



}
