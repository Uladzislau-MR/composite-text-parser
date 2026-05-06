package com.radkevich.infohandler.entity;



public enum ComponentType {
    TEXT(""),
    PARAGRAPH("(?m)(?=^\\s{4})"),

    SENTENCE("(?<=[.!?])\\s+"),


    LEXEME("\\s+"),


    WORD("(?=[,.!?;:])|(?<=[,.!?;:])"),

    SYMBOL("");

    private final String delimiter;

    ComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}