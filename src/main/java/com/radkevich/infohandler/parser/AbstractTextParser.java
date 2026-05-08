package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.exception.ParsingException;

public abstract class AbstractTextParser implements TextParser {

    protected TextParser nextParser;


    protected AbstractTextParser() {
    }


    protected AbstractTextParser(TextParser nextParser) {
        this.nextParser = nextParser;
    }


    protected TextComponent delegateParse(String data) throws ParsingException {
        if (nextParser != null) {
            return nextParser.parse(data);
        }

        return null;
    }
}