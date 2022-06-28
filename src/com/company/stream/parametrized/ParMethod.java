package com.company.stream.parametrized;

import java.util.List;

import static java.util.Arrays.asList;

public class ParMethod {

    public static void main(String[] args) {
        final List<Integer> list = asList(1, 2, 3, 4, 5);

        System.out.println(reverse(list));
    }

    private static <T> List<T> reverse(final List<T> list) {
        final int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            final T temp = list.get(i);
            list.set(i, list.get(size - i - 1));
            list.set(size - i - 1, temp);
        }

        return list;
    }
}
