package com.company.stream.area;

import lombok.extern.java.Log;

import java.util.function.Function;

import static java.lang.String.format;

@Log
public class Main {

    public static void main(String[] args) {

        final TrianglePerimeter area = new TrianglePerimeter(10);

        double o = area.calculate(() -> area.getSide() * 3);

        log.info(format("Area: %f", o));

        final Function<String, Integer> function = Integer::parseInt;

        final Integer intParsed = function.apply("456");

        log.info(format("Parsed string: %d", intParsed));

    }
}
