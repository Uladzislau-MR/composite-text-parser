package com.radkevich.exeption;

public class ReadingException extends Exception{

    public ReadingException(String message) {
        super(message);
    }
    public ReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
