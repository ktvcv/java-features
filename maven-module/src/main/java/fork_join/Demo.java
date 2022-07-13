package fork_join;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Demo {

    public static void main(String[] args) {
        int[] arr = {7, 0, 4, 23, 5, 6, 16, 27, 2, 19};
        System.out.println(Arrays.toString(arr));
        final var cores = Runtime.getRuntime().availableProcessors() - 1;
        final var forkJoinPool = new ForkJoinPool(cores);
        // 8 - 1 = 7 cores
        System.out.println(forkJoinPool.getParallelism());
        ForkJoinPool.commonPool().invoke(new MergeSortTask(arr));

        System.out.println(Arrays.toString(arr));

    }
}
