package com.example.springmodulithjmolecules.order.appcore.domain.model;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.common.model.MoneyConveter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode(of = "id")
@AggregateRoot
@Table(name = "orders")
public class Order extends AbstractAggregateRoot<Order> {

    protected Order() {

    }

    public Order(OrderCode orderCode) {
        this.orderCode = orderCode;
        this.orderItems = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Identity
    Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    List<OrderItem> orderItems;

    @Convert(converter = OrderCodeConveter.class)
    @Setter
    OrderCode orderCode;

    @Convert(converter = MoneyConveter.class)
    Money totalPrice;

    public OrderItem addOrderItem(Long productId, Integer quality, Money price, Money discount) {
        OrderItem orderItem = new OrderItem(productId, quality, price, discount);
        orderItems.add(orderItem);
        calculateTotalPrice();
        return orderItem;
    }

    protected void calculateTotalPrice() {
        Double totalPrice = 0.0d;
        for (OrderItem item : orderItems) {
            totalPrice += item.getTotalAmount().value();
        }
        this.totalPrice = new Money(totalPrice);
    }
}
