package com.radkevich.entity;

public class CustomArrayEvent {

    private CustomArray source;

    public CustomArrayEvent(CustomArray source) {
        this.source = source;
    }

    public CustomArray getSource() {
        return source;
    }

    public void setSource(CustomArray source) {
        this.source = source;
    }
}
