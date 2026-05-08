package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.ComponentType;
import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.entity.TextComposite;
import com.radkevich.infohandler.exception.ParsingException;

public class TextParserImp extends AbstractTextParser {

    public TextParserImp(TextParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String data) throws ParsingException {
        TextComponent component = new TextComposite(ComponentType.TEXT);
        if (data == null||data.isBlank()) {
            throw new ParsingException("Data is missing or empty", component.getType());
        }

         String [] arr =  data.split(PARAGRAPH_SPLIT);
        for (String result:arr) {
            component.add(delegateParse(result)) ;
        }
        return component;
    }
}
