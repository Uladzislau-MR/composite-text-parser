package com.radkevich.reader;

import com.radkevich.exeption.ReadingException;

import java.util.List;

public interface CustomArrayReader {
    List<String> readAllLines(String fileName) throws ReadingException;
}
