package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.ComponentType;
import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.entity.TextComposite;
import com.radkevich.infohandler.exception.ParsingException;

public class WordParser extends AbstractTextParser {



    public WordParser(TextParser nextParser) {
        super(nextParser);

    }

    @Override
    public TextComponent parse(String data) throws ParsingException {
        TextComponent component = new TextComposite(ComponentType.WORD);
        char[] chars = data.toCharArray();

        for (char c : chars) {
            String symbolStr = String.valueOf(c);
            component.add(delegateParse(symbolStr));
        }
return component;
    }
}
