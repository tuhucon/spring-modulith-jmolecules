package com.example.springmodulithjmolecules.product.appcore.domain.model;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.common.model.MoneyConveter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.event.annotation.DomainEventPublisher;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.modulith.NamedInterface;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@AggregateRoot
@NamedInterface
public class Product extends AbstractAggregateRoot<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    @Convert(converter = MoneyConveter.class)
    @Setter(AccessLevel.NONE)
    Money price;

    @DomainEventPublisher
    public void updatePrice(Money newPrice) {
        price = newPrice;
        registerEvent(new ProductPriceUpdatedEvent(this));
    }
}
