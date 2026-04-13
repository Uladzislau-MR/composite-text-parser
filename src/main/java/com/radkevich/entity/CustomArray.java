package com.radkevich.entity;

import java.util.Arrays;

public class CustomArray {

        private int[] elements;

        public CustomArray(int[] elements) {
            this.elements = elements;
        }

        public int[] getElements() {
            return elements;
        }

        public void setElements(int[] elements) {
            this.elements = elements;
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
        return Arrays.hashCode(elements);
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



