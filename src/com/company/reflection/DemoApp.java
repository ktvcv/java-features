package com.company.reflection;

public class DemoApp {

    public static void main(String[] args) {
        final var methods = Randomizer.class.getDeclaredMethods();

        final var randomizedMethod = methods[0];

        final var params = randomizedMethod.getParameters();
    }
}
