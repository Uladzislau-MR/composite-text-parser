package com.radkevich.entity;


public class CustomArray {

    private int[] elements;

    public CustomArray(int[] elements) {
        this.elements = elements;
    }

    public int[] getElements() {
        return elements.clone();
    }

    public void setElements(int[] elements) {

        if (elements == null) {
            this.elements = new int[0];
        } else {
            this.elements = elements.clone();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;

        if (this.elements.length != that.elements.length) {
            return false;
        }

        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i] != that.elements[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (elements == null) {
            return 0;
        }
        int result = 1;
        for (int element : elements) {
            result = 31 * result + element;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomArray{elements=[");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]}").toString();
    }
}



