package com.company.anotation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        final var annotations = MarkerClass.class.getAnnotations();

        Arrays.stream(annotations)
            .filter(annotation -> annotation.annotationType().equals(Marker.class))
            .forEach(marker -> System.out.println("Marked"));

        final var javaAnnotation = MarkerClass.class.getAnnotation(Marker.class);
        System.out.println(javaAnnotation.value());

    }
}
