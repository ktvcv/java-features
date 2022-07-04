package proxy;

import com.company.reflection.Randomizer;

import java.util.List;

public class RandomizerProxy extends Randomizer {

    @Override
    public <T> T randomize(final List<T> list) {
        System.out.println("Proxy");
        return super.randomize(list);
    }
}
