package com.company.reflection;

import lombok.SneakyThrows;

import java.util.List;

import static java.util.Arrays.asList;

public class DemoApp {

    @SneakyThrows
    public static void main(String[] args) {
        final var randomizerClassLoad = Class.forName("com.company.reflection.Randomizer");

        final var randomizerClass = Randomizer.class;
        final var methods = randomizerClass.getDeclaredMethods();

        final var randomizedMethod = methods[0];

        final var params = randomizedMethod.getParameters();

        final var randomizedConstructor = randomizerClass.getConstructor();
        final var randomizer = randomizedConstructor.newInstance();
        final var list = asList(1, 2, 3, 4);
        randomizer.randomize(list);

        var result = randomizedMethod.invoke(randomizer, list);

    }
}
