package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.exeption.ParsingException;

public interface TextParser  {
    TextComponent parse(String data)  throws ParsingException;
}
