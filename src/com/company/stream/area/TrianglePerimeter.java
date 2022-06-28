package com.company.stream.area;

import lombok.Data;

import java.util.function.Supplier;

@Data
public class TrianglePerimeter implements Perimeter {

    public TrianglePerimeter(final int side) {
        this.side = side;
    }

    private double side;

    @Override
    public double calculate(final Supplier<Double> method) {
        return method.get();
    }
}
