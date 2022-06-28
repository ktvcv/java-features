package com.company.stream.apple;

import lombok.Data;

import java.util.Collection;
import java.util.function.Predicate;

import static com.company.stream.apple.Apple.Color.GREEN;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

@Data
public class Apple {

    private static Predicate<Apple> predicate = apple -> GREEN == apple.getColor();

    private static Collection<Apple> filterApples(
        final Collection<Apple> apples, final Predicate<Apple> predicate
    ) {
        return apples.stream().filter(predicate).collect(toList());
    }

    private final Color color;

    public Apple(final Color color) {
        this.color = color;
    }

    enum Color {
        RED, GREEN;
    }

    public static void main(String[] args) {
        final Collection<Apple> apples = asList(
            new Apple(GREEN), new Apple(Color.RED)
        );

        System.out.println(filterApples(apples, predicate));
    }
}
