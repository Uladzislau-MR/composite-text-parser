package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.ComponentType;
import com.radkevich.infohandler.entity.Symbol;
import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.entity.TextComposite;
import com.radkevich.infohandler.exception.ParsingException;

public class LexemeParser extends AbstractTextParser {

    public LexemeParser(TextParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String data) throws ParsingException {
        TextComponent lexeme = new TextComposite(ComponentType.LEXEME);
        String[] arr = data.split(ComponentType.WORD.getDelimiter());

        for (String res : arr) {
            if (res.isBlank()) continue;

            if (res.matches(WORD_SPLIT)) {
                TextComponent word = delegateParse(res);
                lexeme.add(word);
            } else {

                for (char c : res.toCharArray()) {
                    lexeme.add(new Symbol(c));
                }
            }
        }
        return lexeme;
    }
}
