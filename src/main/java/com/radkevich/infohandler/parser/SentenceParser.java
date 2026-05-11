package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.ComponentType;
import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.entity.TextComposite;
import com.radkevich.infohandler.exception.ParsingException;

public class SentenceParser extends AbstractTextParser {


    public SentenceParser(TextParser nextParser) {
       super(nextParser);
    }


    @Override
    public TextComponent parse(String data) throws ParsingException {

        TextComponent sentence = new TextComposite(ComponentType.SENTENCE);


        String[] lexemes = data.strip().split(LEXEME_SPLIT);

        for (String lexemeData : lexemes) {

            sentence.add(delegateParse(lexemeData));
        }

        return sentence;
    }
}

