package com.radkevich.infohandler.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private final List<TextComponent> components = new ArrayList<>();
    private final ComponentType type;

    public TextComposite(ComponentType type) {
        this.type = type;
    }

    @Override
    public boolean add(TextComponent component) {
        return components.add(component);
    }

    @Override
    public boolean remove(TextComponent component) {
        return components.remove(component);
    }

    @Override
    public List<TextComponent> getChildren() {
        return new ArrayList<>(components);
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();


        if (type == ComponentType.PARAGRAPH) {
            sb.append("\n    ");
        }

        for (int i = 0; i < components.size(); i++) {
            sb.append(components.get(i).toString());


            if (type == ComponentType.SENTENCE) {

                if (i < components.size() - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
