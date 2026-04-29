package com.radkevich.entity;


import com.radkevich.obsrver.CustomArrayObserver;

import java.util.ArrayList;
import java.util.List;

public class CustomArray {
    private long id;
    private int[] elements;
    private List<CustomArrayObserver> observers = new ArrayList<>();

    public CustomArray(long id, int... elements) {
        this.id = id;
        this.elements = elements;
    }

    public void setElements(int[] elements) {
        this.elements = elements;
        notifyObservers();
    }

    public void setElement(int index, int value) {
        this.elements[index] = value;
        notifyObservers();
    }

    public void attach(CustomArrayObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void detach(CustomArrayObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        CustomArrayEvent event = new CustomArrayEvent(this);
        for (CustomArrayObserver observer : observers) {
            observer.update(event);
        }
    }

    public long getId() {
        return id;
    }

    public int[] getElements() {
        return elements.clone();
    }
}