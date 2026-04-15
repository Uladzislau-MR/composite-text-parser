package com.radkevich.factory.impl;

import com.radkevich.entity.CustomArray;
import com.radkevich.exeption.ReadingException;
import com.radkevich.factory.CustomArrayFactory;
import com.radkevich.parser.impl.CustomParserImpl;
import com.radkevich.reader.CustomArrayReader;
import com.radkevich.reader.impl.CustomArrayReaderImpl;


public class CustomArrayFactoryImpl implements CustomArrayFactory {

    private CustomArrayReader customArrayReader = new CustomArrayReaderImpl();
    private CustomParserImpl customParser = new CustomParserImpl();


    @Override
    public CustomArray create(String fileName) throws ReadingException {
        String str = customArrayReader.readAllData(fileName);

        return new CustomArray(customParser.parseInt(str));
    }
}

