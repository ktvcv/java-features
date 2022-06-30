package com.company.jenerics;

import java.util.Collection;
import java.util.function.Predicate;

public class UtilCass {

    public static <T> T findMin(final Collection<T> collection) {
        return collection
            .stream()
            .sorted()
            .findFirst()
            .orElse(null);
    }

    public static void printAll(final Collection<?> collection){
        collection.forEach(System.out::println);
    }

    public static boolean isValid(final User entity, final Predicate<? super User> predicate){
        return predicate.test(entity);
    }
}
