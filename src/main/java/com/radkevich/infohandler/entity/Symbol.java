package com.radkevich.infohandler.entity;

import java.util.Collections;
import java.util.List;


public class Symbol implements TextComponent {
    private final char value;
    private final ComponentType type = ComponentType.SYMBOL;

    public Symbol(char value) {
        this.value = value;
    }

    @Override
    public boolean add(TextComponent component) {
        return false;
    }

    @Override
    public boolean remove(TextComponent component) {
        return false;
    }

    @Override
    public List<TextComponent> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

