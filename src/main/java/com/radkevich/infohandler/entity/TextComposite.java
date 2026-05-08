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

        if (this.type == ComponentType.PARAGRAPH) {
            sb.append("    ");
        }

        for (int i = 0; i < components.size(); i++) {
            String content = components.get(i).toString();
            if (i == 0 && this.type == ComponentType.PARAGRAPH) {
                content = content.stripLeading();
            }
            sb.append(content);

            if (i < components.size() - 1) {

                if (this.type == ComponentType.TEXT) {
                    sb.append("\n");
                } else {
                    sb.append(type.getDelimiter());
                }
            }
        }
        return sb.toString();
    }
}
