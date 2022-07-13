package modern_java;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class DemoMJ {

    private static String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        // immutable/ Java 17
        final var list1 = Stream.of(1, 2, 3, 4, 5, 6, -9)
            .filter(n -> n > 0)
            .toList();

        final var multiMap = Stream.of("One", "Two", "Three")
            .mapMulti((e, c) -> {
                c.accept(e.toLowerCase(Locale.ROOT));
                c.accept((e.toUpperCase(Locale.ROOT)));
            })
            .toList();

        System.out.println(multiMap);

        final var sql = """
            SELECT u.name FROM cars c
                JOIN users u ON u.id = c.owner_id
            WHERE c.id = :carID
            """;

        System.out.println(sql);

        final Object hello = "i";

        if (hello instanceof String s) {
            System.out.println(s.toUpperCase(Locale.ROOT));
        }

        char letter = abc.charAt(ThreadLocalRandom.current().nextInt(abc.length()));
        Object charString = switch (letter) {
            case 'A' -> "1";
            case 'B' -> "2";

            default -> "0";
        };

//        var res = switch (charString) {
//            case null -> 0;
//            case String s1 -> Integer.parseInt(s1);
//            case Integer a1 && a1 > 2000 -> {
//              yield 1000;
//            }
//            default -> -1;
//        };
//
//        System.out.println(res);

    }
}

