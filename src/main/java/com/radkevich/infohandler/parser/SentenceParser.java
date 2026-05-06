package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.ComponentType;
import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.entity.TextComposite;
import com.radkevich.infohandler.exeption.ParsingException;

public class SentenceParser extends AbstractTextParser {


    public SentenceParser(TextParser nextParser) {
       super(nextParser);
    }
//
//    @Override
//    public TextComponent parse(String data) throws ParsingException {
//        TextComponent component = new TextComposite(ComponentType.SENTENCE);
//        String [] text = data.split(ComponentType.SENTENCE.getDelimiter());
//        for (String res: text ){
//            component.add(delegateParse(res));
//        }
//        return component;
//    }

    @Override
    public TextComponent parse(String data) throws ParsingException {
        // Создаем контейнер для предложения
        TextComponent sentence = new TextComposite(ComponentType.SENTENCE);

        // ВНИМАНИЕ: Здесь мы НЕ сплитим данные, потому что ParagraphParser
        // уже передал нам строку, которая является ОДНИМ предложением.
        // Мы режем это предложение на ЛЕКСЕМЫ по пробелу.
        String[] lexemes = data.trim().split(ComponentType.LEXEME.getDelimiter());

        for (String lexemeData : lexemes) {
            // Передаем каждую лексему в LexemeParser
            sentence.add(delegateParse(lexemeData));
        }

        return sentence;
    }
}

