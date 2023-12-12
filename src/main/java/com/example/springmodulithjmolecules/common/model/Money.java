package com.example.springmodulithjmolecules.common.model;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Money (double value) {

    public Money add(Money y) {
        return new Money(this.value + y.value);
    }

    public Money subtract(Money y) {
        return new Money(this.value - y.value);
    }

    public Money multiple(Money y) {
        return new Money(this.value * y.value);
    }

    public Money device(Money y) {
        return new Money(this.value / y.value);
    }
}
