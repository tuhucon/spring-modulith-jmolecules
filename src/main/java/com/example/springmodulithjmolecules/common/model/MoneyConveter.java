package com.example.springmodulithjmolecules.common.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class MoneyConveter implements AttributeConverter<Money, Double> {

    @Override
    public Double convertToDatabaseColumn(Money attribute) {
        return attribute.value();
    }

    @Override
    public Money convertToEntityAttribute(Double dbData) {
        return new Money(dbData);
    }
}
