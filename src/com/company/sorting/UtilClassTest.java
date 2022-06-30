package com.company.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

class UtilClassTest {

    @Test
    void insertionSort() {
        final UtilClass utilClass = new UtilClass();

        final List<Integer> list = asList(5, 9, 0, 6, 12, 3);

        final List<Integer> sortedList = utilClass.insertionSort(list);
        final Integer[] expected = {0, 3, 5, 6, 9, 12};

        Assertions.assertArrayEquals(expected, sortedList.toArray(new Integer[0]));
    }
}