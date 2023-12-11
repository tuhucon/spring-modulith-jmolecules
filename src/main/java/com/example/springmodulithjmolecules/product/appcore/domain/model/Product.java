package com.example.springmodulithjmolecules.product.appcore.domain.model;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.common.model.MoneyConveter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@NoArgsConstructor
public class Product extends AbstractAggregateRoot<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    @Convert(converter = MoneyConveter.class)
    Money price;
}
