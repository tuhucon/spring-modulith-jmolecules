package com.example.springmodulithjmolecules.order.appcore.domain.model;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.common.model.MoneyConveter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Identity;

@Entity
@org.jmolecules.ddd.annotation.Entity
@EqualsAndHashCode(of = "id")
@Getter
public class OrderItem {

    protected OrderItem() {

    }

    OrderItem(Long productId, Integer quality, Money price, Money discount) {
        this.productId = productId;
        this.quality = quality;
        this.price = price;
        this.discount = discount;
        this.originalAmount = new Money(quality * price.value());
        this.totalAmount = originalAmount.subtract(discount);
    }

    @Id
    @Identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Order order;

    Long productId;

    Integer quality;

    @Convert(converter = MoneyConveter.class)
    Money price;

    @Convert(converter = MoneyConveter.class)
    Money discount;

    @Convert(converter = MoneyConveter.class)
    Money totalAmount;

    @Convert(converter = MoneyConveter.class)
    Money originalAmount;

}
