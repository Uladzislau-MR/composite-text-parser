package com.radkevich.factory.impl;

import com.radkevich.entity.CustomArray;
import com.radkevich.exeption.ReadingException;
import com.radkevich.factory.CustomArrayFactory;
import com.radkevich.parser.impl.CustomParserImpl;
import com.radkevich.reader.CustomArrayReader;
import com.radkevich.reader.impl.CustomArrayReaderImpl;


public class CustomArrayFactoryImpl implements CustomArrayFactory {


    @Override
    public CustomArray create(int[] numbers) throws ReadingException {
           return new CustomArray(numbers);
    }
}

