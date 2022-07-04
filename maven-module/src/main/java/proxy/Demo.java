package proxy;

import com.company.reflection.Randomizer;

import static java.util.Arrays.asList;

public class Demo {

    public static void main(String[] args) {
        final Randomizer randomizer = new RandomizerProxy();
        final Integer result = randomizer.randomize(asList(1, 5, 6, 7, 8, 9));

        System.out.println(result);

    }
}
