package com.radkevich.reader.impl;

import com.radkevich.exeption.ReadingException;
import com.radkevich.reader.CustomArrayReader;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CustomArrayReaderImpl implements CustomArrayReader {


    @Override
    public String readAllData(String fileName) throws ReadingException {
        try {
            URL resource = getClass().getClassLoader().getResource(fileName);

            if (resource == null) {
                throw new ReadingException("Resource file not found: " + fileName);
            }

            Path path = Paths.get(resource.toURI());
            return Files.readString(path);

        } catch (Exception e) {
            throw new ReadingException("Error occurred while reading file: " + fileName, e);
        }
    }


}



