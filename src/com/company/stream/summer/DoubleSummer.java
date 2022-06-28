package com.company.stream.summer;

import java.math.BigDecimal;

public class DoubleSummer implements Summer<Double>{
    @Override
    public Double compute(final Double number1, final Double number2) {
        return BigDecimal.valueOf(number1).add(BigDecimal.valueOf(number2)).doubleValue();
    }
}
