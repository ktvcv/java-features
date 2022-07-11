package fork_join;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortTask extends RecursiveAction {

    private final int[] arr;
    private final int anInt;

    public MergeSortTask(final int[] arr) {
        this.arr = arr;
        this.anInt = arr.length;
    }

    @Override
    protected void compute() {
        if (arr.length == 1){
            return;
        }
        final var left = Arrays.copyOfRange(arr, 0, anInt / 2);
        final var right = Arrays.copyOfRange(arr, anInt / 2, anInt);

        final var leftSortTask = new MergeSortTask(left);
        final var rightSortTask = new MergeSortTask(right);

        leftSortTask.fork();
        rightSortTask.compute();

        leftSortTask.join();

        merge(arr, left, right);

    }

    private void merge(final int[] arr, final int[] left, final int[] right) {
        var i = 0;
        var j = 0;

        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                arr[i + j] = left[i++];
            } else {
                arr[i + j] = right[j++];
            }
        }
        System.arraycopy(left, i, arr, i + j, left.length - i);
        System.arraycopy(right, j, arr, i + j, right.length - j);
    }
}
