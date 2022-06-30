package com.company.jenerics;

public class Container<MIN extends Number, MAX extends Number> {

    final MIN minValue;
    final MAX maxValue;

    public Container(final MIN minValue, final MAX maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
