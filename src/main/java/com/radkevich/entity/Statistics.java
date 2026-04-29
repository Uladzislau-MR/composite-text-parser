package com.radkevich.entity;

public class Statistics {
    private double sum;
    private double average;
    private int max;
    private int min;

    public Statistics(int min,int max, double sum, double average) {
        this.sum = sum;
        this.average = average;
        this.max = max;
        this.min = min;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
