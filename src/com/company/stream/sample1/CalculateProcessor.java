package com.company.stream.sample1;

@FunctionalInterface
public interface CalculateProcessor<T extends Number> {

    T calculate(final T numberA, final T numberB);
}
