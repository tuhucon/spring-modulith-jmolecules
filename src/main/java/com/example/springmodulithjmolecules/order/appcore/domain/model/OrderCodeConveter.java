package com.example.springmodulithjmolecules.order.appcore.domain.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class OrderCodeConveter implements AttributeConverter<OrderCode, String> {

    @Override
    public String convertToDatabaseColumn(OrderCode attribute) {
        return attribute.uuid();
    }

    @Override
    public OrderCode convertToEntityAttribute(String dbData) {
        return new OrderCode(dbData);
    }
}
