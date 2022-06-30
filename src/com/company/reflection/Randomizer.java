package com.company.reflection;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public <T> T randomize(final List<T> list){
        final var index = ThreadLocalRandom.current().nextInt(list.size());

        return list.get(index);
    }
}
