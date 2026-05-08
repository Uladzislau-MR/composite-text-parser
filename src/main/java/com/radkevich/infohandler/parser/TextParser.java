package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.exception.ParsingException;

public interface TextParser  {
    String PARAGRAPH_SPLIT = "(?m)(?=^\\s{4})";
    String SENTENCE_SPLIT = "(?<=[.!?])\\s+";
    String LEXEME_SPLIT = "[ \t]+";;
    String WORD_SPLIT = "(?=[,.!?;:])|(?<=[,.!?;:])";

    TextComponent parse(String data)  throws ParsingException;
}
