package com.example.springmodulithjmolecules.order.appcore.domain.model;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.common.model.MoneyConveter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    OrderItem(Long productId, Integer quantity, Money price, Money discount) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.originalAmount = new Money(quantity * price.value());
        this.totalAmount = originalAmount.subtract(discount);
    }

    @Id
    @Identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long productId;

    Integer quantity;

    @Convert(converter = MoneyConveter.class)
    Money price;

    @Convert(converter = MoneyConveter.class)
    Money discount;

    @Convert(converter = MoneyConveter.class)
    Money totalAmount;

    @Convert(converter = MoneyConveter.class)
    Money originalAmount;

}
