package com.company.stream.summer;

@FunctionalInterface
public interface Summer<T extends Number> {

    T compute(final T number1, final T number2);
}
