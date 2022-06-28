package com.company.stream.sample2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamMethods {

    public static void main(String[] args) {

/*        Optional.of(1)
            .map(x -> {
                throw new RuntimeException();
            });*/

        Stream.of(1)
            .map(x -> {
                throw new RuntimeException();
            });

        final List<Double> values =
            Stream
                .generate(new Random()::nextDouble)
                .limit(10)
                .map(value -> BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue())
                .collect(toList());

        System.out.println(values);

        final Optional<Double> maxValue = values
            .stream()
            .filter(value -> value > 0.9)
            .findFirst();

        maxValue.ifPresentOrElse(
            value -> System.out.println("Value is present"),
            () -> System.out.println("value is empty"));


    }
}
