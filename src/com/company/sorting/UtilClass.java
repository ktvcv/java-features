package com.company.sorting;

import java.util.List;

public class UtilClass {
    // best case - O(n)
    // for already sorted and partly sorted
    // can sort expanding arrays
    public List<Integer> insertionSort(final List<Integer> list) {
        final int size = list.size();
        for (int i = 1; i < size; i++) {
            final int current = list.get(i);
            int j = i - 1;

            while (j >= 0 && current < list.get(j)) {
                // move right
                list.set(j + 1, list.get(j));
                j--;
            }
            // move current to maximum left position(min)
            list.set(j + 1, current);
        }

        return list;
    }
}
