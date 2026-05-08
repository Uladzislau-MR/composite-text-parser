package com.radkevich.infohandler.exception;

import com.radkevich.infohandler.entity.ComponentType;

public class ParsingException extends Exception{


    private ComponentType componentType;


    public ParsingException (String message) {
        super(message);
    }


    public ParsingException(String message, ComponentType componentType) {
        super(message);
        this.componentType = componentType;

    }

}