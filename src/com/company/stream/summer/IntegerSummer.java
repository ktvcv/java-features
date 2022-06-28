package com.company.stream.summer;

public class IntegerSummer implements Summer<Integer>{

    @Override
    public Integer compute(final Integer number1, final Integer number2) {
        return number1 + number2;
    }
}
