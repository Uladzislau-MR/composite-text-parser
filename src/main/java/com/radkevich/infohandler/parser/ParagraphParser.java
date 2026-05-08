package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.ComponentType;
import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.entity.TextComposite;
import com.radkevich.infohandler.exception.ParsingException;

public class ParagraphParser extends AbstractTextParser {


    public ParagraphParser(TextParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String data) throws ParsingException {
        TextComponent component = new TextComposite(ComponentType.PARAGRAPH);


        String[] arr = data.split(SENTENCE_SPLIT);
        for (String res: arr) {
            component.add(delegateParse(res));
        }
        return component;
    }
}
