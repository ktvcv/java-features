package modern_java;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CF {

    @SneakyThrows
    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> System.out.println("from: " + Thread.currentThread().getName()))
            .join();

        final var value = CompletableFuture.supplyAsync(CF::getCalculatedValue);
        final var anotherValue = CompletableFuture.supplyAsync(CF::getCalculatedValue);

        final var res = Stream.of(value, anotherValue)
            .map(CompletableFuture::join)
            .reduce(0, Integer::sum);
        System.out.println(res);

        var cf = CompletableFuture.supplyAsync(CF::getCalculatedValue)
            .thenApply(i -> i*1.09)
            .thenAccept(System.out::println);

        cf.join();

    }

    @SneakyThrows
    private static int getCalculatedValue() {
        TimeUnit.SECONDS.sleep(5);

        return ThreadLocalRandom.current().nextInt(100);
    }
}
