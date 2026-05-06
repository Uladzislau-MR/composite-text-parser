package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.Symbol;
import com.radkevich.infohandler.entity.TextComponent;

public class SymbolParser extends AbstractTextParser {


    public SymbolParser() {
        super(null);
    }

    @Override
    public TextComponent parse(String data) {

        if (data.length() > 0) {
            return new Symbol(data.charAt(0));
        }
        return null;
    }
}