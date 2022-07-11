package com.company.jenerics;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class User extends Entity {

    private String name;
    final static Predicate<Entity> predicate = entity -> entity.getId() != null;

    public static void main(String[] args) {
        UtilCass.isValid(new User(), predicate);

        final Integer[] array = {1, 2, 3, 4};
        //covariant
        final Number[] numberArray = array;

        call(Collections.emptyList(), List.of("s"));

    }

    @SafeVarargs
    static void call(final List<String>... args){
       final Object[] args1 = args;
        final String s =  args[0].get(0);
    }
}
