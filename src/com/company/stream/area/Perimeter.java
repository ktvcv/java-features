package com.company.stream.area;

import java.util.function.Supplier;

@FunctionalInterface
public interface Perimeter {
     double calculate(final Supplier<Double> method);
}
