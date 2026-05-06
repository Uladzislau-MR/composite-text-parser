package com.radkevich.infohandler.reader;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CustomReaderImpl implements CustomReader {


    public String readAllData(String fileName) {
        try {
            URL resource = getClass().getClassLoader().getResource(fileName);
            Path path = Paths.get(resource.toURI());
            return Files.readString(path);
        } catch (IOException | URISyntaxException e) {

            throw new RuntimeException("Failed to read file: " + fileName, e);
        }
    }


}



