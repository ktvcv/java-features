package com.company.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

public class DemoAppInterface {

    @SneakyThrows
    public static void main(String[] args) {
        final var randomizerInterface = Class.forName("com.company.reflection.RandomizerInterface");
        final var classLoader = randomizerInterface.getClassLoader();

        final var interfacesToImplement = new Class<?>[]{randomizerInterface};
        final InvocationHandler invocationHandler = (proxy, method, args1) -> {
            if (method.getName().equals("randomize")) {
                var list = (List<?>) args1[0];
                var index = ThreadLocalRandom.current().nextInt(list.size());

                return list.get(index);
            } else {
                throw new UnsupportedOperationException();
            }
        };

        final var randomizerInstance = Proxy.newProxyInstance(classLoader, interfacesToImplement, invocationHandler);
        final var randomizedMethod = randomizerInstance.getClass().getMethod("randomize", List.class);

        final var result = randomizedMethod.invoke(randomizerInstance, asList(2, 7, 8, 9, 45, 3, 1, 23));

        System.out.println(result);
    }

}
