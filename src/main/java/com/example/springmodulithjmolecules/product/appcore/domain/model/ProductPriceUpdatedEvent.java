package com.example.springmodulithjmolecules.product.appcore.domain.model;

import com.example.springmodulithjmolecules.common.EventBase;
import com.example.springmodulithjmolecules.common.model.Money;
import lombok.Getter;
import org.jmolecules.event.annotation.DomainEvent;
import org.springframework.modulith.NamedInterface;

@DomainEvent
@NamedInterface
public class ProductPriceUpdatedEvent extends EventBase {

    @Getter
    Long productId;

    @Getter
    Money price;

    public ProductPriceUpdatedEvent(Object source) {
        super(source);
        Product p = (Product) source;
        productId = p.getId();
        price = p.getPrice();
    }
}
