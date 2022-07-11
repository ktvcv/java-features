package lambda;

import com.company.jenerics.User;
import jdk.jfr.DataAmount;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Demo {

    public static void main(String[] args) {
        // high level function
        final Consumer<String> consumer = s -> System.out.println(s);

        final String string = "string";
        consumer.accept(string);

        final var methods = consumer.getClass().getDeclaredMethods();

        System.out.println(Arrays.toString(methods));

        final Supplier<String> supplier = string::toUpperCase;
        final IntUnaryOperator intUnaryOperator = ThreadLocalRandom.current()::nextInt;
        intUnaryOperator.applyAsInt(10);

        final UnaryOperator<String> unaryOperator = String::toLowerCase;
        final Function<Integer, String> stringFunction = string::substring;

        final BiFunction<String, Integer, String> biFunction = String::substring;
        final var str = biFunction.apply(string, 1);

        final Function<Function<String, Integer>, Predicate<String>> predicateFunction =
            strToInt -> str1 -> strToInt.apply(str1) > 0;

        System.out.println(predicateFunction.apply(Integer::parseInt));

        final IntUnaryOperator square = x -> x * x;
        final IntUnaryOperator increment = x -> x + 1;

        final var res = square.compose(increment);

        System.out.println(res.applyAsInt(30));

        final var filteredList = Stream.generate(() -> ThreadLocalRandom.current().nextInt())
            .limit(20)
            .collect(filtering(number -> number > 100, toList()));


        final var users = asList(new User().setId(2), new User().setId(3));

        final var group =  users
            .stream()
            .collect(groupingBy(User::getId, mapping(User::getName, toSet())));

        Consumer j = System.out::println;

    }


    static class User {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public User setId(final int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public User setName(final String name) {
            this.name = name;
            return this;
        }
    }
}
