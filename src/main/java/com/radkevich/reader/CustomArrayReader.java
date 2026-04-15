package com.radkevich.reader;

import com.radkevich.exeption.ReadingException;


public interface CustomArrayReader {
    String readAllData(String fileName) throws ReadingException;
}
