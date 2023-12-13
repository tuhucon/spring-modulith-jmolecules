package com.example.springmodulithjmolecules.product.appcore.domain.model;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.common.model.MoneyConveter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@AggregateRoot
public class Product extends AbstractAggregateRoot<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Identity
    Long id;

    @Setter
    String name;

    @Setter
    String description;

    @Convert(converter = MoneyConveter.class)
    Money price;

    public void updatePrice(Money newPrice) {
        price = newPrice;
        registerEvent(new ProductPriceUpdatedEvent(this));
    }
}
